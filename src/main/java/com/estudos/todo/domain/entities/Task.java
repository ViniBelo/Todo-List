package com.estudos.todo.domain.entities;

import com.estudos.todo.domain.entities.enums.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public final class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    public Task() { }

    public Task(Long id, String name, String description, Status status, User owner) {
        this.id = id;
        this.name = name;
        this.description = description;
        setStatus(status);
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return Status.valueOf(status);
    }

    public void setStatus(Status status) {
        if (status != null) {
            this.status = status.getStatus();
        }
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Task updateData(Task task) {
        task.setName(getName());
        task.setDescription(getDescription());
        task.setStatus(getStatus());
        return task;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Task task = (Task) object;

        if (!id.equals(task.id)) return false;
        if (!name.equals(task.name)) return false;
        return description.equals(task.description);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", owner=" + owner +
                '}';
    }
}