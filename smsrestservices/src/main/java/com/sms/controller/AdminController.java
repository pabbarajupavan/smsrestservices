package com.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sms.beans.StudentMasterRequest;
import com.sms.service.StudentMasterService;

@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	private StudentMasterService studentMasterService ;
	
	/**
	 * 
	 * Rest call to add students to the student master table
	 * From request as json object**/
	@RequestMapping(value = "/addstudentmaster", method = RequestMethod.POST)
	private String addStudentsToMasterTable(@RequestBody StudentMasterRequest request) {
		String response = null;
		if (request != null && request.getReqHdr().getUserName() != null) {
			response = studentMasterService.enrollStudent(request) ;
		} else {
			response = "Username is null" ;
			
		}
		return response ;
		
	}
}
