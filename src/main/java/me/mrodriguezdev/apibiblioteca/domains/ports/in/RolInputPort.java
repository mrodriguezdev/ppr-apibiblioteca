package me.mrodriguezdev.apibiblioteca.domains.ports.in;

import jakarta.enterprise.context.ApplicationScoped;
import me.mrodriguezdev.apibiblioteca.domains.models.RolDTO;

@ApplicationScoped
public interface RolInputPort {
    RolDTO findById(Integer id);
}
