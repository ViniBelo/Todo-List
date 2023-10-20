package com.estudos.todo.dto;

import com.estudos.todo.domain.entities.User;

public class UserDTO {
    User user;

    public UserDTO(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
