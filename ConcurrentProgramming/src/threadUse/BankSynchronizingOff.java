package threadUse;

public class BankSynchronizingOff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Bank{
	
	private final double[] accounts;
	
	public Bank () {
		accounts= new double[100];
		for(double d: accounts) {
			d=2000;
		}
	}
	public void transfer(int origin,int destiny,double amount) {
		if(accounts[origin]<amount) {
			return;
		}
		System.out.println(Thread.currentThread());
		accounts[origin]=accounts[origin]-amount;
		System.out.printf("%10.2 of %d for %d",amount,origin,destiny);
		accounts[destiny]=accounts[destiny]+amount;
	}
	public double getTotalBalance() {
		double totalBalance=0;
		for(double d:accounts) {
			totalBalance+=d;
		}
		return totalBalance;
	}
	
}
