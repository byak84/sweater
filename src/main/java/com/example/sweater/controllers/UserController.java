package com.example.sweater.controllers;

import com.example.sweater.config.JwtUtil;
import com.example.sweater.domains.AppUser;
import com.example.sweater.repos.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final JwtUtil jwtUtil;
    @Autowired
    AppUserRepo appUserRepo;

    public UserController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AppUser appUser) {
        return new ResponseEntity<>(jwtUtil.generateToken(appUser), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AppUser>> GetAll() {
        return new ResponseEntity<>(appUserRepo.findAll(), HttpStatus.OK);
    }
}
