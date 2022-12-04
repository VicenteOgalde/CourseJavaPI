package exceptions;


import java.util.Scanner;
import javax.swing.JOptionPane;


public class ExceptionFinally {
    
    public static void main(String[] args) {
        
        int figure = 0;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Choose an option:\n1. Square\n2. Rectangle\n3. "
                + "Triangle\n4. Circle");
        try {
        figure = sc.nextInt();
        }catch(Exception e) {
        	System.out.println("Error option is not a number");
        }finally {// always run the code on the finally 
        sc.close(); 
        }
        switch(figure){
            
            case 1: 
                
                int side = Integer.parseInt(JOptionPane.showInputDialog("En"
                        + "ter the side:"));
                System.out.println(Math.pow(side, 2));
                
                break;
                
            case 2:
                
                int base = Integer.parseInt(JOptionPane.showInputDialog("En"
                        + "ter the base:"));
                int heigth = Integer.parseInt(JOptionPane.showInputDialog("En"
                        + "ter the heigth: "));
                
                System.out.println("the area of the rectangle is: " + base*heigth);
                
                break;
                
            case 3:
                
                base = Integer.parseInt(JOptionPane.showInputDialog("En"
                        + "ter the base:"));
                heigth = Integer.parseInt(JOptionPane.showInputDialog("En"
                        + "ter the heigth: "));
                
                System.out.println("the area of the triangle is: " + 
                        (base*heigth)/2);
                
                break;
                
            case 4:
                
                int radio = Integer.parseInt(JOptionPane.showInputDialog("En"
                        + "ter the radio: "));
                System.out.println("the area of the circle is: ");
                System.out.println(Math.PI*(Math.pow(radio, 2)));
                
                break;
                
            default:
                System.out.println("the option is not correct.");
        }
 //-----------------------------------------------------------------------------
 
        int heigth = Integer.parseInt(JOptionPane.showInputDialog("enter "
                + "your height on cm: "));
        
        System.out.printf("if you are a man your ideal weigh is: %d kg.", heigth-110);
        System.out.println();
        System.out.printf("if you are a woman your ideal weigh is: %d kg.", heigth-120);
        
              
    }
    
}