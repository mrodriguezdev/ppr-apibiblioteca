package me.mrodriguezdev.apibiblioteca.application.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import me.mrodriguezdev.apibiblioteca.domains.models.RolDTO;
import me.mrodriguezdev.apibiblioteca.domains.ports.in.RolInputPort;
import me.mrodriguezdev.apibiblioteca.domains.ports.out.RolOutputPort;

@ApplicationScoped
public class RolUserCase implements RolInputPort {

    @Inject
    RolOutputPort rolOutputPort;

    @Override
    public RolDTO findById(Integer id) {
        return this.rolOutputPort.findById(id);
    }
}
