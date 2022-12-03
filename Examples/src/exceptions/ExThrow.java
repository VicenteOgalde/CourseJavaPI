package exceptions;

import javax.swing.JOptionPane;

public class ExThrow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String email = JOptionPane.showInputDialog("type your email");
		try {
			checkEmail(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static void checkEmail(String email) throws EmailRangeException {
		int check = 0;
		boolean check2 = false;

		if (email.length() <= 3) {
			//Exception e = new Exception();
			//throw new Exception();
			throw new EmailRangeException("The email is to short to be real");
		}
		
			for (int i = 0; i < email.length(); i++) {
				if (email.charAt(i) == '@') {
					check++;
				}
				if (email.charAt(i) == '.') {
					check2 = true;
				}
			}
			if (check > 0 && check2 == true) {
				System.out.println("Correct email");
			} else {
				System.out.println("incorrect email");
			}
		
	}

}
class EmailRangeException extends Exception{
	public EmailRangeException() {}
	public EmailRangeException(String message) {
		super(message);
	}
}
