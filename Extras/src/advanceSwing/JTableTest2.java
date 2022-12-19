package advanceSwing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class JTableTest2 {

	public static void main(String[] args) {
		JFrame meFrame = new CustomJTableFrame();
		meFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		meFrame.setVisible(true);

	}

}
class CustomJTableFrame extends JFrame{
	
	public CustomJTableFrame() {
		setTitle("Custom JTable");
		setBounds(300,300,400,200);
		TableModel meModel= new CustomTableModel();
		JTable meTable= new JTable(meModel);
		add(new JScrollPane(meTable));
		
		
		}
}
class CustomTableModel extends AbstractTableModel{

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		int a=rowIndex+1;
		int b=columnIndex+2;
		return " "+a+" "+b;
	}
	public String getColumnName(int c) {
		return "Column "+c;
	}
	
}