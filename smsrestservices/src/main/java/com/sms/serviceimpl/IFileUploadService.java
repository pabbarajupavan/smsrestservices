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

import com.sms.model.StudentMaster;
import com.sms.repository.StudentMasterRepository;
import com.sms.service.FileUploadService;

@Service("fileUploadService")
public class IFileUploadService implements FileUploadService {
	
	private static final Logger logger = LoggerFactory.getLogger(IFileUploadService.class) ;
	
	@Autowired
	private StudentMasterRepository studentMasterRepository ;

	@Override
	public String readDataFromFileAndSaveToDB(String filePath, String userName) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String response = null ;
		long creationTime = System.currentTimeMillis() ;
        Timestamp creTimestamp = new Timestamp(creationTime) ;
        logger.info("reading file started at" +creationTime);
        try (Stream<String> lines = new BufferedReader(new FileReader(filePath)).lines()){
        	List<StudentMaster> studentsList = lines
        			.skip(1) //skips the header line
        			.map(line -> line.split(","))
        			.map(columns -> {
        				StudentMaster student = new StudentMaster() ;
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
        				student.setDayScholor(columns[14]);
        				student.setTcCheck("Y");
        				student.setFeeCheck("Y") ;
        				student.setCreatedBy(userName);
                        student.setCreationTime(creTimestamp);
                        student.setUpdatedBy(userName);
                        student.setLastUpdatedTime(creTimestamp);
                        return student ;
        			}).collect(Collectors.toList());
        	
        	try {
                List<StudentMaster> students = studentMasterRepository.saveAll(studentsList) ;
              if (students!= null && students.size() !=0) {
                 response = "Student list added to the database" ; 
              }
              long stopTime = System.currentTimeMillis() ;
              logger.info("Data inserted to db at"+stopTime);
              return response ;  
              } catch (DataIntegrityViolationException e) {
                  // TODO: handle exception
                  //e.printStackTrace();
                  response = e.getMostSpecificCause().getMessage();
                  return response;
              }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
	        response = e.getMessage() ;
	        return response ;
		}
		
        
	}

}
