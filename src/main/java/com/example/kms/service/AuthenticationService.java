package com.example.kms.service;

import com.example.kms.entity.Role;
import com.example.kms.entity.User;
import com.example.kms.form.*;
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
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public Response register(RegForm form) {
        var user = User.builder()
                .username(form.getUsername())
                .password(passwordEncoder.encode(form.getPassword()))
                .employee_id(form.getEmployee_id())
                .salt(form.getSalt())
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return Response.builder()
                .token(jwtToken)
                .build();
    }

    public Response auth(LoginForm form) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword()));
        var user = userRepository.findByUsername(form.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return Response.builder()
                .token(jwtToken)
                .build();
    }

}
