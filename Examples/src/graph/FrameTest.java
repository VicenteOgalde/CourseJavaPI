package graph;

import java.awt.Frame;

import javax.swing.JFrame;

public class FrameTest {

	public static void main(String[] args) {
		
		MeFrame meFrame = new MeFrame();
	
		

	}

}

class MeFrame extends JFrame{
	
	public MeFrame(){
		//setSize(480, 320);//size of the frame
		//setLocation(475, 250);
		setBounds(475, 250, 480, 320);
		setVisible(true);
		//setExtendedState(Frame.MAXIMIZED_BOTH);
		//setResizable(false);
		setTitle("1st Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
