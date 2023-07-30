package com.sms.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sms.beans.FeeMasterRequest;
import com.sms.beans.PaymentRequest;
import com.sms.beans.StudentMasterRequest;
import com.sms.beans.StudentResponse;
import com.sms.model.StudentMaster;
import com.sms.service.FeeMasterService;
import com.sms.service.FeeService;
import com.sms.service.FileUploadService;
import com.sms.service.StudentMasterService;

@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	private StudentMasterService studentMasterService ;
	
	@Autowired
	private FeeMasterService feeMasterService ;
	
	@Autowired
	private FeeService feeService ;
	
	@Autowired
	private FileUploadService fileUploadService ;
	
	String response = null;
	
	public static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	/**
	 * 
	 * Rest call to add students to the student master table
	 * From request as json object
	 * **/
	@RequestMapping(value = "/addstudentmaster", method = RequestMethod.POST)
	private String addStudentsToMasterTable(@RequestBody StudentMasterRequest request) {
		logger.info("Inside addstudentmaster controller");
		if (request != null && request.getReqHdr().getUserName() != null) {
			response = studentMasterService.enrollStudent(request) ;
		} else {
			response = "Username is null" ;
			
		}
		return response ;
		
	}
	
	//file upload endpoint
    @RequestMapping(value="/uploadFile", method=RequestMethod.POST)
    public String fileUpload(@RequestParam("file") MultipartFile file,@RequestParam("fileName") String fileName, @RequestParam("userName") String userName) {

        
        if (!file.isEmpty()) {
            try {
               //to save the upload file locally 
               String filePath = saveFileLocally(file) ;
               //if file name contains students
               
               if (!fileName.isBlank() && fileName.length() > 0 && fileName.contains("students")) {
                response = fileUploadService.readDataFromFileAndSaveToDB(filePath,userName) ;
                return response;
               } 
               if (!fileName.isBlank() && fileName.length() > 0 && fileName.contains("staff")) {
            	   //response = fileUploadService.
               }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                response = e.getMessage() ;
                return response ;
            }
        } else{
            response = "File is empty";
        }
        return response;
        
    }

    private String saveFileLocally(MultipartFile file) throws IOException{
        Path path = Paths.get(file.getOriginalFilename());
        Files.write(path, file.getBytes()) ;
        return path.toAbsolutePath().toString() ;
        
    }
    
    
    /**
	 * 
	 * Rest call to add fee details to the fee master table
	 * From request as json object
	 * **/
	@RequestMapping(value = "/addFeeDetails", method = RequestMethod.POST)
	private String saveFeeStructure(@RequestBody FeeMasterRequest request) {
		
		if (request != null && request.getReqHdr().getUserName() != null) {
			response = feeMasterService.addFeeDetails(request);
		} 
		return response ;
		
	}
	
	/**
	 * Rest call to get student info
	 * for the payment
	 */
	@RequestMapping(value = "/getstudentInfoForFee", method = RequestMethod.GET)
	public StudentResponse getStudentInfoForFee(@RequestBody PaymentRequest req) {
		StudentResponse resp = new StudentResponse() ;
		long currentTime = System.currentTimeMillis() ;
		logger.info("inside rest call to get the fee details of student started at" +currentTime) ;
		
		if (req != null && req.getReqHdr().getUserName() != null) {
			
			 resp = studentMasterService.fetchStudentInfoForFeePayaments(req.getStudentRequest().getAdmissionNumber()) ;
			
		}
		
		return resp;
	}

	
	
	
	/**
	 * Rest call to add fee payment of student
	 * to the fee table
	 * 
	 */
	@RequestMapping(value = "/payments", method = RequestMethod.POST)
	private String savePayments(@RequestBody PaymentRequest request) {
		
		if (request != null && request.getReqHdr().getUserName() != null) {
			response = feeService.addPaymentInfo(request);
		} 
		return response ;
		
	}
}
