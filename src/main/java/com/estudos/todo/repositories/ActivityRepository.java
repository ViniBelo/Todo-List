package com.estudos.todo.repositories;

import com.estudos.todo.domain.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
