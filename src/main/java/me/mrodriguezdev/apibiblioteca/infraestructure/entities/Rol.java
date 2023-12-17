package me.mrodriguezdev.apibiblioteca.infraestructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "roles")
public class Rol {
    @Id
    private Integer id;
    private String descripcion;

    public Rol() {
    }

    public Rol(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
