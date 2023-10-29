package com.sms.serviceimpl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.beans.FeeMasterRequest;
import com.sms.model.FeeMaster;
import com.sms.model.StudentMaster;
import com.sms.repository.FeeMasterRepository;
import com.sms.service.FeeMasterService;

@Service("feeMasterService")
public class IFeeMasterService implements FeeMasterService {
	
	@Autowired
	private FeeMasterRepository feeMasterRepository ;

	@Override
	public String addFeeDetails(FeeMasterRequest request) {
		
		String response = null;
		try {
			long creationTime = System.currentTimeMillis() ;
			Timestamp creationTimeStamp = new Timestamp(creationTime) ;
			String userName = request.getReqHdr().getUserName() ;
			FeeMaster master = new FeeMaster() ;
			master.setSyllabusType(request.getSyllabusType());
			master.setTutionFee(request.getTutionFee());
			master.setTransportFee(request.getTransportFee());
			master.setAccessoryFee(request.getAccessoryFee());
			master.setLibraryFee(request.getLibraryFee());
			master.setExamFee(request.getExamFee());
			master.setHostelFee(request.getHostelFee());
			
			double discount = request.getDiscount();
			System.out.println(discount);
			master.setCreationTime(creationTimeStamp);
			master.setCreatedBy(userName);
			master.setUpdatedBy(userName);
			master.setLastUpdatedTime(creationTimeStamp);
			FeeMaster result = feeMasterRepository.save(master) ;
			if (result != null) {
				response = "Fee Details successfully Enrolled";
				
			}
			return response ;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response = e.getLocalizedMessage() ;
			return response;
		}
	}

}
