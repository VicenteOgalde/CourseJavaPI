package examples;

import javax.swing.JOptionPane;

public class InOutData3 {
	public static void main(String[] args) {
		
		String num1 = JOptionPane.showInputDialog("type a number, please");
		double num2 = Double.parseDouble(num1);
		System.out.print("the root of "+num2+" is ");
		System.out.printf("%1.2f",Math.sqrt(num2));


	}

}
