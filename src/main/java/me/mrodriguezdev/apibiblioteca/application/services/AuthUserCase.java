package me.mrodriguezdev.apibiblioteca.application.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import me.mrodriguezdev.apibiblioteca.domains.models.AuthResponseDTO;
import me.mrodriguezdev.apibiblioteca.domains.models.LoginDTO;
import me.mrodriguezdev.apibiblioteca.domains.ports.in.AuthInputPort;
import me.mrodriguezdev.apibiblioteca.domains.ports.out.AuthOutputPort;

@ApplicationScoped
public class AuthUserCase implements AuthInputPort {

    @Inject
    AuthOutputPort authOutputPort;

    @Override
    public AuthResponseDTO login(LoginDTO loginDTO) {
        return this.authOutputPort.login(loginDTO);
    }
}
