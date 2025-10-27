package com.petStore.api.baseClass;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.petStore.api.genericUtility.DataBaseConnectivity;
import com.petStore.api.genericUtility.FileUtility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseApiClass {
	DataBaseConnectivity db = new DataBaseConnectivity();
	FileUtility fileUtil = new FileUtility();
	static RequestSpecification reqBuild ;
	static ResponseSpecification respBuild ;
	
	@BeforeSuite
	public void configBS() throws IOException {
		db.getConnectionToDataBase();
		
		RequestSpecBuilder Build1 = new RequestSpecBuilder();
		Build1.setContentType(ContentType.JSON);
//		Build1.addHeader("", "");
		Build1.setBaseUri(fileUtil.readDataFromPropertyFile("BaseURL"));
		reqBuild = Build1.build();
		
		
		ResponseSpecBuilder Build2 = new ResponseSpecBuilder();
		Build2.expectContentType(ContentType.JSON);
		respBuild = Build2.build();
	}
	
	
	@AfterSuite
	public void configAS() throws SQLException {
		db.closeConnectionToDataBase();
	}
}
