package com.estudos.todo.views;

import com.estudos.todo.domain.entities.Task;
import com.estudos.todo.repositories.TaskRepository;
import com.estudos.todo.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskView {
    private final TaskRepository taskRepository;

    public TaskView(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
