package me.mrodriguezdev.apibiblioteca.infraestructure.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import me.mrodriguezdev.apibiblioteca.infraestructure.entities.Booking;

@ApplicationScoped
public class BookingRepository implements PanacheRepositoryBase<Booking, Long> {
}
