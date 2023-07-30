package com.sms.beans;

import lombok.Data;

@Data
public class PaymentRequest {
	
	private RequestHeader reqHdr ;
	private StudentMasterRequest studentRequest ;
	private double aFee ;
	private double dFee ;
	private double fFee,examFee ;
	private double t1,t2,t3 ;
	private double balance ;
	
	private String reference ;
	
	

}
