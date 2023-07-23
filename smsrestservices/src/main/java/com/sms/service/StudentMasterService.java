package com.sms.service;

import org.springframework.stereotype.Service;

import com.sms.beans.StudentMasterRequest;

@Service("studentMasterService")
public interface StudentMasterService {
	
	public String enrollStudent(StudentMasterRequest request) ;

}
