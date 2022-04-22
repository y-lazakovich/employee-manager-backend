package com.example.watcher.service;

import com.example.watcher.entity.UserEntity;
import com.example.watcher.exception.UserAlreadyExistException;
import com.example.watcher.exception.UserNotFoundException;
import com.example.watcher.model.User;
import com.example.watcher.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("The user is exist");
        }
        return userRepo.save(user);
    }

    public User getUser(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException(String.format("The user with the follow id - %s - is not found", id));
        }
        return User.toModel(user);
    }

    public User deleteUser(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException(String.format("The user with the follow id - %s - can not be deleted", id));
        }
        userRepo.delete(user);
        return User.toModel(user);
    }

}
