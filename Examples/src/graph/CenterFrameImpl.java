package graph;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CenterFrameImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CenterFrame meFrame = new CenterFrame();
		
		meFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
class CenterFrame extends JFrame{
	public CenterFrame() {
		
		Toolkit meScreen=Toolkit.getDefaultToolkit();
		Dimension sizeScreen= meScreen.getScreenSize();
		int heightSize=sizeScreen.height;
		int widthSize=sizeScreen.width;
		setTitle("new Frame");
		Image icon=meScreen.getImage("src/graph/user_icon_150670.png");
		setIconImage(icon);
		setSize(widthSize/2, heightSize/2);
		setLocation(heightSize/4, widthSize/4);
		setVisible(true);
		
		
	}
}