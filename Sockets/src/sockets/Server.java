package sockets;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

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
			ArrayList<String> ipList= new ArrayList<String>();
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
			
			if(!data.getMessage().equals(" online")) {
			
			areaText.append("\n"+data.getNick()+": "+data.getMessage()
			+" for "+data.getIp());
			
			Socket sendToDestiny = new Socket(data.getIp(),9090);
			ObjectOutputStream reSendData = new ObjectOutputStream(sendToDestiny.getOutputStream());
			reSendData.writeObject(data);
					
			reSendData.close();
			sendToDestiny.close();
			meSocket.close();
			}else {

				//--------------------------//
				
				InetAddress location = meSocket.getInetAddress();
				String remoteIp = location.getHostAddress();
				ipList.add(remoteIp);
				data.setIpList(ipList);
				
				for (String s : ipList) {

					Socket sendToDestiny = new Socket(s,9090);
					ObjectOutputStream reSendData = new ObjectOutputStream(sendToDestiny.getOutputStream());
					reSendData.writeObject(data);
							
					reSendData.close();
					sendToDestiny.close();
					meSocket.close();
					
				}
			}
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private JTextArea areaText;
}