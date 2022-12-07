package threadUse;

public class SynchronizingThreads {

	public static void main(String[] args) {
		
		MultipleThreads thread1= new MultipleThreads();
		MultipleThreads thread2= new MultipleThreads();
		
		thread1.start();
		
		try {
			thread1.join();//forces to finish all tasks in this thread first
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thread2.start();

	}

}

class MultipleThreads extends Thread{
	
	public void run(){
		for(int i=0;i<15;i++) {
			System.out.println("execute thread "+this.getName());
		}
	}
	
}
