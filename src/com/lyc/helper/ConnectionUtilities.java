package com.lyc.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtilities {
	public static final String DRIVER = "org.postgresql.Driver";
	public static final String URL = "jdbc:postgresql://localhost:5432/lyc";
	public static final String USERNAME = "postgres";
	public static final String PASSWORD = "123456";
		
	public Connection getConnection() {
		try {
			Class.forName(DRIVER);
			Connection connection = DriverManager.getConnection(URL, USERNAME,
					PASSWORD);
			return connection;
		} catch (ClassNotFoundException e) {
			System.out.println("Error loading driver: " + e);
			return null;
		} catch (SQLException e) {
			System.out.println("Error connecting: " + e);
			return null;
		}
	}
	public static void main(String[] args) {
		ConnectionUtilities conn = new ConnectionUtilities();
		Connection connection = conn.getConnection();
		if(connection != null){
			System.out.println("Connect successfull");
		} else {
			System.out.println("Connect not successfull");
		}
	}
}
