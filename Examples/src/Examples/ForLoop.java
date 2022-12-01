package examples;

import javax.swing.JOptionPane;

public class ForLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		for(int i=0;i<10;i++) {
			System.out.println("hello "+(i+1)+" times");
		}
		for(int i=10;i>=0;i--) {
			System.out.println("hello countdown "+i);
		}
		*/
		int emailCheck=0;
		String email=JOptionPane.showInputDialog("type your email: ");
		
		for(int i=0;i<email.length();i++) {
			
			if(email.charAt(i)=='@') {
				emailCheck=emailCheck+1;
			
			}
						
		}
		if(emailCheck>1 || emailCheck==0) {
			System.out.println("incorrect email");
		}else if(emailCheck==1) {
			System.out.println("correct email");
		}
	}

}
