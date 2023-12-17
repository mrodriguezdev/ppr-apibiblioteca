package me.mrodriguezdev.apibiblioteca.domains.ports.in;

import jakarta.enterprise.context.ApplicationScoped;
import me.mrodriguezdev.apibiblioteca.domains.models.UserDTO;

@ApplicationScoped
public interface UserInputPort {
    void createUser(UserDTO userDTO);
    UserDTO findById(Long id);
    UserDTO updateUser(UserDTO userDTO);
    void deleteUser(Long id);
}
