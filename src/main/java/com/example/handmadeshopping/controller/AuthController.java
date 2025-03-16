package com.example.handmadeshopping.controller;

import EJB.model.User;
import com.example.handmadeshopping.service.UserService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Stateless
@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class AuthController {

    @Inject
    private UserService userService;

    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(User user) {
        User existingUser = userService.findByUsername(user.getName());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return Response.ok("Login successful!").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid username or password").build();
        }
    }

    @POST
    @Path("/register")
    public Response register(User user) {
        if (userService.findByUsername(user.getName()) != null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Username already exists").build();
        }
        if (userService.findByUsername(user.getName()) != null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Email already exists").build();
        }
        userService.registerUser(user);
        return Response.ok("User registered successfully!").build();
    }
}