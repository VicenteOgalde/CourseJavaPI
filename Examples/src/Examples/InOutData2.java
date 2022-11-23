package Examples;

import javax.swing.JOptionPane;

public class InOutData2 {

	public static void main(String[] args) {
		
		String userName = JOptionPane.showInputDialog("type your name, please");
		int age = Integer.parseInt(JOptionPane.showInputDialog("type your age"));
		System.out.println("hello "+userName+", you have "+age+" years");
		System.out.println("the next year you will have "+(age+1)+" years");

	}

}
