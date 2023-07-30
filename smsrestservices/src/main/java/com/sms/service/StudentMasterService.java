package com.sms.service;

import com.sms.beans.StudentMasterRequest;
import com.sms.beans.StudentResponse;


public interface StudentMasterService {
	
	public String enrollStudent(StudentMasterRequest request) ;

	public StudentResponse fetchStudentInfoForFeePayaments(String admissionNumber);

}
