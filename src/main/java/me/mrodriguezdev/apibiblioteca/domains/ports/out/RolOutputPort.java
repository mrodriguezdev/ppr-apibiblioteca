package me.mrodriguezdev.apibiblioteca.domains.ports.out;

import jakarta.enterprise.context.ApplicationScoped;
import me.mrodriguezdev.apibiblioteca.domains.models.RolDTO;

@ApplicationScoped
public interface RolOutputPort {
    RolDTO findById(Integer id);
}
