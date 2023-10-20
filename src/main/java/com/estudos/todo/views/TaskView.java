package com.estudos.todo.views;

import com.estudos.todo.domain.entities.Task;
import com.estudos.todo.repositories.TaskRepository;
import com.estudos.todo.services.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public class TaskView {
    private final TaskRepository taskRepository;

    public TaskView(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> listAll() {
        return taskRepository.findAll();
    }

    public Task findById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
