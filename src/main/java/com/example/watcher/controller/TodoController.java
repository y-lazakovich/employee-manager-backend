package com.example.watcher.controller;

import com.example.watcher.entity.TodoEntity;
import com.example.watcher.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestParam Long userId,
                                     @RequestBody TodoEntity todo) {
        try {
            return ResponseEntity.ok(todoService.createTodo(todo, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Exception");
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity completeTodo(@PathVariable Long todoId) {
        try {
            return ResponseEntity.ok(todoService.complete(todoId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Exception");
        }
    }
}