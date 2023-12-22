package me.mrodriguezdev.apibiblioteca.domains.ports.out;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface BcryptUtilOutputPort {
    String bcryptHash(String plainTextPassword);

    boolean bcryptCheck(String plainTextPassword, String hashedPassword);
}
