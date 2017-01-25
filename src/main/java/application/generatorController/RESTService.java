package application.generatorController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/generatebusinessrule")
public class RESTService {
    @GET
    @Path("/{businessRuleID}")
    public Response getMsg(@PathParam("businessRuleID") String businessRuleID) {
        Generator generator = new Generator();
        String output = generator.generateBusinessRuleById(Integer.parseInt(businessRuleID));

        return Response.status(200).entity(output).build();
    }

}