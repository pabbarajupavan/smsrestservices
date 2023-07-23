package com.sms.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sms_fee")
public class Fee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fee_id ;
	
	@Column(name = "admission_number")
	private String admissionNumber ;
	
	@Column(name ="a_fee")
	private int aFee;
	
	@Column(name ="d_fee")
	private int dFee;
	
	@Column(name ="f_fee")
	private int fFee;
	
	@Column(name ="t1")
	private int t1;
	
	@Column(name ="t2")
	private int t2;
	
	@Column(name ="t3")
	private int t3;
	
	@Column(name ="balance")
	private int balance;
	
	@Column(name = "reference")
	private String reference ;
	
	@Column(name = "updated_by")
	private String updatedBy ;
	
	@Column(name = "created_by")
	private String createdBy ;
	
	@Column(name = "creation_time")
	private Timestamp creationTime ;
	
	@Column(name = "last_updated_time")
	private Timestamp lastUpdatedTime ;
	
}
