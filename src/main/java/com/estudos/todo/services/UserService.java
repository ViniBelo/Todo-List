package com.estudos.todo.services;

import com.estudos.todo.domain.entities.User;
import com.estudos.todo.dto.UserDTO;
import com.estudos.todo.repositories.UserRepository;
import com.estudos.todo.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User insert(UserDTO userDTO) {;
        return userRepository.save(userDTO.user());
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(Long id, UserDTO userDTO) {
        try {
            User entity = userRepository.getReferenceById(id);
            userDTO.user().updateData(entity);
            return userDTO.user();
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }
}
