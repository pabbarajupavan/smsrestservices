package com.sms.serviceimpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.sms.model.StaffDetails;
import com.sms.model.StudentMaster;
import com.sms.repository.StaffRepository;
import com.sms.repository.StudentMasterRepository;
import com.sms.service.FileUploadService;

import jakarta.transaction.Transactional;

@Service("fileUploadService")
public class IFileUploadService implements FileUploadService {
	
	private static final Logger logger = LoggerFactory.getLogger(IFileUploadService.class) ;
	
	@Autowired
	private StudentMasterRepository studentMasterRepository ;

	private StaffRepository staffRepository ;

	@Transactional
	@Override
	public String readDataFromFileAndSaveToDB(String filePath, String userName) throws FileNotFoundException {
		
		String response = null ;
		long creationTime = System.currentTimeMillis() ;
        Timestamp creTimestamp = new Timestamp(creationTime) ;
        logger.info("reading file started at {}",creTimestamp);
        try (Stream<String> lines = new BufferedReader(new FileReader(filePath)).lines()){
        	List<StudentMaster> studentsList = lines
        			.skip(1) //skips the header line
        			.map(line -> line.split(","))
        			.map(columns -> {
        				StudentMaster student = new StudentMaster() ;
        				if (!studentMasterRepository.existsByAdmissionNumber(columns[8])) {
        					student.setFirstName(columns[0]);
            				student.setLastName(columns[1]);
            				student.setFatherName(columns[2]);
            				student.setMotherName(columns[3]);
            				student.setParentMobileNumber(Long.parseLong(columns[4]));
            				student.setAdharNumber(Long.parseLong(columns[5]));
            				student.setAddress(columns[6]);
            				String dateOfBirth = columns[7];
            				student.setDateOfBirth(Timestamp.valueOf(dateOfBirth));
            				student.setAdmissionNumber(columns[8]);
            				student.setDateOfJoin(Timestamp.valueOf(columns[9]));
            				student.setJoiningOfClass(columns[10]);
            				student.setSyllabus(columns[11]);
            				student.setPreviousSchool(columns[12]) ;
            				if (columns[13].isEmpty() || columns[13].isBlank()) {
    							student.setTcNumber(0);
    						}else {
    							student.setTcNumber(Integer.parseInt(columns[13]));
    						}
            				student.setDayScholorCheck(columns[14]);
            				student.setTransportCheck(columns[15]);
            				student.setTcCheck("Y");
            				student.setFeeCheck("Y") ;
            				student.setCreatedBy(userName);
                            student.setCreationTime(creTimestamp);
                            student.setUpdatedBy(userName);
                            student.setLastUpdatedTime(creTimestamp);
                            
						}
						return student;
        				
        			}).collect(Collectors.toList());
				
        	
        	try {
        		
              List<StudentMaster> students = studentMasterRepository.saveAll(studentsList) ;
              response = "student list added to the database" ;
              long stopTime = System.currentTimeMillis() ;
              logger.info("Data inserted to db at {}",stopTime);
              return response ;  
              } catch (DataIntegrityViolationException e) {
                  response = e.getMostSpecificCause().getMessage();
                  return response;
              }
			
		} catch (Exception e) {
			
			e.printStackTrace();
	        response = e.getMessage() ;
	        return response ;
		}
		
        
	}

	@Override
	public String readStaffDataFromFileAndSaveToDB(String filePath, String userName) throws FileNotFoundException {
		String response = null;
		long startTime = System.currentTimeMillis() ;
		Timestamp timestamp = new Timestamp(startTime) ;
		logger.info("the file reading started at {}", timestamp);
		try (Stream<String> lines = new BufferedReader(new FileReader(filePath)).lines()) {
			List<StaffDetails> staffList = lines
				.skip(1)
				.map(line -> line.split(","))
				.map(columns -> {
					StaffDetails staff = new StaffDetails() ;
					staff.setFirstName(columns[0]);
					staff.setLastName(columns[1]);
					staff.setEmail(columns[2]);
					staff.setContactNumber(columns[3]);
					staff.setAdharNumber(columns[4]);
					String dateOfBirth = columns[7];
            		staff.setDateOfBirth(Timestamp.valueOf(dateOfBirth));
					String dateOfJoin = columns[8];
					staff.setDateOfJoin(Timestamp.valueOf(dateOfJoin));
					staff.setIsCertificatesSubmitted(columns[9]);
					staff.setExperience(columns[10]);
					staff.setQualification(columns[11]);
					staff.setSubject(columns[12]);
					staff.setAllotedClasses(columns[13]);
					return staff; 
				}).collect(Collectors.toList());
				
				response = saveStaff(staffList) ;
				

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new UnsupportedOperationException("Unimplemented method 'readStaffDataFromFileAndSaveToDB'");
	}

	private String saveStaff(List<StaffDetails> staffList) {
		String response = null;
		try {
				staffRepository.saveAll(staffList) ;
				response = "staff details added to the db" ;
				return response ;
			} catch (Exception e) {
				e.printStackTrace();
			}
		return response;
	}

}
