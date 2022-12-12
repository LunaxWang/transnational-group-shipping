package com.example.transnationalgroupshipping.controller;

import com.example.transnationalgroupshipping.model.User;
import com.example.transnationalgroupshipping.repository.UserRepository;
import com.example.transnationalgroupshipping.utils.PwdHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> authenticateUser (@RequestBody User user){
        Map<String, Boolean> response = new HashMap<>();
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        String name = user.getUsername();
        String hashedPassword = PwdHelper.getHash(user.getPassword());
        boolean hasSameName = userRepository.existsByUsername(name);
        if (hasSameName) {
            response.put("register-result", Boolean.FALSE);
        }else {
            user.setPassword(hashedPassword);
            System.out.println(user.getPassword());
            response.put("register-result", Boolean.TRUE);
            userRepository.save(user);
        }
        return ResponseEntity.ok(response);
    }
}
