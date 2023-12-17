package me.mrodriguezdev.apibiblioteca.infraestructure.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import me.mrodriguezdev.apibiblioteca.domains.models.RolDTO;
import me.mrodriguezdev.apibiblioteca.domains.ports.in.RolInputPort;

@Path("rol")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RolController {

    @Inject
    RolInputPort rolInputPort;

    @GET
    @Path("{id}")
    public RolDTO findById(@PathParam("id") Integer id) {
        return this.rolInputPort.findById(id);
    }
}
