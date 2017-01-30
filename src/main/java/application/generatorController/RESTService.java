package application.generatorController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/generatebusinessrule")
public class RESTService {
    @GET
    @Consumes("application/json")
    public Response getMsg(String businessRuleID) {
        String output = "";
        Generator generator = new Generator();

        try
        {
            JSONObject jObject = new JSONObject(businessRuleID);
            JSONArray jArray = jObject.getJSONArray("businessrules");

            for(int i = 0; i < jArray.length(); i++){
                output += generator.generateTriggerCodeByRuleId(Integer.parseInt(Integer.toString((Integer)jArray.get(i))));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return Response.status(200).entity(output).build();
    }

}