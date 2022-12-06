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
		
		setBounds(600,300,600,350);
		
		setTitle ("Rebounds");
		
		sheet=new SheetBall();
		
		add(sheet, BorderLayout.CENTER);
		
		JPanel sheetBoton=new JPanel();
		
		start1=new JButton("Thread 1");
		start1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int nt=1;
				gameStart(nt);
				
			}
		});
		sheetBoton.add(start1);
		
		start2=new JButton("Thread 2");
		start2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int nt=2;
				gameStart(nt);
				
			}
		});
		sheetBoton.add(start2);
		
		start3=new JButton("Thread 3");
		start3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int nt=3;
				gameStart(nt);
				
			}
		});
		sheetBoton.add(start3);
		
		stop1=new JButton("Stop 1");
		stop1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int nt=1;
				stop(nt);
				
			}
		});
		sheetBoton.add(stop1);
		
		stop2=new JButton("Stop 2");
		stop2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int nt=3;
				stop(nt);
				
			}
		});
		sheetBoton.add(stop2);
		
		stop3=new JButton("Stop 3");
		stop3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int nt=3;
				stop(nt);
				
			}
		});
		sheetBoton.add(stop3);
		
		
		
		/*
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
		*/
		add(sheetBoton, BorderLayout.SOUTH);
	}
	
	
	//we put buttons
	/*
	public void putButton(Container c, String title, ActionListener listener){
		
		JButton boton=new JButton(title);
		
		c.add(boton);
		
		boton.addActionListener(listener);
		
	}
	*/
	//Add ball and boot 1000 times
	
	public void gameStart (int i){
		
					
			Ball ball=new Ball();
			
			sheet.add(ball);
			
			Runnable r=new BallThread(ball, sheet);
			if(i==1) {
				t=new Thread(r);
				t.start();
			}else if(i==2) {
				t2=new Thread(r);
				t2.start();
			}else if(i==3) {
				t3=new Thread(r);
				t3.start();
			}
			
			
			//Thread t = new Thread(r);
			/*
			if(e.getSource().equals("start1")) {
				System.out.println(e);
				t = new Thread(r);
				t.start();
				
			}else if(e.getSource().equals("start2")) {
				t2 = new Thread(r);
				t2.start();
				
			}else if(e.getSource().equals("start3")) {
				t3 = new Thread(r);
				t3.start();
			}*/
			
			
			
			
			
		
		
	}
	
	public void stop(int i) {
		//t.stop();
		/*	if(e.getSource().equals("stop1")) {
			t.interrupt();
		}else if(e.getSource().equals("stop2")) {
			t2.interrupt();
		}else if(e.getSource().equals("stop3")) {
			t3.interrupt();
		}*/
		if(i==1) {
			t.interrupt();
		}else if(i==2) {
			t2.interrupt();
		}else if(i==3) {
			t3.interrupt();
		}
		
		
	}
	
	SheetBall sheet;
	Thread t,t2,t3;
	JButton start1,start2,start3,stop1,stop2,stop3;
	
	
}