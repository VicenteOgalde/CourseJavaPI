package threadUse;

import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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

class Bank extends ReentrantLock{
	
	private final double[] accounts;
	//private Lock lock = new ReentrantLock();
	//private Condition enoughBalance;
	
	public Bank () {
		accounts= new double[100];
		for(int i=0;i<accounts.length;i++) {
			accounts[i]=2000;
		}
		//this.enoughBalance=this.newCondition();
	}
	public synchronized void transfer(int origin,int destiny,double amount)throws InterruptedException {
		//this.lock();
		
		//lock.lock();
		//try {
		while(accounts[origin]<amount) {
			
			
			
			/*
			System.out.println("-------------Insufficients funds--------------");
			System.out.println("-------------Account n° "+origin+"-----------------");
			System.out.println("-------------Amount :"+accounts[origin]+"---------------");
			*/
		//	this.enoughBalance.await();
			System.err.println(Thread.currentThread()); 
			
			wait();
			
		}
		
		
		System.out.println(Thread.currentThread());
		accounts[origin]-=amount;
		System.out.printf(" %10.2f of %d for %d ",amount,origin,destiny);
		accounts[destiny]+=amount;
		System.out.printf(" Total Balance: %10.2f%n",getTotalBalance());
		
		notifyAll();
		
		//this.enoughBalance.signalAll();
	//	}catch(Exception e) {
			
	//	}finally {
			//lock.unlock();
			//this.unlock();
	//	}
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










