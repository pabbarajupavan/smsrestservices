package com.sms.serviceimpl;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.sms.beans.StudentMasterRequest;
import com.sms.beans.StudentResponse;
import com.sms.model.Fee;
import com.sms.model.StudentMaster;
import com.sms.repository.FeeRepository;
import com.sms.repository.StudentMasterRepository;
import com.sms.service.StudentMasterService;

@Service("studentMasterService")
public class IStudentMasterService implements StudentMasterService {
	
	public static final Logger logger = LoggerFactory.getLogger(IStudentMasterService.class);

	@Autowired
	private StudentMasterRepository studentMasterRepo ;
	
	@Autowired
	private FeeRepository feeRepo ;
	
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
			if (!studentMasterRepo.existsByAdmissionNumber(request.getAdmissionNumber())) {
				StudentMaster master = new StudentMaster() ;
				master.setFirstName(request.getFirstName());
				master.setLastName(request.getLastName());
				master.setFatherName(request.getFatherName());
				master.setMotherName(request.getMotherName());
				master.setDateOfBirth(request.getDateOfBirth());
				master.setParentMobileNumber(request.getParentMobileNumber());
				master.setAdharNumber(request.getAdharNumber());
				master.setAddress(request.getAddress());
				master.setDateOfJoin(request.getDateOfJoin());
				master.setJoiningOfClass(request.getJoiningOfClass());
				master.setAdmissionNumber(request.getAdmissionNumber());
				master.setPreviousSchool(request.getPreviousSchool());
				master.setSyllabus(request.getSyllabus());
				master.setTcNumber(request.getTcNumber());
				master.setDayScholorCheck(request.getDayScholorCheck());
				master.setTransportCheck(request.getTransportCheck());
				master.setTcCheck("Y");
				master.setFeeCheck("Y");
				master.setCreationTime(creationTimeStamp);
				master.setCreatedBy(userName);
				master.setUpdatedBy(userName);
				master.setLastUpdatedTime(creationTimeStamp);
				StudentMaster result = studentMasterRepo.save(master) ;
				logger.info(result.toString());
				if (result != null) {
					response = "Student successfully Enrolled";
					
				}
				long endTime = System.currentTimeMillis() ;
				logger.info("Student record inserted at" + endTime);
			} else {
				response = "Record already existed with admissionNumber: "+request.getAdmissionNumber()+ " Please check once" ;
			}
			long endTime = System.currentTimeMillis() ;
			logger.info("saving students to db ends at" +endTime);
			return response ;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response = e.getLocalizedMessage() ;
			return response;
		}
		
	}

	@Override
	public StudentResponse fetchStudentInfoForFeePayaments(String admissionNumber) {
		
		List<StudentMaster> studentsList = studentMasterRepo.findByAdmissionNumber(admissionNumber);
		Fee studentFee = feeRepo.findByAdmissionNumber(admissionNumber) ;
		StudentResponse response = new StudentResponse() ;
		try {
			
			for (StudentMaster studentMaster : studentsList) {
				if (admissionNumber.equals(studentMaster.getAdmissionNumber()) ) {
					response.setAdmissionNumber(admissionNumber);
					response.setFirstName(studentMaster.getFirstName());
					response.setStudentClass(studentMaster.getPresentClass());
					
					if (admissionNumber.equals(studentFee.getAdmissionNumber())) {
						
					}else {
						response.setMessage("Student entry not there in fee table");
					}
					
				}
				response.setAdmissionNumber(studentMaster.getAdmissionNumber());
			}
			return response ;
		} catch (NullPointerException e) {
			// TODO: handle exception
			String msg = e.getMessage();
			response.setMessage(msg);
			return response ;
		}
		
	}

}
