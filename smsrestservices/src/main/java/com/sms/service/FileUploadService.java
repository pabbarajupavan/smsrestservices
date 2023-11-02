package com.sms.service;

import java.io.FileNotFoundException;

public interface FileUploadService {
	
	public String readDataFromFileAndSaveToDB(String filePath,String userName) throws FileNotFoundException;

	public String readStaffDataFromFileAndSaveToDB(String filePath, String userName) throws FileNotFoundException ;

}
