package me.mrodriguezdev.apibiblioteca.domains.ports.in;

import jakarta.enterprise.context.ApplicationScoped;
import me.mrodriguezdev.apibiblioteca.domains.models.AuthResponseDTO;
import me.mrodriguezdev.apibiblioteca.domains.models.LoginDTO;

@ApplicationScoped
public interface AuthInputPort {
    AuthResponseDTO login(LoginDTO loginDTO);
}
