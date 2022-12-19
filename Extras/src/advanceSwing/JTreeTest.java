package advanceSwing;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class JTreeTest {

	public static void main(String[] args) {
		JFrame meFrame = new FrameTree();
		meFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		meFrame.setVisible(true);

	}

}
class FrameTree extends JFrame{
	public FrameTree() {
		setTitle("Test JTree");
		setBounds(400, 300, 400, 300);
		
		DefaultMutableTreeNode root= new DefaultMutableTreeNode("World");
		DefaultMutableTreeNode rootCh= new DefaultMutableTreeNode("Spain");
		root.add(rootCh);
		DefaultMutableTreeNode rootChCh= new DefaultMutableTreeNode("Madrid");
		rootCh.add(rootChCh);
		DefaultMutableTreeNode rootCh2= new DefaultMutableTreeNode("France");
		root.add(rootCh2);
		DefaultMutableTreeNode rootChCh2= new DefaultMutableTreeNode("Paris");
		rootCh2.add(rootChCh2);
		
		JTree meTree = new JTree(root); 
		SheetTree sheetTree= new SheetTree(meTree);
		add(sheetTree);
	}
}
class SheetTree extends JPanel{
	
	public SheetTree(JTree meTree) {
		
		setLayout(new BorderLayout());
		add(meTree,BorderLayout.NORTH);
		
	}
	
	
}
