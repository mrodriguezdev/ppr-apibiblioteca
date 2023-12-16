package me.mrodriguezdev.apibiblioteca.domains.ports.out;

import jakarta.enterprise.context.ApplicationScoped;
import me.mrodriguezdev.apibiblioteca.domains.models.UserDTO;

import java.util.Optional;

@ApplicationScoped
public interface UserOutputPort {
    void createUser(UserDTO userDTO);
    UserDTO findById(Long id);
    Optional<UserDTO> updateUser(UserDTO userDTO);
    void deleteUser(Long id);
}
