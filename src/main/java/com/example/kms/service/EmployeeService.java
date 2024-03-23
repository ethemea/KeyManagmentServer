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
        List<Employee> employees = new ArrayList<>();
        //if (title == null)
            employees.addAll(employeeRepository.findAll()); // employeeRepository.findAll().forEach(employees::add);
        /*else
            employeeRepository.findByTitleContaining(title).forEach(employees::add);*/
        return employees;

    }

    public Employee createEmployee(EmployeeForm employee) {
        Employee _employee = employeeRepository.save(new Employee(employee.getFirst_name(), employee.getSecond_name(), employee.getMiddle_name(), employee.getPhoto_url(), employee.getType()));
        return _employee;
    }

    public Employee getEmployeeById(Integer id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found Employee with id = " + id));
        return employee;
    }

    public Employee updateEmployee(Integer id, EmployeeForm employee) {
        Employee _employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found Employee with id = " + id));
        _employee.setFirst_name(employee.getFirst_name());
        _employee.setSecond_name(employee.getSecond_name());
        _employee.setMiddle_name(employee.getMiddle_name());
        _employee.setMiddle_name(employee.getPhoto_url());
        _employee.setType(employee.getType());
        return employeeRepository.save(_employee);
    }

    public void deleteEmployee (Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
        employeeRepository.deleteById(id);
    }
}
