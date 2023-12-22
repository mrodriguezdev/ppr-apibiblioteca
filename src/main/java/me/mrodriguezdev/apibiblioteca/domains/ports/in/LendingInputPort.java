package me.mrodriguezdev.apibiblioteca.domains.ports.in;

import jakarta.enterprise.context.ApplicationScoped;
import me.mrodriguezdev.apibiblioteca.domains.models.LendingDTO;

@ApplicationScoped
public interface LendingInputPort {
    void createLending(LendingDTO lendingDTO);
}
