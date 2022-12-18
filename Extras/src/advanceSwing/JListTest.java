package advanceSwing;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListTest {

	public static void main(String[] args) {
		
		JFrame meFrame = new FrameList();
		meFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		meFrame.setVisible(true);
		
	}

}

class FrameList extends JFrame {
	
	private JList<String> monthList;
	private JPanel sheetList, sheetText;
	private JLabel label;
	
	public FrameList() {
		setTitle("Test JList");
		setBounds(400, 300, 400, 300);
		String[] month={"January", "February", 
				"March", "April", "May", "June", "July",
				"August","September", "October",
				"November", "December" };
		monthList= new JList<String>(month);
		monthList.setVisibleRowCount(4);
		JScrollPane sheetScroll = new JScrollPane(monthList);
		monthList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				List<String> value= monthList.getSelectedValuesList();
				StringBuilder text = new StringBuilder("Selected month: ");
				value.forEach(ele->text.append(ele+" "));
				label.setText(text.toString());
			}
		});
		sheetList= new JPanel();
		sheetList.add(sheetScroll);
		sheetText= new JPanel();
		label= new JLabel("Selected month: ");
		sheetText.add(label);
		add(sheetList,BorderLayout.NORTH);
		add(sheetText, BorderLayout.SOUTH);
		
	}
	
}