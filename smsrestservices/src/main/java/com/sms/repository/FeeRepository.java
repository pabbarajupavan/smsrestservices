package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.model.Fee;

@Repository("feeRepository")
public interface FeeRepository extends JpaRepository<Fee, Long>{

	Fee findByAdmissionNumber(String admissionNumber);

}
