package com.example.kms.service;

import com.example.kms.entity.Operation;
import com.example.kms.entity.Shift;
import com.example.kms.form.OperationForm;
import com.example.kms.repository.OperationRepository;
import com.example.kms.repository.ShiftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OperationService {

    private final OperationRepository operationRepository;
    private final ShiftRepository shiftRepository;

    public Operation createOperation(OperationForm form) {
        return operationRepository.save(new Operation(form.getKey(), form.getEmployee(), form.getShift(), form.getGive_date_time(), null));
    }

    public List<Operation> getAllOperations(){
        return operationRepository.findAll();
    }

    public List<Operation> getAllOperationsByShiftId(Integer shiftId){
        Shift shift = shiftRepository.findById(shiftId)
                .orElseThrow(() -> new RuntimeException("Not found shift with id = " + shiftId));
        return operationRepository.findAllByShift(shift);
    }

}
