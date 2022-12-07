package threadUse;

public class BankSynchronizingOff {

	public static void main(String[] args) {
		
		Bank b= new Bank();
		
		for(int i=0;i<100;i++) {
			
			TransferExecution r = new TransferExecution(b, i, 2000);
			Thread t = new Thread(r);
			t.start();
			
		}
		
	}

}

class Bank{
	
	private final double[] accounts;
	
	public Bank () {
		accounts= new double[100];
		for(int i=0;i<accounts.length;i++) {
			accounts[i]=2000;
		}
	}
	public void transfer(int origin,int destiny,double amount) {
		if(accounts[origin]<amount) {
			return;
		}
		System.out.println(Thread.currentThread());
		accounts[origin]-=amount;
		System.out.printf(" %10.2f of %d for %d ",amount,origin,destiny);
		accounts[destiny]+=amount;
		System.out.printf(" Total Balance: %10.2f%n",getTotalBalance());
	}
	public double getTotalBalance() {
		double totalBalance=0;
		for(double d:accounts) {
			totalBalance+=d;
		}
		return totalBalance;
	}
	
}

class TransferExecution implements Runnable{

	private Bank bank;
	private int account;
	private double maxTransf;
	
	public TransferExecution(Bank b,int acc,double max) {
		
		this.bank=b;
		this.account=acc;
		this.maxTransf=max;
		
	}
	
	@Override
	public void run() {
		
		try {
		while(true) {
			int destinyAcc=(int)(100*Math.random());
			double amountTf=(maxTransf*Math.random());
			bank.transfer(account, destinyAcc, amountTf);
			
			Thread.sleep((int)(Math.random()*10));
		}
		}catch(InterruptedException e) {
			
		}
	}
	
}










