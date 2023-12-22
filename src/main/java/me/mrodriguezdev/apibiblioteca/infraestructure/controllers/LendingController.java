package me.mrodriguezdev.apibiblioteca.infraestructure.controllers;

import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.mrodriguezdev.apibiblioteca.domains.models.LendingDTO;
import me.mrodriguezdev.apibiblioteca.domains.ports.in.LendingInputPort;

@Path("lending")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Authenticated
public class LendingController {

    @Inject
    LendingInputPort lendingInputPort;

    @POST
    public Response createLending(LendingDTO lendingDTO) {
        this.lendingInputPort.createLending(lendingDTO);
        return Response.ok().entity("Lending created successfully").build();
    }
}
