package graph;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WritingFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameText frameText = new FrameText();
		
		frameText.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class FrameText extends JFrame{
	
	public FrameText() {
		setVisible(true);
		setSize(600,750);
		setLocation(400,200);
		setTitle("first text");
		SheetText sheetText = new SheetText();
		this.add(sheetText);
	}
}
class SheetText extends JPanel{
	public SheetText() {
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("learning swing", 100, 100);
	}
}