package com.example.watcher.entity;

import javax.persistence.*;

@Entity
@Table(name = "todo")
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Boolean completed;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public TodoEntity() {
    }

    public Long getId() {
        return id;
    }

    public TodoEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public TodoEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public TodoEntity setCompleted(Boolean completed) {
        this.completed = completed;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public TodoEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TodoEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
