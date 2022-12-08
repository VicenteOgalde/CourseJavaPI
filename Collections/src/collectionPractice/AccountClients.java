package collectionPractice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AccountClients {

	public static void main(String[] args) {
		
		Client cl1 = new Client("sun","00001",2000);
		Client cl2 = new Client("moon","00002",2020);
		Client cl3 = new Client("cid","00003",2500);
		Client cl4 = new Client("greg","00004",3000);
		Client cl5 = new Client("greg","00004",3000);
		
		Set<Client> clientsBank= new HashSet<Client>();
		clientsBank.add(cl1);
		clientsBank.add(cl2);
		clientsBank.add(cl3);
		clientsBank.add(cl4);
		clientsBank.add(cl5);
		/*
		for (Client client : clientsBank) {
			System.out.println(client.getName()
					+" "+client.getAccNumber());
			if(client.getName().equals("greg")) {
				clientsBank.remove(client);
			}
		}
	
		Iterator<Client> it=clientsBank.iterator();
		
		while(it.hasNext()) {
			String clientName=it.next().getName();
			System.out.println(clientName);
		}*/
		
		Iterator<Client> it=clientsBank.iterator();
		while(it.hasNext()) {
			String clientName=it.next().getName();
			System.out.println(clientName);
			if(clientName.equals("greg")) {
				it.remove();
			}
			}
		for (Client client : clientsBank) {
			System.out.println(client.getName()
					+" "+client.getAccNumber());
		}
		
	}

}
