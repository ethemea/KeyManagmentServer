package com.example.kms.form;

import com.example.kms.entity.AudienceType;
import com.example.kms.entity.Signalisation;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AudienceForm {
    @NotBlank
    private Integer number;
    @NotBlank
    private Integer floor;
    @NotBlank
    private Integer capacity;
    @NotBlank
    private Signalisation signalisation;
    @NotBlank
    private AudienceType audienceType;
}
