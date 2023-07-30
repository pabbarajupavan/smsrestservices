package com.sms.beans;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class FeeMasterRequest {
	
	private RequestHeader reqHdr ;
	private String syllabusType ;
	

	private String group ;
	

	private int tutionFee ;
	

	private int transportFee ;
	

	private int accessoryFee ;
	
	
	private int libraryFee ;
	

	private int examFee ;
	
	private int hostelFee ;
	

	private int annualFee ;
	

	private int discount ;
	
	

}
