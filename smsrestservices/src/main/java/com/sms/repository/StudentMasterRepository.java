package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.model.StudentMaster;

@Repository("studentMasterRepo")
public interface StudentMasterRepository extends JpaRepository<StudentMaster, Long>{
	
}
