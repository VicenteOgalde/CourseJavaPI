package metaData;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InfoMetaData {

	public static void main(String[] args) {
		
		//showInfoMetaData();
		showInfoTable();

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
	
	
	static void showInfoTable() {
		
	Connection conn=null;
	ResultSet rs=null;
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootcamp",
					"root","");
			
			DatabaseMetaData bd= conn.getMetaData();
			
			System.out.println("Tables");
			System.out.println("-----------------------");
			
			rs=bd.getTables(null, null, "c%", null);
			
			while (rs.next()) {
				
				System.out.println(rs.getString("TABLE_NAME"));
				
			}
			System.out.println();
			System.out.println("columns");
			System.out.println("--------------");
			rs=bd.getColumns(null, null, "comuna", null);
			
			while (rs.next()) {
				
				System.out.println(rs.getString("COLUMN_NAME"));
				
			}
			
			
			
			
			
			
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
