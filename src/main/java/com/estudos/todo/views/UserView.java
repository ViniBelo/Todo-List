package com.estudos.todo.views;

import com.estudos.todo.domain.entities.User;
import com.estudos.todo.repositories.UserRepository;
import com.estudos.todo.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserView {
    private final UserRepository userRepository;

    public UserView(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
