package oop;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TestTemp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GiveAnHour giveAnHour= new GiveAnHour();

		Timer meTimer= new Timer(2000,giveAnHour);
		
		meTimer.start();
		JOptionPane.showMessageDialog(null, "press ok for stop");
		System.exit(0);
		
	}

}
class GiveAnHour implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Date date = new Date();
		System.out.println("date every 2 sec "+date);
		Toolkit.getDefaultToolkit().beep();
		
	}
	
}

