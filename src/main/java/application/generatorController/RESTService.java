package application.generatorController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/generatebusinessrule")
public class RESTService {

    @GET
    @Path("/{businessRuleID}")
    // Uncomment for get body, function param should be "String msg"
    // @Consumes("text/plain")
    public Response getMsg(@PathParam("businessRuleID") String businessRuleID) {

        String output = "Jersey say : " + businessRuleID;

        System.out.println(output);

        return Response.status(200).entity(output).build();

    }

}