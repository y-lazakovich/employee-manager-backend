package com.example.watcher.controller;

import com.example.watcher.entity.UserEntity;
import com.example.watcher.exception.UserAlreadyExistException;
import com.example.watcher.exception.UserNotFoundException;
import com.example.watcher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity registrate(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Exception has been happened");
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findUserById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.getUser(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Exception has been happened");
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.deleteUser(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Exception has been happened");
        }
    }

}
