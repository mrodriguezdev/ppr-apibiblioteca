package me.mrodriguezdev.apibiblioteca.infraestructure.adapters;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import me.mrodriguezdev.apibiblioteca.domains.models.UserDTO;
import me.mrodriguezdev.apibiblioteca.domains.ports.out.UserOutputPort;
import me.mrodriguezdev.apibiblioteca.infraestructure.entities.User;
import me.mrodriguezdev.apibiblioteca.infraestructure.mappers.UserMapper;
import me.mrodriguezdev.apibiblioteca.infraestructure.repositories.UserRepository;

import java.util.Optional;

@ApplicationScoped
public class UserAdapter implements UserOutputPort {

    @Inject
    UserRepository userRepository;

    @Inject
    UserMapper userMapper;

    @Override
    @Transactional
    public void createUser(UserDTO userDTO) {
        User user = this.userMapper.toEntity(userDTO);
        this.userRepository.persist(user);
    }

    @Override
    public UserDTO findById(Long id){
        return null;
    }

    @Override
    public Optional<UserDTO> updateUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
