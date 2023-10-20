package com.estudos.todo.resources;

import com.estudos.todo.domain.entities.User;
import com.estudos.todo.dto.UserDTO;
import com.estudos.todo.services.UserService;
import com.estudos.todo.views.UserView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    private final UserService userService;
    private final UserView userView;

    public UserResource(UserService userService, UserView userView) {
        this.userService = userService;
        this.userView = userView;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userView.listAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userView.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        user = userService.insert(new UserDTO(user));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        user = userService.update(id, new UserDTO(user));
        return ResponseEntity.ok().body(user);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
