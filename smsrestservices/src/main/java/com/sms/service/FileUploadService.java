package com.sms.service;

import java.io.FileNotFoundException;

public interface FileUploadService {
	
	public String readDataFromFileAndSaveToDB(String filePath,String userName) throws FileNotFoundException;

}
