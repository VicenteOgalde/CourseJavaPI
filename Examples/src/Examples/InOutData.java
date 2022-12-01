package examples;

import java.util.Scanner;

public class InOutData {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("type your name: ");
		String name=scanner.nextLine();
		System.out.println("your name is "+name);
		System.out.println("type your age: ");
		int age=scanner.nextInt();
		System.out.println("your age is "+age);
		scanner.close();
		
	}

}
