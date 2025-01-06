package com.example.kms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Entity(name = "divisions")
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer division_id;
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "divisions")
    private Set<Employee> employees = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "permissions_divisions",
            joinColumns = @JoinColumn(name = "division_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<Permission> permissions = new HashSet<>();

    public Division(String name) {
        this.name = name;
    }

    public void addPermission(Permission permission) {
        this.permissions.add(permission);
        permission.getDivisions().add(this);
    }

    public void removePermission(Integer permission_id) {
        Permission permission = this.permissions.stream().filter(p -> Objects.equals(p.getPermission_id(), permission_id)).findFirst().orElse(null);
        if (permission != null) {
            this.permissions.remove(permission);
            permission.getDivisions().remove(this);
        }
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public void setName(String name) {
        this.name = name;
    }
}
