package com.womentechMakers.demo.controller;

import com.womentechMakers.demo.model.User;
import com.womentechMakers.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User createdUser = userService.save(user);

        return ResponseEntity.ok(user);
    }

    @GetMapping(path = "/users")
    ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getAll();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping(path = "/user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.update(user);
        return new  ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/user/{id}")
    public void deleteUser(@PathVariable(value = "id") long id) {
        userService.delete(id);
    }
}
