package application.generatorController;

import domain.generateDomain.facade.GenerateDomainService;
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
        JSONObject jOutput = new JSONObject();
        Generator generator = new Generator();

        try {
            JSONObject jObject = new JSONObject(JSONArray);
            JSONArray jArray = jObject.getJSONArray("businessrules");

            for (int i = 0; i < jArray.length(); i++) {
                String trigger = generator.generateTriggerCodeByRuleId((Integer) jArray.get(i));
                jOutput.put(Integer.toString((Integer) jArray.get(i)), trigger);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return Response.status(200).entity(jOutput.toString()).build();
    }

    @GET
    @Path("/execute")
    @Consumes("application/json")
    public Response executeTriggerCode(String JSONArray) {
        String output = "";
        Generator generator = new Generator();
        ArrayList<String> generatedTriggers = new ArrayList<String>();

        try {
            JSONObject jObject = new JSONObject(JSONArray);
            JSONArray jArray = jObject.getJSONArray("businessrules");

            for (int i = 0; i < jArray.length(); i++) {
                String trigger = GenerateDomainService.getInstance().getGeneratedTrigger((Integer) jArray.get(i));
                generatedTriggers.add(trigger);
            }
            output = generator.generateParentTrigger((Integer) jArray.get(0), jObject.getString("table"), generatedTriggers);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Response.status(200).entity(output).build();
    }

}