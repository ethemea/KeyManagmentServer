package com.example.kms.form;

import com.example.kms.entity.Type;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmployeeForm {
    @NotBlank
    private String first_name;
    @NotBlank
    private String second_name;
    @NotBlank
    private String middle_name;
    @NotBlank
    private String photo_url;
    @NotBlank
    private Type type;

}
