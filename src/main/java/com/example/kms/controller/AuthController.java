package com.example.kms.controller;

import com.example.kms.entity.User;
import com.example.kms.form.*;
import com.example.kms.service.AuthenticationService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService service;

    @PostMapping("/users/auth")
    public ResponseEntity<AuthResponse> auth(@RequestBody AuthForm form) {
        return ResponseEntity.ok(service.auth(form));
    }

    /*@PostMapping("/users/register")
    public ResponseEntity<RegResponse> register(@RequestBody RegForm form) {
        return ResponseEntity.ok(service.register(form));
    }*/

    @PostMapping("/employees/{employeeId}/user")
    public ResponseEntity<User> createUser(@PathVariable(value = "employeeId") Integer employeeId,
                                           @RequestBody RegForm form) {
        return new ResponseEntity<>(service.createUser(employeeId, form), HttpStatus.CREATED);
    }

}