package com.estudos.todo.domain.entities.enums;

public enum Status {
    TO_DO(1),
    IN_PROGRESS(2),
    DONE(3);

    private int status;

    Status(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public static Status valueOf(int status) {
        for (Status status1: Status.values()) {
            if (status1.getStatus() == status) {
                return status1;
            }
        }
        throw new IllegalArgumentException("Invalid Status code!");
    }
}
