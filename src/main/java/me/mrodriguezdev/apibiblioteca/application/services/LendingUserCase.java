package me.mrodriguezdev.apibiblioteca.application.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import me.mrodriguezdev.apibiblioteca.domains.models.LendingDTO;
import me.mrodriguezdev.apibiblioteca.domains.ports.in.LendingInputPort;
import me.mrodriguezdev.apibiblioteca.domains.ports.out.LendingOutputPort;

@ApplicationScoped
public class LendingUserCase implements LendingInputPort {

    @Inject
    LendingOutputPort lendingOutputPort;

    @Override
    public void createLending(LendingDTO lendingDTO) {
        this.lendingOutputPort.createLending(lendingDTO);
    }
}
