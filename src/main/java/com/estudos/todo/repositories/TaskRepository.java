package com.estudos.todo.repositories;

import com.estudos.todo.domain.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
