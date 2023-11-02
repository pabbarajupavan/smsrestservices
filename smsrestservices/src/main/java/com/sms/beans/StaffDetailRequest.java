package com.sms.beans;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class StaffDetailRequest {

    private RequestHeader reqHdr ;

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
