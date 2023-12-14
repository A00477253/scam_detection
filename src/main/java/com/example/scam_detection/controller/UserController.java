package com.example.scam_detection.controller;

import org.springframework.web.bind.annotation.*;

import com.example.scam_detection.entity.User;
import com.example.scam_detection.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/get")
    public User getUser(@RequestParam Integer id){
        return userService.getUserById(id);
    }
    
}
