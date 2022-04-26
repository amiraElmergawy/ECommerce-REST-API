package gov.iti.jets.presentation.controllers;

import gov.iti.jets.service.dtos.user.UserPostRequest;
import gov.iti.jets.service.servicesImpl.ClerkServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("clerks")
public class ClerkController {

    @GET
    @Path("{cid}")
    @Produces({ "application/xml; qs=0.75", "application/json; qs=1" })
    public Response getAllClerks(@PathParam("cid") int id) {
        return Response.ok(ClerkServiceImpl.INSTANCE.getClerkById(id).get()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClerks() {
        return Response.ok(ClerkServiceImpl.INSTANCE.getClerks()).build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createClerk(UserPostRequest Clerk) {
        System.out.println(Clerk);
        ClerkServiceImpl.INSTANCE.createClerk(Clerk.getUsername(), Clerk.getPassword(), Clerk.getEmail(), Clerk.getPhone());
    }

    @PUT
    @Path("{cid}")
    @Consumes({ "application/xml;", "application/json;" })
    public void updateClerk(@PathParam("cid") int id, UserPostRequest Clerk) {
        ClerkServiceImpl.INSTANCE.updateClerk(Clerk.getUsername(), Clerk.getPassword(), Clerk.getEmail(), Clerk.getPhone(), id);
    }

    @DELETE
    @Path("{cid}")
    public void deleteClerk(@PathParam("cid") int id) {
        ClerkServiceImpl.INSTANCE.deleteClerk(id);
    }

}
