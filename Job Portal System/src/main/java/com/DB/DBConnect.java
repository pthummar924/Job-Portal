package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static Connection conn;
	private static String URL = "jdbc:mysql://localhost:3306/job_portal";
	private static String USERNAME = "root";
	private static String PASSWORD = "pct@#_924123";
	
	public static Connection getConnection() throws Exception {
		if(conn == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}
		return conn;
	}
}
