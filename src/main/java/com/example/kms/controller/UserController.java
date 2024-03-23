package com.example.kms.controller;


import com.example.kms.entity.Employee;
import com.example.kms.entity.User;
import com.example.kms.form.RegForm;
import com.example.kms.service.UserService;
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
public class UserController {
    private final UserService service;
    @Operation(summary = "Get all users", description = "Returns users data")
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        var users = service.getAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(summary = "Update user data", description = "Returns updated user data")
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody RegForm form) {
        return new ResponseEntity<>(service.updateUser(form, id), HttpStatus.OK);
    }

    @Operation(summary = "Delete user by id", description = " ")
    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Integer id) {
        service.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*

    @GetMapping({ "/users/{id}", "/employees/{id}/user" })
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found user with id = " + id));

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{employeeId}/user")
    public ResponseEntity<User> deleteUserOfEmployee(@PathVariable(value = "employeeId") Integer employeeId) {
        if (!employeeRepository.existsById(employeeId)) {
            throw new RuntimeException("Not found Employee with id = " + employeeId);
        }

        userRepository.deleteByEmployeeId(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/
}
