package com.Connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static final String JDBC_DRIVER = "com.mysql.c1.jdbc.Driver";
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/orderdb";
	public static final String USERNAME ="root";
	public static final String PASSWORD = "root";
	
	
	//Connection Interface
	static Connection conn = null;
	
	public static Connection getConnect()
	{
		try
		{
			//load the driver
			// we need to create object of driver class
			// we don't know class name
			//return class class return java.lang
			//static method : forName
			Class.forName("com.mysql.cj.jdbc.Driver");
			// System.out.println("Driver loaded...........");
			
			// DriverManger : getConnection  : static method 
			// url: mysql : protocol, set of rules
			// localhost : connect to same computer 
			// 3306 : port number of mysql
			// showroom : database name
			conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		//	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/showroom", "root", "root");
			
		//	 System.out.println("");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return conn;
	}

}
