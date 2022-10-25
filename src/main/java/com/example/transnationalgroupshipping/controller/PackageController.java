package com.example.transnationalgroupshipping.controller;

import com.example.transnationalgroupshipping.model.Package;
import com.example.transnationalgroupshipping.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/v1")
public class PackageController {

    @Autowired
    private PackageRepository packageRepository;

    @GetMapping("/packages")
    public List<Package> getAllPackages(){ return packageRepository.findAll();}



}
