package threadUse;

public class SynchronizingThreads {

	public static void main(String[] args) {
		
		MultipleThreads thread1= new MultipleThreads();
		MultipleThreads2 thread2= new MultipleThreads2(thread1);
		
		thread2.start();
		
		thread1.start();
		
		
		
		/*
		try {
			thread1.join();//forces to finish all tasks in this thread first
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thread2.start();
		
		try {
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("all task finish");

	}

}

class MultipleThreads extends Thread{
	
	public void run(){
		for(int i=0;i<15;i++) {
			System.out.println("execute thread "+this.getName());
		}
	}
	
}
class MultipleThreads2 extends Thread{
	
	private Thread thread;
	
	public MultipleThreads2(Thread t) {
		this.thread=t;
	}
	
	public void run(){
		
		try {
			thread.join();//now you need to wait for the first thread to finish
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<15;i++) {
			System.out.println("execute thread "+this.getName());
		}
	}
	
}