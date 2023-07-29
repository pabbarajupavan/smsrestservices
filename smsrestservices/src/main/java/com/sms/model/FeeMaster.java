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
@Table(name = "sms_fee_master")
public class FeeMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long fee_master_id ;
	
	@Column(name = "syl_type")
	private String syllabusType ;
	
	@Column(name = "class_section")
	private String group ;
	
	@Column(name = "tution_fee")
	private double tutionFee ;
	
	@Column(name = "transport_fee")
	private double transportFee ;
	
	@Column(name = "accessory_fee")
	private double accessoryFee ;
	
	@Column(name = "lib_fee")
	private double libraryFee ;
	
	@Column(name = "exam_fee")
	private double examFee ;
	
	@Column(name = "hostel_fee")
	private double hostelFee ;
	
	@Column(name = "annual_fee")
	private double annualFee ;
	
	@Column(name = "discount")
	private double discount ;
	
	@Column(name = "updated_by")
	private String updatedBy ;
	
	@Column(name = "created_by")
	private String createdBy ;
	
	@Column(name = "creation_time")
	private Timestamp creationTime ;
	
	@Column(name = "last_updated_time")
	private Timestamp lastUpdatedTime ;
	
}
