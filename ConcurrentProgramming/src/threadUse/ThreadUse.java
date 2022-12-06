package threadUse;

import java.awt.geom.*;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class ThreadUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame=new ReboundFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		

	}

}




//ball movement-----------------------------------------------------------------------------------------

class Ball{
	
	// Move the ball reversing position if it collides with boundaries
	
	public void ball_move(Rectangle2D limit){
		
		x+=dx;
		
		y+=dy;
		
		if(x<limit.getMinX()){
			
			x=limit.getMinX();
			
			dx=-dx;
		}
		
		if(x + TAMX>=limit.getMaxX()){
			
			x=limit.getMaxX() - TAMX;
			
			dx=-dx;
		}
		
		if(y<limit.getMinY()){
			
			y=limit.getMinY();
			
			dy=-dy;
		}
		
		if(y + TAMY>=limit.getMaxY()){
			
			y=limit.getMaxY()-TAMY;
			
			dy=-dy;
			
		}
		
	}
	
	//Shape of the ball in its initial position
	
	public Ellipse2D getShape(){
		
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
		
	}	
	
	private static final int TAMX=15;
	
	private static final int TAMY=15;
	
	private double x=0;
	
	private double y=0;
	
	private double dx=1;
	
	private double dy=1;
	
	
}

// Sheet that draws the balls----------------------------------------------------------------------


class SheetBall extends JPanel{
	
	//We add ball to the sheet
	
	public void add(Ball b){
		
		balls.add(b);
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		
		for(Ball b: balls){
			
			g2.fill(b.getShape());
		}
		
	}
	
	private ArrayList<Ball> balls=new ArrayList<Ball>();
}


//Frame with foil and buttons------------------------------------------------------------------------------

class ReboundFrame extends JFrame{
	
	public ReboundFrame(){
		
		setBounds(600,300,400,350);
		
		setTitle ("Rebounds");
		
		sheet=new SheetBall();
		
		add(sheet, BorderLayout.CENTER);
		
		JPanel sheetBoton=new JPanel();
		
		putButton(sheetBoton, "Go!", new ActionListener(){
			
			public void actionPerformed(ActionEvent event){
				
				gameStart();
			}
			
		});
		
		
		putButton(sheetBoton, "Exit", new ActionListener(){
			
			public void actionPerformed(ActionEvent event){
				
				System.exit(0);
				
			}
			
			
		});

		putButton(sheetBoton, "Stop", new ActionListener(){
			
			public void actionPerformed(ActionEvent event){
				
				//t.stop();
				t.interrupt();
			}
			
			
		});
		
		add(sheetBoton, BorderLayout.SOUTH);
	}
	
	
	//we put buttons
	
	public void putButton(Container c, String title, ActionListener listener){
		
		JButton boton=new JButton(title);
		
		c.add(boton);
		
		boton.addActionListener(listener);
		
	}
	
	//Add ball and boot 1000 times
	
	public void gameStart (){
		
					
			Ball ball=new Ball();
			
			sheet.add(ball);
			
			Runnable r=new BallThread(ball, sheet);
			
			//Thread t = new Thread(r);
			t = new Thread(r);
			t.start();
			
			
			
		
		
	}
	
	public void stop() {
		t.stop();
	}
	
	private SheetBall sheet;
	 private Thread t;
	
	
}