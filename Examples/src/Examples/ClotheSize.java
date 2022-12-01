package examples;

import java.util.Scanner;

public class ClotheSize {
	
	//enum size{SMALL,MEDIUM,LARGE,XTRALARGE};
	enum size{
		SMALL("S"),MEDIUM("M"),LARGE("L");
		private size(String abbreviaton) {
			this.abbreviaton=abbreviaton;
		}
		private String abbreviaton;
		public String getAbbreviaton() {
			return abbreviaton;
		}
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* size s=size.SMALL;
		size m=size.MEDIUM;
		*/
		Scanner sc = new Scanner(System.in);
		System.out.println("Write your clothe size: Small, Medium , Large");
		String dataIn = sc.next().toUpperCase();
		size meSize=Enum.valueOf(size.class, dataIn);
		System.out.println("Clothe size="+meSize);
		System.out.println("Abbreviation="+meSize.abbreviaton);
		
		
	}

}
