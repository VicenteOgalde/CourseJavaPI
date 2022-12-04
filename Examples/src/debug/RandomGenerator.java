package debug;

import javax.swing.JOptionPane;

public class RandomGenerator {

 public static void main(String[] args) {
  // TODO Auto-generated method stub
  int elements = Integer.parseInt(JOptionPane.showInputDialog("Enter the length of the array"));
  int numRandom[] = new int[elements];
  
  for(int i = 0; i < numRandom.length; i++) {
	  numRandom[i] = (int)(Math.random()*100);
	  
  }
  
  for(int elem: numRandom) {
   System.out.println(elem);
  }
 }

}