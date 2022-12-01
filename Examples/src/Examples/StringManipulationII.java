package examples;

public class StringManipulationII {

	public static void main(String[] args) {
		
		String phrase ="nice day to learn on JAVA";
		String phrase2 = phrase.substring(5,8);
		System.out.println(phrase2);
		
		String student, student2;
		student="david";
		student2="David";
		System.out.println(student.equalsIgnoreCase(student2));
	}

}
