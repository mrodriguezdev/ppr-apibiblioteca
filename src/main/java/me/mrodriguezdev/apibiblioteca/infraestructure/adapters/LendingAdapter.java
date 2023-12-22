package me.mrodriguezdev.apibiblioteca.infraestructure.adapters;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import me.mrodriguezdev.apibiblioteca.domains.models.LendingDTO;
import me.mrodriguezdev.apibiblioteca.domains.ports.out.LendingOutputPort;
import me.mrodriguezdev.apibiblioteca.domains.ports.out.UserOutputPort;
import me.mrodriguezdev.apibiblioteca.infraestructure.entities.Lending;
import me.mrodriguezdev.apibiblioteca.infraestructure.mappers.LendingMapper;
import me.mrodriguezdev.apibiblioteca.infraestructure.repositories.LendingRepository;

@ApplicationScoped
public class LendingAdapter implements LendingOutputPort {

    @Inject
    LendingRepository lendingRepository;

    @Inject
    LendingMapper lendingMapper;

    @Inject
    UserOutputPort userOutputPort;

    @Override
    @Transactional
    public void createLending(LendingDTO lendingDTO) {
        this.validateUser(lendingDTO.getUsuario());
        Lending lending = this.lendingMapper.toEntity(lendingDTO);
        this.lendingRepository.persist(lending);
    }

    private void validateUser(Long id) {
        this.userOutputPort.findById(id);
    }
}
