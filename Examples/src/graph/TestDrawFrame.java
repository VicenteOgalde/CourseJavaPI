package graph;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestDrawFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameDraw frameDraw = new FrameDraw();
		frameDraw.setVisible(true);
		frameDraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	

}
class FrameDraw extends JFrame{
	public FrameDraw(){
		setTitle("Draw Frame");
		
		setSize(480,480);
		SheetDraw sheetDraw = new SheetDraw();
		add(sheetDraw);
		
	}
}
class SheetDraw extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(50, 50, 200, 200);
	}
}