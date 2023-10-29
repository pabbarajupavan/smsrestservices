package com.sms.serviceimpl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.beans.PaymentRequest;
import com.sms.model.Fee;
import com.sms.model.StudentMaster;
import com.sms.repository.FeeRepository;
import com.sms.repository.StudentMasterRepository;
import com.sms.service.FeeService;

@Service
public class IFeeService implements FeeService{
	
	private static final Logger logger = LoggerFactory.getLogger(IFeeService.class) ;
	
	@Autowired
	private FeeRepository feeRepo ;
	
	@Autowired
	private StudentMasterRepository studentRepo ;

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public String addPaymentInfo(PaymentRequest request) {
		// TODO Auto-generated method stub
		String response = null ;
		long creationTime = System.currentTimeMillis() ;
		Timestamp creationTimeStamp = new Timestamp(creationTime) ;
		StudentMaster student = new StudentMaster() ;
		HashMap<StudentMaster,List<StudentMaster>> studentsMap = new HashMap<>() ;
		List<StudentMaster> studentsList = studentRepo.findAll() ;
		for (StudentMaster studentMaster : studentsList) {
			studentsMap.put(studentMaster, studentsList);
		}
		logger.info("students map is: "+studentsMap.toString());
		try {
			Fee fee = new Fee() ;
			if (studentsMap.containsKey(student.getAdmissionNumber())) {
				fee.setAdmissionNumber(request.getStudentRequest().getAdmissionNumber());
				
				fee.setBalance(request.getBalance());
				fee.setCreatedBy(request.getReqHdr().getUserName());
				fee.setUpdatedBy(request.getReqHdr().getUserName());
				fee.setCreationTime(creationTimeStamp);
				fee.setLastUpdatedTime(creationTimeStamp);
				long billNumber = creationTime ;
				logger.info("bill Number is: " +billNumber);
				fee.setBillNumber(billNumber);
				logger.info(fee.toString());
				Fee resp = feeRepo.save(fee) ;
				if (resp != null) {
					response = "Payment Details added" ;
					
				}
			}else {
				response = "Student record is not present in student master table";
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			response = e.getMessage() ;
			return response ;
		}
		return response;
	}

}
