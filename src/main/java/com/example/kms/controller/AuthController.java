package com.example.kms.controller;

import com.example.kms.form.*;
import com.example.kms.service.AuthenticationService;

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
    /*@PostMapping("/watchmen/login")
    @ApiOperation("Log In for watchman")
    public ResponseEntity<Response> watchmanLogin(@RequestBody LoginForm form) {
        return ResponseEntity.ok(service.watchmanLogin(form));
    }

    @PostMapping("/watchmen/reg")
    @ApiOperation("Watchman registration")
    public ResponseEntity<Response> watchmanReg(@RequestBody RegForm form) {
        return ResponseEntity.ok(service.watchmanReg(form));
    }*/

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/users/auth")
    @ApiOperation("Log In for user")
    public ResponseEntity<Response> auth(@RequestBody LoginForm form) {
        return ResponseEntity.ok(service.auth(form));
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/users/register")
    @ApiOperation("User registration")
    public ResponseEntity<Response> register(@RequestBody RegForm form) {
        return ResponseEntity.ok(service.register(form));
    }

}