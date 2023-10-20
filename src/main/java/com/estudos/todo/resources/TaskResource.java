package com.estudos.todo.resources;

import com.estudos.todo.domain.entities.Task;
import com.estudos.todo.dto.TaskDTO;
import com.estudos.todo.services.TaskService;
import com.estudos.todo.views.TaskView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {
    private final TaskView taskView;
    private final TaskService taskService;

    public TaskResource(TaskView taskView, TaskService taskService) {
        this.taskView = taskView;
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAll() {
        List<Task> tasks = taskView.findAll();
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        Task task = taskView.findById(id);
        return ResponseEntity.ok().body(task);
    }

    @PostMapping
    public ResponseEntity<Task> insert(@RequestBody Task task) {
        task = taskService.insert(new TaskDTO(task));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(task.getId()).toUri();
        return ResponseEntity.created(uri).body(task);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task task) {
        task = taskService.update(id, new TaskDTO(task));
        return ResponseEntity.ok().body(task);
    }
}
