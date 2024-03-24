package com.example.kms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Entity(name = "audiences")
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Audience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer audience_id;
    private Integer number;
    private Integer floor;
    private Integer capacity;
    @Enumerated(EnumType.STRING)
    private Signalisation signalisation;
    @Enumerated(EnumType.STRING)
    private AudienceType audienceType;

    public Audience(Integer number, Integer floor, Integer capacity, Signalisation signalisation, AudienceType audienceType) {
        this.number = number;
        this.floor = floor;
        this.capacity = capacity;
        this.signalisation = signalisation;
        this.audienceType = audienceType;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Signalisation getSignalisation() {
        return signalisation;
    }

    public void setSignalisation(Signalisation signalisation) {
        this.signalisation = signalisation;
    }

    public AudienceType getAudienceType() {
        return audienceType;
    }

    public void setAudienceType(AudienceType audienceType) {
        this.audienceType = audienceType;
    }

    public Integer getAudience_id() {
        return audience_id;
    }
}
