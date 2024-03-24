package com.example.kms.controller;

import com.example.kms.entity.Audience;
import com.example.kms.entity.Key;
import com.example.kms.entity.KeyState;
import com.example.kms.form.AudienceForm;
import com.example.kms.form.KeyForm;
import com.example.kms.service.KeyService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class KeyController {
    private final KeyService service;

    @Operation(summary = "Get all keys", description = "Returns keys data")
    @GetMapping("/keys")
    public ResponseEntity<List<Key>> getAllKeys() {
        var keys = service.getAllKeys();
        if (keys.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(keys, HttpStatus.OK);
    }
    @Operation(summary = "Key creation", description = "Returns key data after successful creation")
    @PostMapping("/keys")
    public ResponseEntity<Key> createKey(@RequestBody KeyForm form) {
        return new ResponseEntity<>(service.createKey(form), HttpStatus.CREATED);
    }
    @Operation(summary = "Update key", description = "Returns updated key data")
    @PutMapping("/keys/{id}")
    public ResponseEntity<Key> updateKey(@PathVariable("id") Integer id, KeyForm form) {
        return new ResponseEntity<>(service.updateKey(id, form), HttpStatus.OK);
    }
}
