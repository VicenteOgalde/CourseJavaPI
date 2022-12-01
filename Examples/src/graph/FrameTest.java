package graph;

import javax.swing.JFrame;

public class FrameTest {

	public static void main(String[] args) {
		
		MeFrame meFrame = new MeFrame();
	
		

	}

}

class MeFrame extends JFrame{
	
	public MeFrame(){
		setSize(480, 320);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
