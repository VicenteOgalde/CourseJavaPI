package instrospection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class TestInstrospection {

	public static void main(String[] args) {
		
		Scanner input= new Scanner(System.in);
		System.out.println("Type the class name : ");
		String nameC= input.next();
		
		
		try {
			Class cl = Class.forName(nameC);
			Class superCl=cl.getSuperclass();
			System.out.println("Class is: "+cl);
			
			if(cl!=null && superCl!=Object.class) {
				System.out.println("extends from "+superCl.getName());
			}
			contrucPrint(cl);
			System.out.println();
			methodPrint(cl);
			System.out.println();
			fieldPrint(cl);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}
	
	public static void contrucPrint(Class cl) {
		Constructor[] consArr=cl.getConstructors();
		
		for (Constructor c : consArr) {
			System.out.print(" "+Modifier.toString(c.getModifiers()));
			System.out.print(" "+c.getName()+"(");
			Class [] params=c.getParameterTypes();
			for (int i=0;i<params.length;i++) {
				if(i>0)System.out.print(", ");
				System.out.print(params[i].getName());
			}
			System.out.print(");");
		}
		
	}
	public static void methodPrint(Class cl) {
		Method [] methods=cl.getDeclaredMethods();
		
		for (Method m : methods) {
			System.out.print(" "+Modifier.toString(m.getModifiers()));
			System.out.print(" "+m.getClass().getName()+" "+m.getName()+" (");
			Class [] params=m.getParameterTypes();
			for (int i=0;i<params.length;i++) {
				if(i>0)System.out.print(", ");
				System.out.print(params[i].getName());
			}
			System.out.print(");");
			System.out.println();
		}
	}
	public static void fieldPrint(Class cl) {
		Field [] f=cl.getDeclaredFields();
		for (Field field : f) {
			System.out.print(" "+Modifier.toString(field.getModifiers()));
			System.out.print(" "+field.getType().getName()+" "+field.getName()+" ;");
			System.out.println();
		}
	}

}
