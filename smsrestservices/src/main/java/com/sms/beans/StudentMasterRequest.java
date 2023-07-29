package com.sms.beans;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class StudentMasterRequest {
	
	private RequestHeader reqHdr ;
	
	
	private String firstName ;
	
	
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
	
	private String admissionNumber ;
	
	private String previousSchool;
	
	private String syllabus ;
	
	private int tcNumber ;
	
	
	private String tcCheck ;
	
	private String dayScholor;
	
	
	private String feeCheck ;
	
	
	private String updatedBy ;
	
	
	private String createdBy ;
	
	
	private Timestamp creationTime ;
	
	
	private Timestamp lastUpdatedTime ;

}
