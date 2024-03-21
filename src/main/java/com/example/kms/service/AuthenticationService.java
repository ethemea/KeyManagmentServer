package com.example.kms.service;

import com.example.kms.entity.Employee;
import com.example.kms.entity.Role;
import com.example.kms.entity.User;
import com.example.kms.form.*;
import com.example.kms.repository.EmployeeRepository;
import com.example.kms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public RegResponse register(RegForm form) {
        var user = User.builder()
                .username(form.getUsername())
                .password(passwordEncoder.encode(form.getPassword()))
                .salt(form.getSalt())
                .role(form.getRole()) // !!!
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return RegResponse.builder()
                .token(jwtToken)
                .build();
    }

    public User createUser(Integer employeeId, RegForm form) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Not found employee with id = " + employeeId));
        var user = User.builder()
                .username(form.getUsername())
                .password(passwordEncoder.encode(form.getPassword()))
                .employee(employee)
                .salt(form.getSalt())
                .role(Role.USER) // !!!
                .build();
        userRepository.save(user);
        return user;
    }

    public AuthResponse auth(AuthForm form) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword()));
        var user = userRepository.findByUsername(form.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var employeeId = user.getEmployee().getEmployee_id();
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Not found employee with id = " + employeeId));
        return AuthResponse.builder()
                .token(jwtToken)
                .username(user.getUsername())
                .employee(employee)
                .build();
    }

}
