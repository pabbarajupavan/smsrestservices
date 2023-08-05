package com.sms.model;

import java.sql.Timestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sms_student_master")
public class StudentMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long student_master_id ;
	
	@Column(name = "first_name")
	private String firstName ;
	
	@Column(name = "last_name")
	private String lastName ;
	
	@Column(name = "father_name")
	private String fatherName ;
	
	@Column(name = "mother_name")
	private String motherName ;
	
	@Column(name = "dob")
	private Timestamp dateOfBirth ;
	
	@Column(name = "s_mobile")
	private Long studentMobileNumber ;
	
	@Column(name = "p_mobile")
	private Long parentMobileNumber ;
	
	@Column(name = "adhaar_no")
	private Long adharNumber ;
	
	@Column(name = "address")
	private String address ;
	
	@Column(name = "doj")
	private Timestamp dateOfJoin ;
	
	@Column(name = "joc")
	private String joiningOfClass ;
	
	@Column(name = "sclass")
	private String presentClass ;
	
	@Column(name = "syllabus")
	private String syllabus;
	
	@Column(name = "admission_no")
	private String admissionNumber ;
	
	@Column(name = "previous_school")
	private String previousSchool;
	
	@Column(name = "tc_num")
	private int tcNumber ;
	
	@Column(name = "day_scholor")
	private String dayScholor ;
	
	@Column(name = "tc_check")
	private String tcCheck ;
	
	@Column(name = "fee_check")
	private String feeCheck ;
	
	@Column(name = "updated_by")
	private String updatedBy ;
	
	@Column(name = "created_by")
	private String createdBy ;
	
	@Column(name = "creation_time")
	private Timestamp creationTime ;
	
	@Column(name = "last_updated_time")
	private Timestamp lastUpdatedTime ;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "studentmaser")
	private Fee fees ;
	
	
	
}
