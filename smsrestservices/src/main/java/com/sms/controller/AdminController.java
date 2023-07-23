package com.sms.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sms.beans.StudentMasterRequest;

@RequestMapping("/api")
public class AdminController {
	
	@RequestMapping(value = "/addstudentmaster", method = RequestMethod.POST)
	private String addStudentsToMasterTable(@RequestBody StudentMasterRequest request) {
		
		
		
		
		return null;
	}
}
