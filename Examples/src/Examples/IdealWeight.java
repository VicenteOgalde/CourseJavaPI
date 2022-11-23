package Examples;

import javax.swing.JOptionPane;

public class IdealWeight {

	public static void main(String[] args) {
		
		String gender="";
		do {
			gender=JOptionPane.showInputDialog("type your gender:  M - F");
			
		}while(gender.equalsIgnoreCase("M")==false && gender.equalsIgnoreCase("F")==false);
		
		int height = Integer.parseInt(JOptionPane.showInputDialog("type your height"));
		
		int idealWeight =0;
		
		if(gender.equalsIgnoreCase("M")) {
			idealWeight= height-110;
		}
		if(gender.equalsIgnoreCase("F")) {
			idealWeight= height-120;
		}
		System.out.println("your ideal weight is "+idealWeight);

	}

}
