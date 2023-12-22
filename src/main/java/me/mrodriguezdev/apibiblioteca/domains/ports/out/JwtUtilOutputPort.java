package me.mrodriguezdev.apibiblioteca.domains.ports.out;

import jakarta.enterprise.context.ApplicationScoped;
import me.mrodriguezdev.apibiblioteca.domains.models.AuthResponseDTO;


@ApplicationScoped
public interface JwtUtilOutputPort {
    String generateToken(AuthResponseDTO.Data data);
}
