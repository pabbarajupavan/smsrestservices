package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.model.FeeMaster;
@Repository("feeMasterRepository")
public interface FeeMasterRepository extends JpaRepository<FeeMaster, Long>{
	
}
