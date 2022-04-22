package com.example.watcher.model;

import com.example.watcher.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class User {

    private Long id;
    private String username;
    private List<Todo> todos;

    public static User toModel(UserEntity entity) {
        return new User()
                .setId(entity.getId())
                .setUsername(entity.getUsername())
                .setTodos(entity.getTodos().stream().map(Todo::toModel)
                        .collect(Collectors.toList()));
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public User setTodos(List<Todo> todos) {
        this.todos = todos;
        return this;
    }
}
