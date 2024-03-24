package com.example.kms.controller;

import com.example.kms.entity.Watch;
import com.example.kms.service.WatchService;
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
public class WatchController {
    private final WatchService service;

    /*@Operation(summary = "Get all watches", description = "Returns watches data")
    @GetMapping("/watches")
    public ResponseEntity<List<Watch>> getAllWatches() {
        var watches = service.getAllWatches();
        if (watches.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(watches, HttpStatus.OK);
    }

    @Operation(summary = "Get watch by id", description = "Returns watch data")
    @GetMapping("/watches/{id}")
    public ResponseEntity<Watch> getWatchById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(service.getWatchById(id), HttpStatus.OK);
    }
    @Operation(summary = "Watch creation", description = "Returns watch data after successful creation")
    @PostMapping("/watches")
    public ResponseEntity<Watch> createWatch(Integer buildingNumber) {
        return new ResponseEntity<>(service.createWatch(buildingNumber), HttpStatus.CREATED);
    }*/
}
