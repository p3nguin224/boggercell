package com.unl.da;

import java.sql.Connection;
import java.sql.DriverManager;

public final class ConnectionManager {
	private ConnectionManager(){

	}

	public static Connection getDBConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String strURL="jdbc:mysql://localhost/unl?serverTimezone=UTC";
		Connection con = DriverManager.getConnection(strURL,"root","");
		System.out.println("connection success");
		return con;
	}
}
