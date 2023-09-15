package com.example.bobu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bobu.Services.UserService;
import com.example.bobu.entity.User;

@RequestMapping("/Users")
@RestController
@CrossOrigin(origins = "http://localhost:3000") //  react.js 3000 ports for cors policy

public class UserController {
    private UserService userService;
    
    public UserController(UserService userService){
        this.userService=userService;
    }@GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userService.saveUser(newUser);
    }
    @GetMapping("/{UserID}")
    public User getById(@PathVariable Long UserID){
        return userService.getOneUser(UserID);
    }
    //update
    @PutMapping("/{UserID}")
    public User updateUserAge(@PathVariable Long UserID, @RequestBody User newUser){
        return userService.updateUser(UserID, newUser);
    }
}