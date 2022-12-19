package advanceSwing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableTest {

	public static void main(String[] args) {
		JFrame meFrame = new FrameJTable();
		meFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		meFrame.setVisible(true);

	}

}
class FrameJTable extends JFrame {
	
	private String[] columnName= {"Name","Radio","Moons","Gaseous"};
	
	private Object [] [] rowData= {
			{"Mercury",2440.0,0,false},
			{"Venus",6052.0,0,false},
			{"Earth",6378.0,1,false},
			{"Mars",3397.0,2,false},
			{"Jupiter",71492.0,16,true},
			{"Saturn",60268.0,18,true},
	};
	
	public FrameJTable() {
		setTitle("Planets");
		setBounds(300,300,400,200);
		JTable planetJTable= new JTable(rowData,columnName);
		add(new JScrollPane(planetJTable),BorderLayout.CENTER);
		JButton buttonPrint=new JButton("Print Table");
		buttonPrint.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					planetJTable.print();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		JPanel sheetButton= new JPanel();
		sheetButton.add(buttonPrint);
		add(sheetButton,BorderLayout.SOUTH);
	}
	
	
}