package me.mrodriguezdev.apibiblioteca.infraestructure.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.mrodriguezdev.apibiblioteca.domains.models.UserDTO;
import me.mrodriguezdev.apibiblioteca.domains.ports.in.UserInputPort;

import java.util.List;

@Path("user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserInputPort userInputPort;

    @POST
    public Response createUser(UserDTO userDTO) {
        this.userInputPort.createUser(userDTO);
        return Response.noContent().build();
    }

    @GET
    @Path("{id}")
    public UserDTO findById(@PathParam("id") Long id) {
        return this.userInputPort.findById(id);
    }

    @PUT
    public UserDTO updateUser(UserDTO userDTO) {
        return this.userInputPort.updateUser(userDTO);
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        this.userInputPort.deleteUser(id);
        return Response.accepted().build();
    }

    @GET
    @Path("all")
    public List<UserDTO> getAllUsers() {
        return this.userInputPort.getAllUsers();
    }
}
