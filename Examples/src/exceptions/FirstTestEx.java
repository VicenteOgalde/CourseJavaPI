package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FirstTestEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		inputData();
		
		}
		
		static void inputData() throws InputMismatchException {
			try {
			Scanner sc = new Scanner(System.in);
			System.out.println("type your name: ");
			String userName=sc.nextLine();
			System.out.println("type your age: ");
			int age = sc.nextInt();
			System.out.println("your name is: "+userName+
					" and your age is: "+age);
			sc.close();
			}catch(InputMismatchException e) {
				System.out.println("age incorrect");
			}
		}

	}


