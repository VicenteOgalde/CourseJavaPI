package bdConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateBD {

	public static void main(String[] args) {
		
		try {
			//1.create connection
			Connection meConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso",
					"root","");
			//2. create statement
			Statement meStatement = meConnection.createStatement();
			
			//Insert into db
			String instructionSQL= "INSERT INTO USUARIOS "
					+ "(id,nombre,apellido,telefono)"
					+" VALUES ('2','sun','moon','56+asd123')";
			
			
			/* //update name
			String instructionSQL= "UPDATE USUARIOS SET nombre='greg' WHERE "
					+ "id = '256' ";
			*/
			
			/* //Delete 
			String instructionSQL= "DELETE FROM USUARIOS WHERE "
					+ "nombre='greg'";*/
			
			meStatement.executeUpdate(instructionSQL);
			
			
		
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
