package advanceSwing;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class ProductJTable {

	public static void main(String[] args) {
		JFrame meFrame = new ProductFrame();
		meFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		meFrame.setVisible(true);

	}

}
class ProductFrame extends JFrame{
	
	private JComboBox tableName;
	private DatabaseMetaData dataBD;
	private Connection conn;
	private Statement st;
	private ResultSet rs; 
	private RSModelTable rsModelTable;
	
	
	public ProductFrame() {
		setTitle("Product JTable");
		setBounds(500,300,600,400);
		JPanel upper= new JPanel();
		tableName= new JComboBox();
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_project","root","");
			dataBD=conn.getMetaData();
			rs= dataBD.getTables(null, null, null, null);
			while(rs.next()) {
				tableName.addItem(rs.getString("TABLE_NAME"));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		
		tableName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String sql ="Select * from "+(String)tableName.getSelectedItem();
				try {
					st=conn.createStatement();
					rs=st.executeQuery(sql);
				
					rsModelTable= new RSModelTable(rs);
					JTable table= new JTable(rsModelTable);
					add(new JScrollPane(table),BorderLayout.CENTER);
					validate();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		upper.add(tableName);
		add(upper,BorderLayout.NORTH);
		
	}
}

class RSModelTable extends AbstractTableModel{
	
	private ResultSet rs;
	private ResultSetMetaData rsmd;
	
	

	public RSModelTable(ResultSet rs) {
		
		this.rs = rs;
		try {
			this.rsmd=rs.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int getRowCount() {
	
		try {
			rs.last();
			return rs.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		try {
			return rsmd.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			rs.absolute(rowIndex+1);
			return rs.getObject(columnIndex+1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
		
	}
	public String getColumnName(int c) {
		try {
		return rsmd.getColumnName(c+1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
