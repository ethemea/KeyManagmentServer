package com.example.kms.controller;

import com.example.kms.entity.Employee;
import com.example.kms.form.EmployeeForm;
import com.example.kms.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin/*(origins = "http://localhost:8081")*/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService service;
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        var employees = service.getAllEmployees();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeForm employee) {
        return new ResponseEntity<>(service.createEmployee(employee), HttpStatus.CREATED);
    }
    /* {
        "first_name": "Galina",
        "second_name": "Dubovaya",
        "middle_name": "Aleksandrovna",
        "photo_url": "C:\\photo3.jpg",
        "type": "SERVICE"
    }*/
/*
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
        Employee tutorial = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found Employee with id = " + id));

        return new ResponseEntity<>(tutorial, HttpStatus.OK);
    }



    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        Employee _employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found Employee with id = " + id));

        _employee.setFirst_name(employee.getFirst_name());
        _employee.setSecond_name(employee.getSecond_name());
        _employee.setMiddle_name(employee.getMiddle_name());
        _employee.setType(employee.getType());

        return new ResponseEntity<>(employeeRepository.save(_employee), HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }

        employeeRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

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
