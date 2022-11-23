package Examples;

import java.util.Scanner;

public class WhilePractice {

	public static void main(String[] args) {
		int random= (int)(Math.random()*100);
		Scanner scanner = new Scanner(System.in);
		int number=0;
		int tries=0;
		do{
			tries++;
			System.out.println("type your number");
			number=scanner.nextInt();
			if(random < number) {
				System.out.println("your number is greater");
				
			}else if(random>number){
				System.out.println("your number is lesser");
			}
		}while(number!=random) ;
		System.out.println("nice that is the number "+number+" , you try "+tries+" times");
		scanner.close();

	}

}
