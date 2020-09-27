package com.example.sweater.controllers;

import com.example.sweater.jwt.JwtUtil;
import com.example.sweater.domains.AppUser;
import com.example.sweater.repos.AppUserRepo;
import com.example.sweater.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    AppUserService userService;

    public UserController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AppUser appUser) {
        AppUser user = userService.findByLoginAndPassword(appUser.getUsername(), appUser.getPassword());
        if (user != null) {
            return new ResponseEntity<>(jwtUtil.generateToken(appUser), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping
    public ResponseEntity<List<AppUser>> GetAll() {
        return new ResponseEntity<>(appUserRepo.findAll(), HttpStatus.OK);
    }
}
