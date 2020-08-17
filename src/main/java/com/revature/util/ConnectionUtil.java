package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	
	public static Connection getConnectionFromFile(String filename) throws SQLException, IOException {
		Properties properties = new Properties();
		InputStream file = ConnectionUtil.class.getClassLoader().getResourceAsStream("connection.properties");
		properties.load(file);
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error: unable to load driver class!");
		}
		
		return DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
		
	}
	
}
