package com.example.kms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Entity(name = "watches")
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Watch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer watch_id;
    private Integer building_number;

    public Watch(Integer building_number) {
        this.building_number = building_number;
    }

    public Integer getBuilding_number() {
        return building_number;
    }

    public void setBuilding_number(Integer building_number) {
        this.building_number = building_number;
    }

    public Integer getWatch_id() {
        return watch_id;
    }
}
