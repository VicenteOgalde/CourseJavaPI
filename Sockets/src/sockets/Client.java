package sockets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client {

	public static void main(String[] args) {
		
		ClientFrame meFrame= new ClientFrame();
		meFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class ClientFrame extends JFrame{
	
	public ClientFrame() {
		setBounds(600, 300, 280, 350);
		SheetFrameClient meSheet= new SheetFrameClient();
		add(meSheet);
		
		setVisible(true);
		
		addWindowListener(new SendIpOnline());
	}
	
}

//--------------Sending online signal---------------------

class SendIpOnline extends WindowAdapter{
	public void windowOpened(WindowEvent e) {
		try {
			Socket meSocket=new Socket("192.168.100.122",9095);
			SendSet data = new SendSet();
			data.setMessage(" online");
			
			ObjectOutputStream dataOut= new ObjectOutputStream(meSocket.getOutputStream());
			dataOut.writeObject(data);
			meSocket.close();
			dataOut.close();
			
		}catch(Exception e1) {
			System.out.println(e1.getMessage());
		}
		
	}
}

class SheetFrameClient extends JPanel implements Runnable{
	
	public SheetFrameClient() {
		
		
		Thread meThread = new Thread(this);
		meThread.start();
		
		String nickUser= JOptionPane.showInputDialog("Your nick is ? ");
		
		JLabel nick0= new JLabel("Nick: ");
		add(nick0);
		
		
		
		nick=new JLabel();
		
		nick.setText(nickUser);
		add(nick);
		
		
		JLabel text = new JLabel("Online: ");
		add(text);
		
		ip=new JComboBox();
		ip.addItem("u1");
		ip.addItem("u2");
		
		add(ip);
			
		chatField=new JTextArea(12,20);
		add(chatField);
		field1=new JTextField(20);
		add(field1);
		meButton= new JButton("SEND");
		SendText meEvent= new SendText();
		meButton.addActionListener(meEvent);
		add(meButton);
	}
	
	private class SendText implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			chatField.append("\n"+"Me: "+field1.getText());
			
			try {
				Socket meSocket= new Socket("192.168.100.122", 9095);
				
				SendSet data = new SendSet();
				
				data.setNick(nick.getText());
				data.setIp(ip.getSelectedItem().toString());
				data.setMessage(field1.getText());
				
				ObjectOutputStream OutputData = new ObjectOutputStream(meSocket.getOutputStream());
				OutputData.writeObject(data);
				meSocket.close();
				
				/*
				DataOutputStream outletFlow = new DataOutputStream(meSocket.getOutputStream());
				outletFlow.writeUTF(field1.getText());
				outletFlow.close();*/
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}
			
		}
		
	}
	
	private JTextField field1;
	private JComboBox ip;
	private JLabel nick;
	private JButton meButton;
	private JTextArea chatField;
	
	@Override
	public void run() {
		
		try {
			
			ServerSocket serverClient = new ServerSocket(9090);
			Socket client;
			
			SendSet receivedData;
			while(true) {
				client=serverClient.accept();
				
				ObjectInputStream dataIn = new ObjectInputStream(client.getInputStream());
				
				receivedData=(SendSet) dataIn.readObject();
				
				
				chatField.append("\n"+receivedData.getNick()+" :"
						+receivedData.getMessage());
				
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
}

class SendSet implements Serializable{
	
	private String nick;
	private String ip;
	private String message;
	private ArrayList<String> ipList;
	
	public ArrayList<String> getIpList() {
		return ipList;
	}
	public void setIpList(ArrayList<String> ipList) {
		this.ipList = ipList;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}


















