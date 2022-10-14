package com.example.demo.controller.DTO;

public class countStatus {

    private Long completed;
    private Long cancel;

    public countStatus(Long completed, Long cancel) {
        this.completed = completed;
        this.cancel = cancel;
    }

    public Long getCompleted() {
        return completed;
    }

    public void setCompleted(Long completed) {
        this.completed = completed;
    }

    public Long getCancel() {
        return cancel;
    }

    public void setCancel(Long cancel) {
        this.cancel = cancel;
    }
}
