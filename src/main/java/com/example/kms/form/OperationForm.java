package com.example.kms.form;

import com.example.kms.entity.Employee;
import com.example.kms.entity.Key;
import com.example.kms.entity.Shift;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class OperationForm {
    @NotBlank
    private Key key;
    @NotBlank
    private Employee employee;
    @NotBlank
    private Shift shift;
    @NotBlank
    private Timestamp give_date_time;
}
