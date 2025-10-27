package com.petStore.api.genericUtility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseConnectivity {

	Connection  conn = null;
	
	/**
	 * This method helps to connect with database
	 * @throws IOException 
	 */
	public void getConnectionToDataBase() throws IOException {
		FileUtility fileUtil = new FileUtility();
		String URL =fileUtil.readDataFromPropertyFile("DBUrl");
		String USERNAME =fileUtil.readDataFromPropertyFile("DB_UserName");
		String PASSWORD = fileUtil.readDataFromPropertyFile("DB_Password");
		try {
		//step-1: load / register the data base driver
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);
				
				//step-2: connect to the database
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//				System.out.println("===DataBase connection done===");
		}catch(Exception e) {}
	}
	
	/**
	 * This method helps to close the connection to database
	 * @throws SQLException
	 */
	public void closeConnectionToDataBase() throws SQLException {
		conn.close();
	}
	
	/**
	 * This method helps to fetch the data from the database
	 * @throws SQLException
	 */
	public void fetchDataFromDataBase() throws SQLException {
		Statement statement = conn.createStatement();
//		 execute select query and get result
		ResultSet resultSet = statement.executeQuery("select * from employee");
	}
	
	/**
	 * This method helps to insert data into database by accepting query as an argument
	 * @param query
	 * @throws SQLException
	 */
	public void insertDataFromDataBase(String query) throws SQLException {
		Statement statement = conn.createStatement();
		//step -4: update the table
		int result = statement.executeUpdate(query);
		System.out.println(result);
	}
}
