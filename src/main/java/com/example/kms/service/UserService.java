package com.example.kms.service;

import com.example.kms.entity.Employee;
import com.example.kms.entity.Role;
import com.example.kms.entity.User;
import com.example.kms.form.RegForm;
import com.example.kms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<User> getAllUsers() {
        //if (title == null)
        List<User> users = new ArrayList<>(userRepository.findAll()); // userRepository.findAll().forEach(employees::add);
        /*else userRepository.findByTitleContaining(title).forEach(employees::add);*/
        return users;

    }

    public User updateUser(RegForm form, Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id " + id + " not found"));
        user.setPassword(form.getUsername());
        user.setPassword(form.getPassword());
        user.setSalt(form.getSalt());
        user.setRole(form.getRole());
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

   /* public Employee createEmployee(EmployeeForm employee) {

        Employee _employee = userRepository.save(new Employee(employee.getFirst_name(),
        employee.getSecond_name(), employee.getMiddle_name(), employee.getPhoto_url(), employee.getType()));
        return _employee;
    }

    public Employee getEmployeeById(Integer id) {
        Employee employee = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found Employee with id = " + id));
        return employee;
    }*/
}
