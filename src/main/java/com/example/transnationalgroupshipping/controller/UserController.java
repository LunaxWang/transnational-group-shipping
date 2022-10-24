package com.example.transnationalgroupshipping.controller;

import com.example.transnationalgroupshipping.model.User;
import com.example.transnationalgroupshipping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }




}
