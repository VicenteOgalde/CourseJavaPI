package finalAppJDBC;



import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GenericApp {

	public static void main(String[] args) {
		
		FrameBD meFrame= new FrameBD();
		meFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		meFrame.setVisible(true);

	}

}
class FrameBD extends JFrame{

	public FrameBD(){
		setBounds(300,300,700,700);
		
		SheetBD meSheet= new SheetBD();
		add(meSheet);
	}
	
}
class SheetBD extends JPanel{

	private JComboBox tableCombo;
	private JTextArea infoArea;
	private Connection conn;
	
	public SheetBD() {
		setLayout(new BorderLayout());
		tableCombo= new JComboBox();
		infoArea= new JTextArea();
		add(infoArea,BorderLayout.CENTER);
		add(tableCombo,BorderLayout.NORTH);
		obtainTable();
		
	}
	public void connBD() {
		conn=null;
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootcamp",
						"root","");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void obtainTable() {
		ResultSet rs=null;
		connBD();
		try {
			DatabaseMetaData dbm=conn.getMetaData();
			rs=dbm.getTables(null, null, null, null);
			
			while(rs.next()) {
				tableCombo.addItem(rs.getString("TABLE_NAME"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
