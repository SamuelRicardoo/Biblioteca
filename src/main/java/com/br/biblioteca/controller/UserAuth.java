package com.br.biblioteca.controller;

import com.br.biblioteca.model.User;
import com.br.biblioteca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserAuth {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        boolean savedUser = userService.saveUser(user);
        return savedUser
                ? ResponseEntity.status(HttpStatus.CREATED).body("User created successfully.")
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists.");
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.findAll());
    }


}
