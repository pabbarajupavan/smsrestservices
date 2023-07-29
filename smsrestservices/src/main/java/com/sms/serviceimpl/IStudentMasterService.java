package com.sms.serviceimpl;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.beans.StudentMasterRequest;
import com.sms.model.StudentMaster;
import com.sms.repository.StudentMasterRepository;
import com.sms.service.StudentMasterService;

@Service("studentMasterService")
public class IStudentMasterService implements StudentMasterService {
	
	public static final Logger logger = LoggerFactory.getLogger(IStudentMasterService.class);

	@Autowired
	private StudentMasterRepository studentMasterRepo ;
	
	@Override
	public String enrollStudent(StudentMasterRequest request) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis() ;
		logger.info("saving students to db starts at" +startTime);
		String response = null;
		try {
			long creationTime = System.currentTimeMillis() ;
			Timestamp creationTimeStamp = new Timestamp(creationTime) ;
			String userName = request.getReqHdr().getUserName() ;
			StudentMaster master = new StudentMaster() ;
			master.setFirstName(request.getFirstName());
			master.setLastName(request.getLastName());
			master.setFatherName(request.getFatherName());
			master.setMotherName(request.getMotherName());
			master.setDateOfBirth(request.getDateOfBirth());
			master.setStudentMobileNumber(request.getStudentMobileNumber());
			master.setParentMobileNumber(request.getParentMobileNumber());
			master.setAdharNumber(request.getAdharNumber());
			master.setAddress(request.getAddress());
			master.setDateOfJoin(request.getDateOfJoin());
			master.setJoiningOfClass(request.getJoiningOfClass());
			master.setAdmissionNumber(request.getAdmissionNumber());
			master.setPreviousSchool(request.getPreviousSchool());
			master.setSyllabus(request.getSyllabus());
			master.setTcNumber(request.getTcNumber());
			master.setDayScholor(request.getDayScholor());
			master.setTcCheck("Y");
			master.setFeeCheck("Y");
			master.setCreationTime(creationTimeStamp);
			master.setCreatedBy(userName);
			master.setUpdatedBy(userName);
			master.setLastUpdatedTime(creationTimeStamp);
			StudentMaster result = studentMasterRepo.save(master) ;
			if (result != null) {
				response = "Student successfully Enrolled";
				
			}
			long endTime = System.currentTimeMillis() ;
			logger.info("Student record inserted at" + endTime);
			return response ;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response = e.getLocalizedMessage() ;
			return response;
		}
		
	}

}
