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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accNumber == null) ? 0 : accNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (accNumber == null) {
			if (other.accNumber != null)
				return false;
		} else if (!accNumber.equals(other.accNumber))
			return false;
		return true;
	}
	
	
	

}
