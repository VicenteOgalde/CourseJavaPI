package examples;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class AreaTypes {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose one option: \n1: Square \n2: Rectangle \n3: Triangle \n4: Circle");
		
		int option = scanner.nextInt();
		
		switch(option) {
		
		case 1:
			int side= Integer.parseInt(JOptionPane.showInputDialog("type the side"));
			System.out.println("The area of the square is: "+Math.pow(side, 2));
			break;
		case 2:
			int length= Integer.parseInt(JOptionPane.showInputDialog("type the length"));
			int width = Integer.parseInt(JOptionPane.showInputDialog("type the width"));
			System.out.println("the area of the rectangle is: "+length*width);
			break;
		case 3:
			int height= Integer.parseInt(JOptionPane.showInputDialog("type the height"));
			int base = Integer.parseInt(JOptionPane.showInputDialog("type the base"));
			System.out.println("the area of the triangle is: "+(base*height)/2);
			break;
		case 4:
			int radio=Integer.parseInt(JOptionPane.showInputDialog("type the radio"));
			System.out.print("the area of the circle is: ");
			System.out.printf("%1.2f", Math.PI*(Math.pow(radio, 2)));
			break;
		default:
			System.out.println("incorrect choice");
		}
		scanner.close();

	}

}
