package finalAppJDBC;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

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
		
		tableCombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String s=(String) tableCombo.getSelectedItem();
				loadDataCombo(s);
				
			}
		});
		
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
	public void loadDataCombo(String x) {
		connBD();
		ResultSet rs=null;
		ResultSetMetaData rsM=null;
		infoArea.setText("");
		try {
			Statement st=conn.createStatement();
			DatabaseMetaData dbm=conn.getMetaData();
			
			rs=st.executeQuery("SELECT * FROM "+x);
			rsM=rs.getMetaData();
			int j=rsM.getColumnCount();
			while(rs.next()) {
				
				for(int i=1;i<=j;i++) {
					infoArea.append(" "+rsM.getColumnName(i));
					infoArea.append(": "+rs.getString(i));
				}
				infoArea.append("\n");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
