package me.mrodriguezdev.apibiblioteca.application.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import me.mrodriguezdev.apibiblioteca.domains.models.BookingDTO;
import me.mrodriguezdev.apibiblioteca.domains.ports.in.BookinInputPort;
import me.mrodriguezdev.apibiblioteca.domains.ports.out.BookingOutputPort;

@ApplicationScoped
public class BookingUserCase implements BookinInputPort {

    @Inject
    BookingOutputPort bookingOutputPort;

    @Override
    public void reserveBook(BookingDTO bookingDTO) {
        this.bookingOutputPort.reserveBook(bookingDTO);
    }
}
