package com.example.kms.service;

import com.example.kms.entity.Audience;
import com.example.kms.form.AudienceForm;
import com.example.kms.repository.AudienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AudienceService {
    private final AudienceRepository audienceRepository;
    public Audience createAudience(AudienceForm form) {
        return audienceRepository.save(new Audience(form.getNumber(), form.getFloor(), form.getCapacity(), form.getSignalisation(), form.getAudienceType()));
    }

    public List<Audience> getAllAudiences() {
        return audienceRepository.findAll();
    }
}
