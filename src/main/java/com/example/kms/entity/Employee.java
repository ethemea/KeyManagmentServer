package com.example.kms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Entity(name = "employees")
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employee_id;
    private String first_name;
    private String second_name;
    private String middle_name;
    private String photo_url;
    @Enumerated(EnumType.STRING)
    private EmployeeType employee_type;

    public Employee(String first_name, String second_name, String middle_name, String photo_url, EmployeeType employee_type) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.middle_name = middle_name;
        this.photo_url = photo_url;
        this.employee_type = employee_type;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public void setEmployee_type(EmployeeType employee_type) {
        this.employee_type = employee_type;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public EmployeeType getEmployee_type() {
        return employee_type;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }
}
