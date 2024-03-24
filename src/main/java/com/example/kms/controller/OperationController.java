package com.example.kms.controller;

import com.example.kms.entity.Operation;
import com.example.kms.form.OperationForm;
import com.example.kms.service.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OperationController {
    private final OperationService service;

    @io.swagger.v3.oas.annotations.Operation(summary = "Get all operations", description = "Returns operations data")
    @GetMapping("/operations")
    public ResponseEntity<List<Operation>> getAllOperations(){
        var operations = service.getAllOperations();
        if (operations.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(operations, HttpStatus.OK);
    }

    @io.swagger.v3.oas.annotations.Operation(summary = "Operation creation", description = "Returns operation data after successful creation")
    @PostMapping("/operations")
    public ResponseEntity<Operation> createOperation(@RequestBody OperationForm form) {
        return new ResponseEntity<>(service.createOperation(form), HttpStatus.CREATED);
    }

    @io.swagger.v3.oas.annotations.Operation(summary = "Get all operations by user id", description = "Returns operations data")
    @GetMapping("users/{userId}/operations")
    public ResponseEntity<List<Operation>> getAllOperations(@PathVariable("userId") Integer userId){
        var operations = service.getAllOperationsByShiftId(userId);
        if (operations.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(operations, HttpStatus.OK);
    }
}
