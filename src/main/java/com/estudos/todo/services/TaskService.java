package com.estudos.todo.services;

import com.estudos.todo.domain.entities.Task;
import com.estudos.todo.dto.TaskDTO;
import com.estudos.todo.repositories.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService (TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task insert(TaskDTO taskDTO) {
        return taskRepository.save(taskDTO.task());
    }

    public void delete(TaskDTO taskDTO) {
        taskRepository.delete(taskDTO.task());
    }
}
