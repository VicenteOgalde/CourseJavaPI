package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class TestTranssaction {

	public static void main(String[] args) {
		
		Connection conn=null;
		
		try{
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/persona",
					"root","");
			conn.setAutoCommit(false);
			Statement statement= conn.createStatement();
			String firstSQL="INSERT INTO PERSONA(id,comuna,nombre,region)"
					+ " values('13','nuble','user13','biobio')";
			
			String secondSQL="DELETE FROM PERSONA WHERE comuna='pinto'";
			
			String thirdSQL="UPDATE PERSONA SET id=id+1";
			
			boolean execute=executeTransaction();
			
			if(execute) {
				statement.executeUpdate(firstSQL);
				statement.executeUpdate(secondSQL);
				statement.executeUpdate(thirdSQL);
				conn.commit();
				System.out.println("All good");
			}else {
				System.out.println("BD without changes");
			}
			
		}catch(Exception e) {
			
			try {
				conn.rollback();
				System.out.println("something went wrong");
				e.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}

	}
	static boolean executeTransaction() {
		
		String exTra=null;
		
		
		exTra=JOptionPane.showInputDialog("Execute SQL yes or no");
			
		
		
		if(exTra.equalsIgnoreCase("yes")) {
			return true;
		}else {
		return false;
		}
		
	}

}


