package me.mrodriguezdev.apibiblioteca.infraestructure.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.mrodriguezdev.apibiblioteca.domains.models.BookingDTO;
import me.mrodriguezdev.apibiblioteca.domains.ports.in.BookinInputPort;

@Path("booking")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookingController {

    @Inject
    BookinInputPort bookinInputPort;

    @POST
    public Response reserveBook(BookingDTO bookingDTO) {
        this.bookinInputPort.reserveBook(bookingDTO);
        return Response.ok().entity("Book reserved successfully").build();
    }
}
