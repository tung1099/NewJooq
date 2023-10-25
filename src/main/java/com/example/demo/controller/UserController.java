package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.UserWithDepartment;
import com.example.demo.repository.IUserRepository;
import com.example.demo.repository.impl.UserRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    UserRepositoryImpl userRepository;

    @GetMapping
    public ResponseEntity<?> findAll(){
        log.info("\n---------------------------------------------------------------------------&gt;\n");
        log.info("[GET] ['{}']", ServletUriComponentsBuilder.fromCurrentRequest().build());
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        log.info("\n---------------------------------------------------------------------------&gt;\n");
        log.info("[GET] ['{}']", ServletUriComponentsBuilder.fromCurrentRequest().build());
        User users = userRepository.findById(id);
        return ResponseEntity.ok(users);
    }
    @GetMapping("/test")
    public ResponseEntity<?> findByAge(@RequestParam int age){
        log.info("\n---------------------------------------------------------------------------&gt;\n");
        log.info("[GET] ['{}']", ServletUriComponentsBuilder.fromCurrentRequest().build());
        List<User> users = userRepository.findUserByAge(age);
        return ResponseEntity.ok(users);
    }
    @GetMapping("/new")
    public ResponseEntity<?> find(){
        log.info("\n---------------------------------------------------------------------------&gt;\n");
        log.info("[GET] ['{}']", ServletUriComponentsBuilder.fromCurrentRequest().build());
        List<UserWithDepartment> users = userRepository.findUsersWithDepartments();
        return ResponseEntity.ok(users);
    }
}
