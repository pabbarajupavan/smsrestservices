package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.model.StaffDetails;

public interface StaffRepository extends JpaRepository<StaffDetails, Long>{

    boolean existsByEmployeeId(String employeeId);
    
}
