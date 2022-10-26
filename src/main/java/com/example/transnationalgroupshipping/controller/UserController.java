package com.example.transnationalgroupshipping.controller;

import com.example.transnationalgroupshipping.model.User;
import com.example.transnationalgroupshipping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<User> getUserByName(@PathVariable String username){
        User user = userRepository.findById(username)
                .orElseThrow(()->new RuntimeException("User not exist with id: " + username) );
        return ResponseEntity.ok(user);
    }

    @PutMapping("/users/{username}")
    public ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody User userNewVersion){
        User user = userRepository.findById(username)
                .orElseThrow(()->new RuntimeException("User not exist with name: " + username) );
        if (userNewVersion.getUsername() != null){
            user.setUsername(userNewVersion.getUsername());
        }
        if (userNewVersion.getPassword() != null){
            user.setPassword(userNewVersion.getPassword());
        }
        if (userNewVersion.getTelephone() != null){
            user.setTelephone(userNewVersion.getTelephone());
        }

        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("users/{username}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable String username){
        User user = userRepository.findById(username)
                .orElseThrow(()->new RuntimeException("User not exist with id: " + username) );
        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
