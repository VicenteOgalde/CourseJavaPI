package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FirstTestEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("run the program type 1 \nexit the program type 2");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		if (choice == 1) {
			try {
				inputData();
			} catch (InputMismatchException e) {
				System.out.println("age incorrect");
			}
		} else {
			System.out.println("bye");
			System.exit(0);
		}
		sc.close();
	}

	static void inputData() throws InputMismatchException {

		Scanner sc = new Scanner(System.in);
		System.out.println("type your name: ");
		String userName = sc.nextLine();
		System.out.println("type your age: ");
		int age = sc.nextInt();
		System.out.println("your name is: " + userName + " and your age is: " + age);
		sc.close();

	}

}
