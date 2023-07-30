package com.sms.repository;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.model.StudentMaster;

@Repository("studentMasterRepo")
public interface StudentMasterRepository extends JpaRepository<StudentMaster, Long>{

	List<StudentMaster> findByAdmissionNumber(String admissionNumber);

	boolean existsByAdmissionNumber(String admissionNumber);
	
	
	
}
