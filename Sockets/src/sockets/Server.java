package sockets;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Server {

	public static void main(String[] args) {
		
		ServerFrame meFrame = new ServerFrame();
		meFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class ServerFrame extends JFrame{
	
	public ServerFrame() {
		
		setBounds(1200, 300, 280, 350);
		JPanel meSheet = new JPanel();
		meSheet.setLayout(new BorderLayout());
		areaText= new JTextArea();
		meSheet.add(areaText,BorderLayout.CENTER);
		add(meSheet);
		setVisible(true);
	}
	private JTextArea areaText;
}