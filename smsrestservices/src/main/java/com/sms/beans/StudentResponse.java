package com.sms.beans;


import lombok.Data;

@Data
public class StudentResponse {
	/**
	 * student personal info
	 */
	private String admissionNumber ;
	private String firstName ;
	private String lastName ;
	private String studentClass ;
	
	/**
	 * student fee info
	 */
	private String feeDate ;
	private double aFee,examFee ;
	private double dFee ;
	private double finalFee ;
	private double t1,t2,t3,balance ;
	
	private String message ;
	
	
	
	

}
