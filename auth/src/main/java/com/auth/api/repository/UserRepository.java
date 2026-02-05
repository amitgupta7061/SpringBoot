package com.auth.api.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.auth.api.models.User;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}