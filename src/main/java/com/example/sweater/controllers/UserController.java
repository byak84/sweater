package com.example.sweater.controllers;

import com.example.sweater.config.JwtUtil;
import com.example.sweater.domains.AppUser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final JwtUtil jwtUtil;

    public UserController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody AppUser appUser) {
        System.out.println(appUser.getUsername());
        return new ResponseEntity<>(jwtUtil.generateToken(appUser),HttpStatus.OK);
    }
}
