package com.example.transnationalgroupshipping.controller;

import com.example.transnationalgroupshipping.model.User;
import com.example.transnationalgroupshipping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AuthController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/v1/auth")
    public ResponseEntity<?> authenticateUser (@RequestBody User user){
        Map<String, Boolean> response = new HashMap<>();
        response.put("login-result", Boolean.FALSE);

        Optional<User> existingUser = userRepository.findById(user.getUsername());
        if (existingUser.isPresent()){
            if (existingUser.get().getPassword().equals( user.getPassword())){
                response.put("login-result", Boolean.TRUE);
            }
        }

        return ResponseEntity.ok(response);
    }
}
