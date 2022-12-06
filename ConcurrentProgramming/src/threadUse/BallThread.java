package threadUse;

import java.awt.Component;

public class BallThread implements Runnable{
	
	private Ball ball;
	private Component component;

	public BallThread(Ball oneBall,Component comp ) {
		this.ball=oneBall;
		this.component=comp;
	}
	
	@Override
	public void run() {
		
		for (int i=1; i<=3000; i++){
			
			ball.ball_move(component.getBounds());    
			
			component.paint(component.getGraphics());
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		
	}

}
