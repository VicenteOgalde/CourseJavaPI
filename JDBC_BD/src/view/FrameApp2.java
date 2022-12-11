package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class FrameApp2 extends JFrame {

	
	private Connection meConnection;
	private JComboBox region,comuna;
	private JTextArea result;

	
	public FrameApp2() {
		
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
		add(buttonQuery,BorderLayout.SOUTH);
	}
}
