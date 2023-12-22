package me.mrodriguezdev.apibiblioteca.domains.ports.in;

import jakarta.enterprise.context.ApplicationScoped;
import me.mrodriguezdev.apibiblioteca.domains.models.BookingDTO;

@ApplicationScoped
public interface BookinInputPort {
    void reserveBook(BookingDTO bookingDTO);
}
