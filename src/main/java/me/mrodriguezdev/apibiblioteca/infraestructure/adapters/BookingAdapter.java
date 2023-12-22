package me.mrodriguezdev.apibiblioteca.infraestructure.adapters;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import me.mrodriguezdev.apibiblioteca.domains.models.BookingDTO;
import me.mrodriguezdev.apibiblioteca.domains.ports.out.BookingOutputPort;
import me.mrodriguezdev.apibiblioteca.domains.ports.out.UserOutputPort;
import me.mrodriguezdev.apibiblioteca.infraestructure.entities.Booking;
import me.mrodriguezdev.apibiblioteca.infraestructure.repositories.BookingRepository;

@ApplicationScoped
public class BookingAdapter implements BookingOutputPort {

    @Inject
    BookingRepository bookingRepository;

    @Inject
    UserOutputPort userOutputPort;

    @Override
    @Transactional
    public void reserveBook(BookingDTO bookingDTO) {
        this.validateUser(bookingDTO.getUsuario());

        Booking booking = new Booking();
        booking.setUsuario(bookingDTO.getUsuario());
        booking.setIsbn(bookingDTO.getIsbn());
        booking.setFecha_reserva(bookingDTO.getFecha());

        this.bookingRepository.persist(booking);
    }

    private void validateUser(Long id) {
        this.userOutputPort.findById(id);
    }
}
