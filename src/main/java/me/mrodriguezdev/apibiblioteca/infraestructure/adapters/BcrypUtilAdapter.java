package me.mrodriguezdev.apibiblioteca.infraestructure.adapters;

import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;
import me.mrodriguezdev.apibiblioteca.domains.ports.out.BcryptUtilOutputPort;

@ApplicationScoped
public class BcrypUtilAdapter implements BcryptUtilOutputPort {

    @Override
    public String bcryptHash(String plainTextPassword) {
        return BcryptUtil.bcryptHash(plainTextPassword);
    }

    @Override
    public boolean bcryptCheck(String plainTextPassword, String hashedPassword) {
        return BcryptUtil.matches(plainTextPassword, hashedPassword);
    }
}
