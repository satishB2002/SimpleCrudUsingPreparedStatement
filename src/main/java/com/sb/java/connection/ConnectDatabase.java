package com.sb.java.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
	
	public static Connection connect() throws SQLException
	{
		   try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			  Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Devil", "Anemoi", "Anemoi@123");
		       System.out.println("Database Is Connected");
			return con;
		} catch (Exception e) {
			
			System.out.println("Database Is Not Connected");
	        System.out.println(e);
		}
		return null;
	}
}
