package metaData;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InfoMetaData {

	public static void main(String[] args) {
		
		showInfoMetaData();

	}
	
	static void showInfoMetaData() {
		Connection conn=null;
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/persona",
					"root","");
			DatabaseMetaData bdMetaData= conn.getMetaData();
			
			System.out.println("DataBase Manager: "+bdMetaData.getDatabaseProductName());
			System.out.println("Manager version: "+bdMetaData.getDatabaseProductVersion());
			
			System.out.println("Driver Name:"+bdMetaData.getDriverName());
			System.out.println("Driver Version"+bdMetaData.getDriverVersion());
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
