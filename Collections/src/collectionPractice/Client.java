package collectionPractice;

public class Client {
	
	private String name;
	private String accNumber;
	private double balance;
	
	public Client(String name,String nAcc,double balance) {
		this.name=name;
		this.accNumber=nAcc;
		this.balance=balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}
