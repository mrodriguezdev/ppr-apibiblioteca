package me.mrodriguezdev.apibiblioteca.infraestructure.controllers;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
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
    @Path("register")
    public Response createUser(UserDTO userDTO) {
        this.userInputPort.createUser(userDTO);
        return Response.noContent().build();
    }

    @POST
    @Path("personal")
    @RolesAllowed("admin")
    public Response createPersonal(UserDTO userDTO) {
        this.userInputPort.createPersonal(userDTO);
        return Response.noContent().build();
    }

    @POST
    @Path("admin")
    @RolesAllowed("admin")
    public Response createAdmin(UserDTO userDTO) {
        this.userInputPort.createAdmin(userDTO);
        return Response.noContent().build();
    }

    @GET
    @Path("list")
    @RolesAllowed("admin")
    public List<UserDTO> listAll() {
        return this.userInputPort.listAll();
    }

    @GET
    @Path("{id}")
    @RolesAllowed("admin")
    public UserDTO findById(@PathParam("id") Long id) {
        return this.userInputPort.findById(id);
    }

    @PUT
    @Path("update")
    @Authenticated
    public UserDTO update(UserDTO userDTO) {
        return this.userInputPort.update(userDTO);
    }

    @DELETE
    @Path("delete/{id}")
    @RolesAllowed("admin")
    public Response delete(@PathParam("id") Long id) {
        this.userInputPort.delete(id);
        return Response.accepted().build();
    }
}
