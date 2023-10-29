package com.sms.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "student_fee_details")
public class Fee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fee_id ;
	
	@Column(name = "admission_number")
	private String admissionNumber ;
	
	
	
	@Column(name ="exam_fee")
	private double examFee;
	
	@Column(name ="tution_fee")
	private double tutionFee;
	
	@Column(name ="hostel_fee")
	private double hostelFee;
	
	@Column(name ="transport_fee")
	private double transportFee;
	
	@Column(name = "amount_paid")
	private double amountPaid ;
	
	@Column(name ="balance")
	private double balance ;
	
		
	@Column(name = "updated_by")
	private String updatedBy ;
	
	@Column(name = "created_by")
	private String createdBy ;
	
	@Column(name = "creation_time")
	private Timestamp creationTime ;
	
	@Column(name = "last_updated_time")
	private Timestamp lastUpdatedTime ;
	
	@Column(name = "bill_number")
	private long billNumber ;
	
	
	
}
