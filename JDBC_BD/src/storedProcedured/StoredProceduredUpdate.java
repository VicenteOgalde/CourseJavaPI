package storedProcedured;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class StoredProceduredUpdate {

	public static void main(String[] args) {
		
		int id= Integer.parseInt(JOptionPane.showInputDialog("type id for update"));
		String name=JOptionPane.showInputDialog("name of the target");
		
	try {
			
			
			Connection meConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/persona",
					"root","");
			
			CallableStatement meStatement = meConnection.prepareCall("{call updatePersonId(?,?)}");
			meStatement.setInt(1, id);
			meStatement.setString(2, name);
			
			meStatement.execute();
			
	}catch(Exception e) {
		
	}

	}

}
