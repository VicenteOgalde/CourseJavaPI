package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExecuteQueryQApp {
	
	private final String selectQueryRegion="Select id,nombre,comuna,region"
			+" from persona where region=?";
	private final String selectQueryComuna="Select id,nombre,comuna,region"
			+" from persona where comuna=?";
	private final String selectQueryComunaAndRegion="Select id,nombre,comuna,region"
			+" from persona where comuna=? and region=?";
	private ConnectionQApp meConnection;
	
	private ResultSet resultSet;
	
	private PreparedStatement preparedStatement;
	
	
	
	public ExecuteQueryQApp() {
		this.meConnection=new ConnectionQApp();
	}



	public ResultSet filterComunaAndRegion(String comunaQ, String regionQ) {
		Connection meConn=meConnection.getConn();
		
		resultSet=null;
		try {
		
		if(!comunaQ.equals("All")&& regionQ.equals("All")) {
			
			preparedStatement=meConn.prepareStatement(selectQueryComuna);
			preparedStatement.setString(1, comunaQ);
			resultSet=preparedStatement.executeQuery();
			
		}else if(!regionQ.equals("All")&&comunaQ.equals("All")) {
			preparedStatement=meConn.prepareStatement(selectQueryRegion);
			preparedStatement.setString(1, regionQ);
			resultSet=preparedStatement.executeQuery();
			
			
		}else if(!regionQ.equals("All")&&!comunaQ.equals("All")) {
			
			preparedStatement=meConn.prepareStatement(selectQueryComunaAndRegion);
			preparedStatement.setString(1, comunaQ);
			preparedStatement.setString(2, regionQ);
			resultSet=preparedStatement.executeQuery();
			
		}
		
		return resultSet;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		
		
		
	}
}
