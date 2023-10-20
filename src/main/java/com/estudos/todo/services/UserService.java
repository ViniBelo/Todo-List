package com.estudos.todo.services;

import com.estudos.todo.domain.entities.User;
import com.estudos.todo.dto.UserDTO;
import com.estudos.todo.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO insert(UserDTO userDTO) {;
        userRepository.save(userDTO.user());
        return userDTO;
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
