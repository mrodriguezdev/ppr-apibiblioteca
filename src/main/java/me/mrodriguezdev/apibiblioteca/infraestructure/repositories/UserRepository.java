package me.mrodriguezdev.apibiblioteca.infraestructure.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import me.mrodriguezdev.apibiblioteca.infraestructure.entities.User;

@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<User, Long> {
    public User findByEmail(String email) {
        return find("correo = ?1", email).firstResult();
    }
}
