package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import controller.ConnectionQApp;

public class LoadData {
	
	
	private ArrayList<String> comunaArr= new ArrayList<String>();
	private ArrayList<String> regionArr= new ArrayList<String>();
	private ConnectionQApp meConnection;
	private ResultSet meResultSet;
	private Person person=new Person();

	public LoadData() {
		super();
		this.meConnection = new ConnectionQApp();
	}
	
	public ArrayList<String> executeQueryC() {
		
		
		Connection accBD=meConnection.getConn();
		
		try {
			
			//2. create statement
			Statement meStatement = accBD.createStatement();
			//3.execute sql
			
			meResultSet=meStatement.executeQuery("SELECT DISTINCTROW comuna FROM persona");
			//read the resultset
			while(meResultSet.next()) {
				String tempCom= meResultSet.getString(1);
				comunaArr.add(tempCom);
				
			}
			
			meResultSet.close();
			return comunaArr;
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	public ArrayList<String> executeQueryR() {

		Connection accBD=meConnection.getConn();
		
		try {
			
			//2. create statement
			Statement meStatement = accBD.createStatement();
			//3.execute sql
						
			meResultSet=meStatement.executeQuery("SELECT DISTINCTROW region FROM persona");
			while(meResultSet.next()) {
				String tempReg= meResultSet.getString(1);
				regionArr.add(tempReg);
			}
			meResultSet.close();
			return regionArr;
			
			
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	
	

}
