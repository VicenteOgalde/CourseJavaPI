package bdConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConexion {

	public static void main(String[] args) {
		
		try {
			//1.create connection
			Connection meConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bootcamp",
					"root","");
			//2. create statement
			Statement meStatement = meConnection.createStatement();
			//3.execute sql
			
			ResultSet meResultSet=meStatement.executeQuery("SELECT * FROM ESTUDIANTE");
			//read the resultset
			while(meResultSet.next()) {
				System.out.println(
						"Id: "+meResultSet.getString("id_estudiante")+" RUT:"+
						meResultSet.getString("rut")+" Name: "+
						meResultSet.getString("nombre")
						);
			}
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
