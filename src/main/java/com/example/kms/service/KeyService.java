package com.example.kms.service;

import com.example.kms.entity.Key;
import com.example.kms.form.KeyForm;
import com.example.kms.repository.KeyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KeyService {
    private final KeyRepository keyRepository;

    public Key createKey(KeyForm form){
        return keyRepository.save(new Key(form.getAudience(), form.getKeyState(), form.isMain()));
    }

    public List<Key> getAllKeys(){
        return keyRepository.findAll();
    }
}
