package com.example.kms.form;

import com.example.kms.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AuthResponse {
    private String token;
    private String username;
    private Employee employee;
}