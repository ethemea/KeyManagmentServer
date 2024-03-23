package com.example.kms.form;

import com.example.kms.entity.EmployeeType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmployeeForm {
    @NotBlank
    private String firstName;
    @NotBlank
    private String secondName;
    @NotBlank
    private String middleName;
    @NotBlank
    private String photoUrl;
    @NotBlank
    private EmployeeType employeeType;

}
