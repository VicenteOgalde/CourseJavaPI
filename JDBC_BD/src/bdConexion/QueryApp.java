package bdConexion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class QueryApp {

	public static void main(String[] args) {
		
		FrameApp meFrame =new FrameApp();
		meFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		meFrame.setVisible(true);
		
	}
	

}
class FrameApp extends JFrame{
	
	private Connection meConnection;
	private JComboBox region,comuna;
	private JTextArea result;
	private PreparedStatement psCom;
	private PreparedStatement psReg;
	private PreparedStatement psComAndReg;
	private final String selectQueryRegion="Select id,nombre,comuna,region"
			+" from persona where region=?";
	private final String selectQueryComuna="Select id,nombre,comuna,region"
			+" from persona where comuna=?";
	private final String selectQueryComunaAndRegion="Select id,nombre,comuna,region"
			+" from persona where comuna=? and region=?";
	
	public FrameApp() {
		
		setTitle("Query DB");
		setBounds(500, 300, 400, 400);
		setLayout(new BorderLayout());
		JPanel menu=new JPanel();
		menu.setLayout(new FlowLayout());
		region=new JComboBox();
		region.setEditable(false);
		region.addItem("All");
		comuna= new JComboBox();
		comuna.setEditable(false);
		comuna.addItem("All");
		result=new JTextArea();
		result.setEditable(false);
		add(result);
		menu.add(region);
		menu.add(comuna);
		add(menu,BorderLayout.NORTH);
		add(result,BorderLayout.CENTER);
		JButton buttonQuery= new JButton("Query");
		buttonQuery.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				executeQueryR();
				
			}
		});
		add(buttonQuery,BorderLayout.SOUTH);
		
		
		try {
			//1.create connection
			meConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/persona",
					"root","");
			//2. create statement
			Statement meStatement = meConnection.createStatement();
			//3.execute sql
			
			ResultSet meResultSet=meStatement.executeQuery("SELECT DISTINCTROW comuna FROM persona");
			//read the resultset
			while(meResultSet.next()) {
				comuna.addItem(meResultSet.getString(1));
			}
			meResultSet.close();
			
			meResultSet=meStatement.executeQuery("SELECT DISTINCTROW region FROM persona");
			while(meResultSet.next()) {
				region.addItem(meResultSet.getString(1));
			}
			meResultSet.close();
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		
	}
	private void executeQueryR() {
		ResultSet rs=null;
		this.result.setText("");
		try {
			String regionQ=(String) this.region.getSelectedItem();
			String comunaQ=(String) this.comuna.getSelectedItem();
			
			if(!comunaQ.equals("All")&& regionQ.equals("All")) {
				
				psCom=meConnection.prepareStatement(selectQueryComuna);
				psCom.setString(1, comunaQ);
				rs=psCom.executeQuery();
				
			}else if(!regionQ.equals("All")&&comunaQ.equals("All")) {
				psReg=meConnection.prepareStatement(selectQueryRegion);
				psReg.setString(1, regionQ);
				rs=psReg.executeQuery();
				
				
			}else if(!regionQ.equals("All")&&!comunaQ.equals("All")) {
				
				psComAndReg=meConnection.prepareStatement(selectQueryComunaAndRegion);
				psComAndReg.setString(1, comunaQ);
				psComAndReg.setString(2, regionQ);
				rs=psComAndReg.executeQuery();
			}
			while(rs.next()) {
				result.append("\n Id: "+rs.getString(1)
						+" name: "+rs.getString(2)
						+" comuna: "+rs.getString(3)
						+" region: "+rs.getString(4));
			}
			
		}catch(Exception e) {
			
		}
	}
}
