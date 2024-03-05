package com.example.kms.controller;

import com.example.kms.service.AuthenticationService;
import com.example.kms.form.LoginForm;

import com.example.kms.form.LoginResponse;
import com.example.kms.form.RegForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Api("Auth controller")
public class AuthController {

    private final AuthenticationService service;

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/login")
    @ApiOperation("Log In for user")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginForm form) {
        return ResponseEntity.ok(service.login(form));
    }

    @PostMapping("/reg")
    @ApiOperation("User registration")
    public ResponseEntity<LoginResponse> reg(@RequestBody RegForm form) {
        return ResponseEntity.ok(service.reg(form));
    }
}