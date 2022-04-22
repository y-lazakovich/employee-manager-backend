package com.example.watcher.model;

import com.example.watcher.entity.TodoEntity;

public class Todo {

    private Long id;
    private String title;
    private Boolean completed;

    public static Todo toModel(TodoEntity entity) {
        return new Todo()
                .setId(entity.getId())
                .setTitle(entity.getTitle())
                .setCompleted(entity.getCompleted());
    }

    public Todo() {
    }

    public Long getId() {
        return id;
    }

    public Todo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Todo setTitle(String title) {
        this.title = title;
        return this;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public Todo setCompleted(Boolean completed) {
        this.completed = completed;
        return this;
    }
}
