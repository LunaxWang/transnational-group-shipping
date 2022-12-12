package com.example.transnationalgroupshipping.controller;

import com.example.transnationalgroupshipping.model.User;
import com.example.transnationalgroupshipping.repository.UserRepository;
import com.example.transnationalgroupshipping.utils.PwdHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LoginController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser (@RequestBody User user){
        Map<String, Boolean> response = new HashMap<>();

        //use select count of the (username and hashed password). If getting 0, no authorize.
        String hashedPassword = PwdHelper.getHash(user.getPassword());
        int count = userRepository.countByUsernameAndPassword(user.getUsername(), hashedPassword);
        if (count == 0) {
            response.put("login-result", Boolean.FALSE);
        }else {
            response.put("login-result", Boolean.TRUE);
        }

//        Optional<User> existingUser = userRepository.findById(user.getUsername());
//        if (existingUser.isPresent()){
//            if (existingUser.get().getPassword().equals( user.getPassword())){
//                response.put("login-result", Boolean.TRUE);
//            }
//        }
        return ResponseEntity.ok(response);

    }
}
