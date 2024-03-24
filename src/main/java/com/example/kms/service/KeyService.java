package com.example.kms.service;

import com.example.kms.entity.Audience;
import com.example.kms.entity.Key;
import com.example.kms.entity.KeyState;
import com.example.kms.form.KeyForm;
import com.example.kms.repository.AudienceRepository;
import com.example.kms.repository.KeyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KeyService {
    private final KeyRepository keyRepository;
    private final AudienceRepository audienceRepository;

    public Key createKey(KeyForm form){
        Audience audience = audienceRepository.findById(form.getAudience_id())
                .orElseThrow(() -> new RuntimeException("Not found user audience id = " + form.getAudience_id()));
        return keyRepository.save(new Key(audience, form.getKeyState(), form.isMain()));
    }

    public List<Key> getAllKeys(){
        return keyRepository.findAll();
    }

    public Key updateKey(Integer id, KeyForm form){
        Key key = keyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found user audience id = " + id));
        Audience audience = audienceRepository.findById(form.getAudience_id())
                .orElseThrow(() -> new RuntimeException("Not found user audience id = " + form.getAudience_id()));
        key.setKeyState(form.getKeyState());
        key.setAudience(audience);
        key.setMain(form.isMain());
        return keyRepository.save(key);
    }
}
