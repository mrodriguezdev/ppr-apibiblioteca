package me.mrodriguezdev.apibiblioteca.domains.ports.out;

import jakarta.enterprise.context.ApplicationScoped;
import me.mrodriguezdev.apibiblioteca.domains.models.UserDTO;

import java.util.List;

@ApplicationScoped
public interface UserOutputPort {
    void create(UserDTO userDTO);

    List<UserDTO> listAll();

    UserDTO findByEmail(String email);

    UserDTO findById(Long id);

    UserDTO update(UserDTO userDTO);

    void delete(Long id);
}
