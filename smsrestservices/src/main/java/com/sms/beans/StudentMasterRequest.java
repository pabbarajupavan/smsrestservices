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
	
	private Long parentMobileNumber ;
	
	private Long adharNumber ;
	
	private String address ;
	
	private Timestamp dateOfJoin ;
	
	private String joiningOfClass ;
	
	private String presentClass ;
	
	private String syllabus;
	
	private String admissionNumber ;
	
	private String previousSchool;
	
	private int tcNumber ;
	
	private String dayScholorCheck ;
	
	private String transportCheck ;
	
	private String tcCheck ;
	
	private String feeCheck ;
	
	private String updatedBy ;
	
	private String createdBy ;
	
	private Timestamp creationTime ;
	
	private Timestamp lastUpdatedTime ;

}
