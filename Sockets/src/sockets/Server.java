package sockets;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Server {

	public static void main(String[] args) {
		
		ServerFrame meFrame = new ServerFrame();
		meFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class ServerFrame extends JFrame implements Runnable{
	
	public ServerFrame() {
		
		setBounds(1200, 300, 280, 350);
		JPanel meSheet = new JPanel();
		meSheet.setLayout(new BorderLayout());
		areaText= new JTextArea();
		meSheet.add(areaText,BorderLayout.CENTER);
		add(meSheet);
		setVisible(true);
		Thread meThread = new Thread(this);
		meThread.start();
	}
	
	@Override
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(9095);
			//String nick,ip,message;
			
			SendSet data;
			
			while(true) {
			Socket meSocket= serverSocket.accept();
			
			ObjectInputStream inputData = new ObjectInputStream(meSocket.getInputStream());
			data= (SendSet) inputData.readObject();
			
			/*
			DataInputStream inputFlow =new DataInputStream(meSocket.getInputStream());
			String messageText = inputFlow.readUTF();
			areaText.append("\n"+messageText);
			*/
			areaText.append("\n"+data.getNick()+": "+data.getMessage()
			+" for "+data.getIp());
			
			meSocket.close();
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private JTextArea areaText;
}