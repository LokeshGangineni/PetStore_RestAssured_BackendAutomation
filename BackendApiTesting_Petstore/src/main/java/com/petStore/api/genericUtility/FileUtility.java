package com.petStore.api.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	/**
	 * This method will read data from property file
	 * @param key
	 * @return
	 * @throws IOException 
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis= new FileInputStream("C:\\Users\\User\\git\\PetStore_RestAssured_BackendAutomation\\BackendApiTesting_Petstore\\Env_Congif_Data.properties");
		Properties p= new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}

}
