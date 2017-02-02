package application.generatorController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class  CustomPrintStream extends PrintStream{
    public CustomPrintStream(OutputStream out) {
        super(out);
    }

    @Override
    public void println(String x) {
        super.println("[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-M-dd HH:mm:ss")) + "] " + x);
    }
    //override  print  methods here
}



@Path("/businessrule")
public class RESTService {

    @GET
    @Path("/generate")
    @Consumes("application/json")
    public Response generateBusinessRule(String JSONArray) {
        //TODO add type to JSON response
        System.setOut(new CustomPrintStream(System.out));
        System.out.println("Generate call with: \n" + JSONArray.toString());
        JSONObject jOutput = new JSONObject();
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
                jOutputArray.put(new JSONObject(jOutputItem.toString()));
            }
            jOutput.put("type", "output");
            jOutput.put("output", jOutputArray);
        } catch (JSONException e) {
            return getJSONErrorMessage("Incorrect input");
        } catch (Exception e) {
            return getJSONErrorMessage(e.getMessage());
        }

        System.out.println("Generated output: \n" + jOutput.toString());
        return Response.status(200).entity(jOutput.toString()).build();
    }

    private Response getJSONErrorMessage(String value) {
        try {
            JSONObject jOutputItem = new JSONObject();
            jOutputItem.put("type", "error");
            jOutputItem.put("message", value);
            String output = jOutputItem.toString();
            System.out.println(output);
            return Response.status(500).entity(output).build();
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    @GET
    @Path("/execute")
    @Consumes("application/json")
    public Response executeTriggerCode(String JSONArray) {
        JSONObject jOutput = new JSONObject();
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
            jOutput.put("type", "output");
            jOutput.put("output", generator.generateParentTrigger((Integer) jArray.get(0), generatedTriggers));
        } catch (JSONException e) {
            return getJSONErrorMessage("Incorrect input");
        } catch (Exception e) {
            return getJSONErrorMessage(e.getMessage());
        }
        System.out.println("Executed with output:\n" + jOutput.toString());
        return Response.status(200).entity(jOutput.toString()).build();
    }

}