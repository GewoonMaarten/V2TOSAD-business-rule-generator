package application.generatorController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/businessrule")
public class RESTService {
    @GET
    @Path("/generate")
    @Consumes("application/json")
    public Response generateBusinessRule(String JSONArray) {
        System.out.println("Generate call with: \n" + JSONArray.toString());
        JSONObject jOutputItem = new JSONObject();
        JSONArray jOutputArray = new JSONArray();
        Generator generator = new Generator();

        try {
            JSONObject jObject = new JSONObject(JSONArray);
            JSONArray jArray = jObject.getJSONArray("businessrules");

            for (int i = 0; i < jArray.length(); i++) {
                String trigger = generator.generateTriggerCodeByRuleId((Integer) jArray.get(i));
                jOutputItem.put("id", jArray.get(i));
                jOutputItem.put("code", trigger);
                jOutputArray.put(jOutputItem);
            }
        } catch (JSONException e) {
            return Response.status(500).entity("Incorrect input").build();
        } catch (Exception e) {
            String output = e.getMessage();
            return Response.status(500).entity(output).build();
        }
        System.out.println("Generated output: \n" + jOutputArray.toString());
        return Response.status(200).entity(jOutputArray.toString()).build();
    }

    @GET
    @Path("/execute")
    @Consumes("application/json")
    public Response executeTriggerCode(String JSONArray) {
        String output;
        System.out.println("Execute call with: \n" + JSONArray.toString());
        Generator generator = new Generator();
        ArrayList<String> generatedTriggers = new ArrayList<String>();

        try {
            JSONObject jObject = new JSONObject(JSONArray);
            JSONArray jArray = jObject.getJSONArray("businessrules");

            for (int i = 0; i < jArray.length(); i++) {
                //Replace the code with this piece of code if you want to let the user change trigger code in APEX
                //String trigger = GenerateDomainService.getInstance().getGeneratedTrigger((Integer) jArray.get(i));
                String trigger = generator.generateTriggerCodeByRuleId((Integer)jArray.get(i));
                generatedTriggers.add(trigger);
            }
            output = generator.generateParentTrigger((Integer) jArray.get(0), jObject.getString("table"), generatedTriggers);
        } catch (JSONException e) {
            return Response.status(500).entity("Incorrect input").build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
        System.out.println("Executed with output:\n" + output);
        return Response.status(200).entity(output).build();
    }

}