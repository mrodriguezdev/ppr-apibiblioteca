package me.mrodriguezdev.apibiblioteca.domains.ports.out;

import jakarta.enterprise.context.ApplicationScoped;
import me.mrodriguezdev.apibiblioteca.domains.models.BookingDTO;

@ApplicationScoped
public interface BookingOutputPort {
    void reserveBook(BookingDTO bookingDTO);
}
