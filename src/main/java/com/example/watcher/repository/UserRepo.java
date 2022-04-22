package com.example.watcher.repository;

import com.example.watcher.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);

}
