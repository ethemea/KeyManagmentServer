package com.example.kms.service;

import com.example.kms.entity.*;
import com.example.kms.form.OperationForm;
import com.example.kms.repository.EmployeeRepository;
import com.example.kms.repository.KeyRepository;
import com.example.kms.repository.OperationRepository;
import com.example.kms.repository.ShiftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OperationService {

    private final OperationRepository operationRepository;
    private final ShiftRepository shiftRepository;
    private final KeyRepository keyRepository;
    private final EmployeeRepository employeeRepository;

    public Operation createOperation(OperationForm form) {
        Key key = keyRepository.findById(form.getKey_id())
                .orElseThrow(() -> new RuntimeException("Not found key with id = " + form.getKey_id()));
        Employee employee = employeeRepository.findById(form.getEmployee_id())
                .orElseThrow(() -> new RuntimeException("Not found employee with id = " + form.getEmployee_id()));
        Shift shift = shiftRepository.findById(form.getShift_id())
                .orElseThrow(() -> new RuntimeException("Not found shift with id = " + form.getShift_id()));
        return operationRepository.save(new Operation(key, employee, shift, new Timestamp(System.currentTimeMillis()), null));
    }

    public List<Operation> getAllOperations() {
        return operationRepository.findAll();
    }

    public List<Operation> getAllOperationsByShiftId(Integer shiftId) {
        Shift shift = shiftRepository.findById(shiftId)
                .orElseThrow(() -> new RuntimeException("Not found shift with id = " + shiftId));
        return operationRepository.findAllByShift(shift);
    }

    public Operation getOperation(Integer id) {
        return operationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found operation with id = " + id));
    }

    public Operation endOperation(Integer id) {
        Operation operation = operationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found operation with id = " + id));
        if (operation.getReturn_date_time() != null)
            throw new RuntimeException("Operation has already ended");
        operation.setReturn_date_time(new Timestamp(System.currentTimeMillis()));
        return operationRepository.save(operation);
    }

}
