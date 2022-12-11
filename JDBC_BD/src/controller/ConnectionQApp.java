package controller;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionQApp {

	private Connection meConnection;
	public ConnectionQApp() {
		
	}
	public Connection getConn() {
		

		try {
			//1.create connection
			meConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/persona",
					"root","");
			
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		
		return meConnection;
	}
	
	

}
