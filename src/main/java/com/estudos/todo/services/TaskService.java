package com.estudos.todo.services;

import com.estudos.todo.domain.entities.Task;
import com.estudos.todo.domain.entities.User;
import com.estudos.todo.dto.TaskDTO;
import com.estudos.todo.dto.UserDTO;
import com.estudos.todo.repositories.TaskRepository;
import com.estudos.todo.services.exceptions.DatabaseException;
import com.estudos.todo.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService (TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task insert(TaskDTO taskDTO) {
        return taskRepository.save(taskDTO.task());
    }

    public void delete(Long id) {
        if (id != null) {
            try {
                taskRepository.deleteById(id);
            } catch (EmptyResultDataAccessException e) {
                throw new ResourceNotFoundException(id);
            } catch (DataIntegrityViolationException e) {
                throw new DatabaseException(e.getMessage());
            }
        } else {
            throw new NullPointerException();
        }
    }

    public Task update(Long id, TaskDTO taskDTO) {
        try {
            Task entity = taskRepository.getReferenceById(id);
            taskDTO.task().updateData(entity);
            return taskDTO.task();
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }
}
