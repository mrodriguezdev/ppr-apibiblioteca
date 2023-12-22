package me.mrodriguezdev.apibiblioteca.infraestructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "reservas")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long usuario;
    private String isbn;
    private LocalDateTime fecha_reserva;

    public Booking() {
    }

    public Booking(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDateTime getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(LocalDateTime fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) && Objects.equals(usuario, booking.usuario) && Objects.equals(isbn, booking.isbn) && Objects.equals(fecha_reserva, booking.fecha_reserva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, isbn, fecha_reserva);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", isbn='" + isbn + '\'' +
                ", fecha_reserva=" + fecha_reserva +
                '}';
    }
}
