package com.example.kms.service;

import com.example.kms.entity.Watch;
import com.example.kms.repository.WatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WatchService {
    private final WatchRepository watchRepository;
    public Watch createWatch(Integer buildingNumber){
        return watchRepository.save(new Watch(buildingNumber));
    }

    public List<Watch> getAllWatches() {
        return  watchRepository.findAll();
    }

    public Watch getWatchById(Integer id) {
        return watchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found Watch with id = " + id));
    }
}
