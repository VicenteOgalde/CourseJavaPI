package bdConexion;


import java.sql.*;


public class PreparedStatementTest {

	public static void main(String[] args) {
		
		try {
			//1.create connection
			Connection meConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso",
					"root","");
			//2. Prepared statement
			PreparedStatement preparedStatement=meConnection.prepareStatement(
					"Select id,nombre,apellido from usuarios where apellido=? and nombre=?");
			
			//3. set parameters
			preparedStatement.setString(1,"moon");
			preparedStatement.setString(2, "sun");
			
			//4.execute and loop query
			
			ResultSet rs= preparedStatement.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+
						rs.getString(2)+" "+rs.getString(3));
			}
			rs.close();
			
			
		
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
