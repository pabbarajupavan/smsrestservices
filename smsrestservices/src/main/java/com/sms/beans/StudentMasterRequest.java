package com.sms.beans;

import java.sql.Timestamp;

import jakarta.persistence.Column;

public class StudentMasterRequest {
	
	private RequestHeader reqHdr ;
	
	
	private String fisrtName ;
	
	
	private String lastName ;
	
	
	private String fatherName ;
	
	
	private String motherName ;
	
	
	private Timestamp dateOfBirth ;
	
	
	private Long studentMobileNumber ;
	
	
	private Long parentMobileNumber ;
	
	
	private Long adharNumber ;
	
	
	private String address ;
	
	
	private Timestamp dateOfJoin ;
	
	
	private String joiningOfClass ;
	
	
	private String previousSchool;
	
	
	private int tcNumber ;
	
	
	private char tcCheck ;
	
	
	private char feeCheck ;
	
	
	private String updatedBy ;
	
	
	private String createdBy ;
	
	
	private Timestamp creationTime ;
	
	
	private Timestamp lastUpdatedTime ;

}
