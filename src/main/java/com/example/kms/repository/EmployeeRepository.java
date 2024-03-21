package com.example.kms.repository;

import com.example.kms.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    /*@Transactional
    void deleteById(long id);

    @Transactional
    void deleteByEmployeeId(long employeeId);*/
}
