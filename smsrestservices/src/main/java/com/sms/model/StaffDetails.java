package com.sms.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "staff_details")
public class StaffDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String firstName ;

    private String lastName ;

    private String email ;

    private String contactNumber ;

    private String adharNumber ;

    private Timestamp dateOfBirth ;

    private Timestamp dateOfJoin ;

    private String pfNumber ;

    private String qualification ;
    
    private String subject ;

    private String previousSchool ;

    private String allotedClasses ;

    private String isCertificatesSubmitted ;

    private String experience ;

    private String employeeId ;

    private String createdBy ;

    private Timestamp creationTime ;

    private String lastUpdatedBy ;

    private Timestamp lastUpdateDate ;
    
}
