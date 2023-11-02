package com.sms.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.sms.beans.StaffDetailRequest;
import com.sms.beans.StudentMasterRequest;
import com.sms.beans.StudentResponse;
import com.sms.model.StudentMaster;
import com.sms.repository.StaffRepository;
import com.sms.service.EmployeeService;
import com.sms.service.FileUploadService;
import com.sms.service.StudentMasterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	private StudentMasterService studentMasterService ;
	
	@Autowired
	private FileUploadService fileUploadService ;

    @Autowired
    private EmployeeService employeeService ;
	
	String response = null;
	
	public static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	/**
	 * 
	 * Rest call to add students to the student master table
	 * From request as json object
	 * **/
	@PostMapping("/addstudentmaster")
	public String addStudentsToMasterTable(@RequestBody StudentMasterRequest request) {
		logger.info("Inside addstudentmaster controller");
		if (request != null && request.getReqHdr().getUserName() != null) {
			response = studentMasterService.enrollStudent(request) ;
		} else {
			response = "Username is null" ;
			
		}
		return response ;
		
	}
	
	//file upload endpoint
    @PostMapping("/uploadFile")
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
            	   response = fileUploadService.readStaffDataFromFileAndSaveToDB(filePath, userName) ;
               }
            } catch (Exception e) {
                
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
    
    @PostMapping(value="/addstaffdetails")
    public @ResponseBody String addEmployee(@RequestBody StaffDetailRequest request) {
        
        logger.info("entered into addEmployee");
        if(request != null && request.getReqHdr().getUserName() != null){
            response = employeeService.saveEmployee(request) ;
            return response ;
        }
        return response;
    }
    
    
    
	
	
}
