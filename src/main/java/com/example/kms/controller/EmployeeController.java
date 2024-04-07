package com.example.kms.controller;

import com.example.kms.entity.Employee;
import com.example.kms.form.EmployeeForm;
import com.example.kms.service.EmployeeService;

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
public class EmployeeController {
    private final EmployeeService service;

    @Operation(summary = "Get all employees", description = "Returns employees data")
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        var employees = service.getAllEmployees();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @Operation(summary = "Employee creation", description = "Returns employee data after successful creation")
    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeForm employee) {
        return new ResponseEntity<>(service.createEmployee(employee), HttpStatus.CREATED);
    }

    @Operation(summary = "Get employee by id", description = "Returns employee data")
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(service.getEmployeeById(id), HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    @Operation(summary = "Update employee data", description = "Returns updated employee data")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Integer id, @RequestBody EmployeeForm employee) {
        return new ResponseEntity<>(service.updateEmployee(id, employee), HttpStatus.OK);
    }

    /*@DeleteMapping("/employees/{id}")
    @Operation(summary = "Delete employee data and its user data", description = " ")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") Integer id) {
        service.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/ // сделать fire employee
/*
    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteAllEmployees() {
        employeeRepository.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/

    /*@GetMapping("/tutorials/published")
    public ResponseEntity<List<Tutorial>> findByPublished() {
        List<Tutorial> tutorials = employeeRepository.findByPublished(true);

        if (tutorials.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tutorials, HttpStatus.OK);
    }*/
}
