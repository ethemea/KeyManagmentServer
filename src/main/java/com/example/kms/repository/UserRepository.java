package com.example.kms.repository;

import com.example.kms.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    /*@Transactional
    void deleteByEmployeeId(Integer employeeId);*/
}
