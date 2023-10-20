package com.estudos.todo.config;

import com.estudos.todo.domain.entities.Task;
import com.estudos.todo.domain.entities.User;
import com.estudos.todo.domain.entities.enums.Status;
import com.estudos.todo.dto.TaskDTO;
import com.estudos.todo.dto.UserDTO;
import com.estudos.todo.services.TaskService;
import com.estudos.todo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Felipe Smith", 19);
        User user2 = new User(null, "Willian James", 21);
        User user3 = new User(null, "Arthur Pendragon", 20);
        UserDTO userDTO1 = new UserDTO(user1);
        UserDTO userDTO2 = new UserDTO(user2);
        UserDTO userDTO3 = new UserDTO(user3);

        userService.insert(userDTO1);
        userService.insert(userDTO2);
        userService.insert(userDTO3);


        Task task1 = new Task(null, "Lavar roupa", "Preciso lavar as roupas sujas", Status.IN_PROGRESS, user2);
        TaskDTO taskDTO1 = new TaskDTO(task1);
        Task task2 = new Task(null, "Fazer almoço", "Preciso cozinhar o almoço", Status.TO_DO, user1);
        TaskDTO taskDTO2 = new TaskDTO(task2);

        taskService.insert(taskDTO1);
        taskService.insert(taskDTO2);

        taskService.delete(taskDTO1);

        userService.delete(userDTO2.user().getId());
    }
}
