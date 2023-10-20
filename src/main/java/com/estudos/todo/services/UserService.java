package com.estudos.todo.services;

import com.estudos.todo.domain.entities.User;
import com.estudos.todo.dto.UserDTO;
import com.estudos.todo.repositories.UserRepository;
import com.estudos.todo.services.exceptions.DatabaseException;
import com.estudos.todo.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User insert(UserDTO userDTO) {
        return userRepository.save(userDTO.user());
    }

    public void delete(Long id) {
        if (id != null) {
            try {
                userRepository.deleteById(id);
            } catch (EmptyResultDataAccessException e) {
                throw new ResourceNotFoundException(id);
            } catch (DataIntegrityViolationException e) {
                throw new DatabaseException(e.getMessage());
            }
        } else {
            throw new NullPointerException();
        }
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
