package com.estudos.todo.dto;

import com.estudos.todo.domain.entities.Activity;

public class ActivityDTO {
    private Activity activity;

    public ActivityDTO(Activity activity) {
        this.activity = activity;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
