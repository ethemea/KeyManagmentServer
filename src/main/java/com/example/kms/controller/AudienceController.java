package com.example.kms.controller;

import com.example.kms.entity.Audience;
import com.example.kms.form.AudienceForm;
import com.example.kms.service.AudienceService;
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
public class AudienceController {
    private final AudienceService service;
    @Operation(summary = "Get all audiences", description = "Returns audiences data")
    @GetMapping("/audiences")
    public ResponseEntity<List<Audience>> getAllAudiences() {
        var audiences = service.getAllAudiences();
        if (audiences.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(audiences, HttpStatus.OK);
    }
    @Operation(summary = "Audience creation", description = "Returns audience data after successful creation")
    @PostMapping("/audiences")
    public ResponseEntity<Audience> createAudience(@RequestBody AudienceForm form) {
        return new ResponseEntity<>(service.createAudience(form), HttpStatus.CREATED);
    }
}
