package com.example.kms.form;

import com.example.kms.entity.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegForm {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String salt;
    @NotBlank
    private Role role;
}

