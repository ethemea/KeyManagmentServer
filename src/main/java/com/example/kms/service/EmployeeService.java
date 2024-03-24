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
        return employeeRepository.save(new Employee(employee.getFirst_name(), employee.getSecond_name(),
                employee.getMiddle_name(), employee.getPhoto_url(), employee.getEmployee_type()));
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found Employee with id = " + id));
    }

    public Employee updateEmployee(Integer id, EmployeeForm employee) {
        Employee _employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found Employee with id = " + id));
        _employee.setFirst_name(employee.getFirst_name());
        _employee.setSecond_name(employee.getSecond_name());
        _employee.setMiddle_name(employee.getMiddle_name());
        _employee.setMiddle_name(employee.getPhoto_url());
        _employee.setEmployee_type(employee.getEmployee_type());
        return employeeRepository.save(_employee);
    }

    public void deleteEmployee (Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
        employeeRepository.deleteById(id);
    }
}
