package com.example.kms.service;

import com.example.kms.entity.Employee;
import com.example.kms.form.EmployeeForm;
import com.example.kms.repository.EmployeeRepository;
import com.example.kms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeRepository.findAll());
    }

    public Employee createEmployee(EmployeeForm employee) {
        return employeeRepository.save(new Employee(employee.getFirstName(), employee.getSecondName(),
                employee.getMiddleName(), employee.getPhotoUrl(), employee.getEmployeeType()));
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found Employee with id = " + id));
    }

    public Employee updateEmployee(Integer id, EmployeeForm employee) {
        Employee _employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found Employee with id = " + id));
        _employee.setFirst_name(employee.getFirstName());
        _employee.setSecond_name(employee.getSecondName());
        _employee.setMiddle_name(employee.getMiddleName());
        _employee.setMiddle_name(employee.getPhotoUrl());
        _employee.setEmployeeType(employee.getEmployeeType());
        return employeeRepository.save(_employee);
    }

    public void deleteEmployee (Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
        employeeRepository.deleteById(id);
    }
}
