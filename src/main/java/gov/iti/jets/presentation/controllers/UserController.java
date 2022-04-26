package gov.iti.jets.presentation.controllers;

import jakarta.ws.rs.Path;
import gov.iti.jets.service.dtos.user.UserAuthPostRequest;
import gov.iti.jets.service.dtos.user.UserPostRequest;
import gov.iti.jets.service.servicesImpl.UserServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("users")
public class UserController {

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(UserAuthPostRequest user) {
        return Response.ok(UserServiceImpl.INSTANCE.login(user.getUsername(), user.getPassword()).get()).build();
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public void register(UserPostRequest user) {
        UserServiceImpl.INSTANCE.register(user.getUsername(), user.getPassword(), user.getEmail(), user.getPhone());
    }
}
