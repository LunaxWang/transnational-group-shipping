package com.example.transnationalgroupshipping.controller;

import com.example.transnationalgroupshipping.model.Package;
import com.example.transnationalgroupshipping.model.User;
import com.example.transnationalgroupshipping.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserHomeController {
    @Autowired
    private PackageRepository packageRepository;

    @PostMapping("/home")
    public List<Package> getAllPackagess(){
        return packageRepository.findAll();
    }


    @PostMapping("/addPackage")
    public void addPackage(@RequestBody Package pkg){
        Package p = packageRepository.save(pkg);
    }
}
