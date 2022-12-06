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
		
		b1=new JButton("thread 1");
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				gameStart(e);
				
			}
		});
		
		sheetBoton.add(b1);
		
		b2=new JButton("thread 2");
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				gameStart(e);
				
			}
		});
		
		sheetBoton.add(b2);
		

		b3=new JButton("thread 3");
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				gameStart(e);
				
			}
		});
		
		sheetBoton.add(b3);
		
		st1=new JButton("Stop 1");
		st1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				stop(t1);
				
			}
		});
		
		sheetBoton.add(st1);
		
		st2=new JButton("Stop 2");
		st2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				stop(t2);
				
			}
		});
		
		sheetBoton.add(st2);
		
		st3=new JButton("Stop 3");
		st3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				stop(t3);
				
			}
		});
		
		sheetBoton.add(st3);
		
		
		
		add(sheetBoton, BorderLayout.SOUTH);
	}
	
	
	//we put buttons
	
	public void putButton(Container c, String title, ActionListener listener){
		
		JButton boton=new JButton(title);
		
		c.add(boton);
		
		boton.addActionListener(listener);
		
	}
	
	//Add ball and boot 1000 times
	
	public void gameStart (ActionEvent e){
		
					
			Ball ball=new Ball();
			
			sheet.add(ball);
			
			Runnable r=new BallThread(ball, sheet);
			
			if(e.getSource().equals("b1")) {
				t1 = new Thread(r);
				t1.start();
			}else if(e.getSource().equals("b2")) {
				t2 = new Thread(r);
				t2.start();
			}else if(e.getSource().equals("b3")) {
				t3 = new Thread(r);
				t3.start();
			}
			
			//Thread t = new Thread(r);
			//t = new Thread(r);
			//t.start();
			
			
			
		
		
	}
	public void stop(Thread t) {
		t.interrupt();;
	}
	

	
	private SheetBall sheet;
	 private Thread t1,t2,t3;
	 private JButton b1,b2,b3,st1,st2,st3;
	 
	
	
}