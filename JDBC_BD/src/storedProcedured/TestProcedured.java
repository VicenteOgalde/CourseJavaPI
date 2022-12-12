package storedProcedured;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;




public class TestProcedured {

	public static void main(String[] args) {
		
		try {
			
			//1.create connection
			Connection meConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/persona",
					"root","");
			//2. create statement
			CallableStatement meStatement = meConnection.prepareCall("{call showPersonRegionBio}");
			//3.execute sql
			
			ResultSet meResultSet=meStatement.executeQuery();
			//read the resultset
			while(meResultSet.next()) {
				System.out.println(
						"Id: "+meResultSet.getInt(1)+" Comuna: "+
						meResultSet.getString("comuna")+" Name: "+
						meResultSet.getString("nombre")
						);
			}
			meConnection.close();
			meResultSet.close();
			
			
			
		}catch(Exception e){
			
		}

	}

}
