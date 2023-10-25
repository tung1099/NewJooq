package com.example.demo.repository;

import com.example.demo.common.BaseMongoRepository;
import com.example.demo.model.User;

import java.util.List;

public interface IUserRepository {
    List<User> findAll();
    User findById(String id);
    List<User> findUserByAge(int age);
}
