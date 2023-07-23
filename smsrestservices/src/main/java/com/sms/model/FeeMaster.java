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
@Table(name = "cms_fee_master")
public class FeeMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fee_master_id ;
	
	@Column(name = "syl_type")
	private String syllabusType ;
	
	@Column(name = "class")
	private String sClass ;
	
	@Column(name = "tution_fee")
	private int tutionFee ;
	
	@Column(name = "transport_fee")
	private int transportFee ;
	
	@Column(name = "accessory_fee")
	private int accessoryFee ;
	
	@Column(name = "lib_fee")
	private int libraryFee ;
	
	@Column(name = "exam_fee")
	private int examFee ;
	
	@Column(name = "annual_fee")
	private int annualFee ;
	
	@Column(name = "discount")
	private int discount ;
	
	@Column(name = "updated_by")
	private String updatedBy ;
	
	@Column(name = "created_by")
	private String createdBy ;
	
	@Column(name = "creation_time")
	private Timestamp creationTime ;
	
	@Column(name = "last_updated_time")
	private Timestamp lastUpdatedTime ;
	
}
