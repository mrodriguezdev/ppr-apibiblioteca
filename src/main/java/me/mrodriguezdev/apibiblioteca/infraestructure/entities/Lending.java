package me.mrodriguezdev.apibiblioteca.infraestructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "prestamos")
public class Lending {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long usuario;
    private String isbn;
    private LocalDateTime fecha_prestamo;
    private LocalDateTime fecha_devolucion;

    public Lending() {
    }

    public Lending(Long id) {
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

    public LocalDateTime getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(LocalDateTime fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public LocalDateTime getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(LocalDateTime fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lending lending = (Lending) o;
        return Objects.equals(id, lending.id) && Objects.equals(usuario, lending.usuario) && Objects.equals(isbn, lending.isbn) && Objects.equals(fecha_prestamo, lending.fecha_prestamo) && Objects.equals(fecha_devolucion, lending.fecha_devolucion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, isbn, fecha_prestamo, fecha_devolucion);
    }

    @Override
    public String toString() {
        return "Lending{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", isbn='" + isbn + '\'' +
                ", fecha_prestamo=" + fecha_prestamo +
                ", fecha_devolucion=" + fecha_devolucion +
                '}';
    }
}
