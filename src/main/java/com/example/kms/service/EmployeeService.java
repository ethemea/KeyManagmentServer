package com.example.kms.service;

import com.example.kms.entity.Employee;
import com.example.kms.form.EmployeeForm;
import com.example.kms.repository.EmployeeRepository;
import com.example.kms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployees(String title) {

        List<Employee> employees = new ArrayList<>();

        if (title == null)
            employees.addAll(employeeRepository.findAll()); // employeeRepository.findAll().forEach(employees::add);
        /*else
            employeeRepository.findByTitleContaining(title).forEach(employees::add);*/
        return employees;

    }

    public Employee createEmployee(EmployeeForm employee) {

        Employee _employee = employeeRepository.save(new Employee(employee.getFirst_name(), employee.getSecond_name(), employee.getMiddle_name(), employee.getPhoto_url(), employee.getType()));
        return _employee;
    }
}
