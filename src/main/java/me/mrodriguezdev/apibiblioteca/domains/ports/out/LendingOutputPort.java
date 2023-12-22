package me.mrodriguezdev.apibiblioteca.domains.ports.out;

import jakarta.enterprise.context.ApplicationScoped;
import me.mrodriguezdev.apibiblioteca.domains.models.LendingDTO;

@ApplicationScoped
public interface LendingOutputPort {
    void createLending(LendingDTO lendingDTO);
}
