package oop;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TestTemp2 {

	public static void main(String[] args) {
		
		Watch meWatch = new Watch(2000,true);
		
		meWatch.start();
		
		JOptionPane.showMessageDialog(null, "press ok for finish");
		System.exit(0);

	}

}

class Watch{
	private int interval;
	private boolean sonic;
	public Watch(int interval,boolean sonic) {
		this.interval=interval;
		this.sonic=sonic;
	}
	public void start() {
		class GiveAnHour2 implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Date date = new Date();
				System.out.println("time every 2 sec: "+date);
				if(sonic) {
					Toolkit.getDefaultToolkit().beep();
				}
				
			}
			
		}
		ActionListener e = new GiveAnHour2();
		
		Timer meTimer= new Timer(interval,e);
		
		meTimer.start();
		
		
	}
	
}
