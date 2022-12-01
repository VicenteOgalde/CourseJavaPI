package oop;

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
		JOptionPane.showMessageDialog(null, "press accept for stop");
		
	}

}
class GiveAnHour implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Date date = new Date();
		System.out.println("date every 5 sec "+date);
		
	}
	
}

