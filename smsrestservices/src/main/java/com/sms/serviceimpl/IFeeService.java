package com.sms.serviceimpl;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.beans.PaymentRequest;
import com.sms.model.Fee;
import com.sms.repository.FeeRepository;
import com.sms.service.FeeService;

@Service
public class IFeeService implements FeeService{
	
	private static final Logger logger = LoggerFactory.getLogger(IFeeService.class) ;
	
	@Autowired
	private FeeRepository feeRepo ;

	@Override
	public String addPaymentInfo(PaymentRequest request) {
		// TODO Auto-generated method stub
		String response = null ;
		long creationTime = System.currentTimeMillis() ;
		Timestamp creationTimeStamp = new Timestamp(creationTime) ;
		try {
			Fee fee = new Fee() ;
			fee.setAdmissionNumber(request.getStudentRequest().getAdmissionNumber());
			fee.setAFee(request.getAFee());
			fee.setExamFee(request.getExamFee());
			fee.setDFee(request.getDFee());
			fee.setFFee(request.getFFee());
			fee.setT1(request.getT1());
			fee.setT1(request.getT2());
			fee.setT3(request.getT3());
			fee.setBalance(request.getBalance());
			fee.setCreatedBy(request.getReqHdr().getUserName());
			fee.setUpdatedBy(request.getReqHdr().getUserName());
			fee.setReference(request.getReference());
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
			
		} catch (Exception e) {
			// TODO: handle exception
			response = e.getMessage() ;
			return response ;
		}
		return response;
	}

}
