package com.sms.serviceimpl;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.beans.StaffDetailRequest;
import com.sms.model.StaffDetails;
import com.sms.repository.StaffRepository;
import com.sms.service.EmployeeService;



@Service("employeeService")
public class IEmployeeService implements EmployeeService{

    public static final Logger logger = LoggerFactory.getLogger(IEmployeeService.class) ;

    @Autowired
    private StaffRepository staffRepository ;

    
    @Override
    public String saveEmployee(StaffDetailRequest request) {

        logger.info("Inside save employee!");
        long creationTime = System.currentTimeMillis() ;
		Timestamp creationTimeStamp = new Timestamp(creationTime) ;
        String response = null ;

        try {
            String userName = request.getReqHdr().getUserName() ;
            if (!staffRepository.existsByEmployeeId(request.getEmployeeId())) {
                StaffDetails details = new StaffDetails() ;
                details.setFirstName(request.getFirstName());
                details.setLastName(request.getLastName());
                details.setAdharNumber(request.getAdharNumber());
                details.setContactNumber(request.getContactNumber());
                details.setDateOfBirth(request.getDateOfBirth());
                details.setEmail(request.getEmail());
                details.setDateOfJoin(request.getDateOfJoin());
                details.setQualification(request.getQualification());
                details.setExperience(request.getExperience());
                details.setSubject(request.getSubject());
                details.setAllotedClasses(request.getAllotedClasses());
                details.setEmployeeId(request.getEmployeeId());
                details.setIsCertificatesSubmitted(request.getIsCertificatesSubmitted());
                details.setPfNumber(request.getPfNumber());
                details.setPreviousSchool(request.getPreviousSchool());
                details.setCreatedBy(userName);
                details.setCreationTime(creationTimeStamp);
                details.setLastUpdatedBy(userName);
                details.setLastUpdateDate(creationTimeStamp);
                staffRepository.save(details) ;
                if (staffRepository.existsByEmployeeId(request.getEmployeeId())) {
                    return "Employee added successfully" ;
                } 
            } else {
               return "Record already existed with admissionNumber: "+request.getEmployeeId()+ " Please check once" ;
            }

        } catch (Exception e) {
            e.printStackTrace();
			response = e.getLocalizedMessage() ;
			return response;
            
        }
        return response;
        
    }
    
}
