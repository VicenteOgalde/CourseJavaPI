package exceptions;

import javax.swing.JOptionPane;

public class ExceptionsCapture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		divide();
		}catch(ArithmeticException e) {
			System.out.println("you cant divide by zero");
			System.out.println("class that catches the error : "+e.getClass().getName());
		}catch(NumberFormatException e) {
			System.out.println("you must write a number");
			System.out.println("class that catches the error : "+e.getClass().getName());
		}
	}
	static void divide() {
		int num1= Integer.parseInt(JOptionPane.showInputDialog("type number 1"));
		int num2= Integer.parseInt(JOptionPane.showInputDialog("type number 2"));
		System.out.println("the result of the divide operation is : "+num1/num2);
	}

}
