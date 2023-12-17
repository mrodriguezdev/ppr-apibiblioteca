package me.mrodriguezdev.apibiblioteca.infraestructure.adapters;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import me.mrodriguezdev.apibiblioteca.domains.models.RolDTO;
import me.mrodriguezdev.apibiblioteca.domains.ports.out.RolOutputPort;
import me.mrodriguezdev.apibiblioteca.infraestructure.exceptions.NotFoundException;
import me.mrodriguezdev.apibiblioteca.infraestructure.mappers.RolMapper;
import me.mrodriguezdev.apibiblioteca.infraestructure.repositories.RolRepository;

@ApplicationScoped
public class RolAdapter implements RolOutputPort {

    @Inject
    RolRepository rolRepository;

    @Inject
    RolMapper rolMapper;

    @Override
    public RolDTO findById(Integer id) {
        return this.rolMapper.toDTO(this.rolRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Rol not found with ID: " + id)));
    }
}
