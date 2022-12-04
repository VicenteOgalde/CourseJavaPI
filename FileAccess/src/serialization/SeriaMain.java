package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SeriaMain {

	public static void main(String[] args) {
		
		Boss boss1 = new Boss("sun",15000,2000,12,30);
		Employee[] employees= new Employee[3];
		employees[0]=boss1;
		employees[1]=new Employee("moon", 10000, 1990, 10, 20);
		employees[2]=new Employee("ton", 11000, 1995, 10, 22);
		try {
			ObjectOutputStream writeObj= new ObjectOutputStream
					(new FileOutputStream("D:/Proyectos JAVA/"
							+ "CursoPildorasInformaticas/"
							+ "FileAccess/TestObj/ObjTestWrite.dat"));
			writeObj.writeObject(employees);
			writeObj.close();
			ObjectInputStream readObj= new ObjectInputStream(new FileInputStream(
					"D:/Proyectos JAVA/"
							+ "CursoPildorasInformaticas/"
							+ "FileAccess/TestObj/ObjTestWrite.dat"));
			Employee[]employeesTemp=(Employee[])readObj.readObject();
			readObj.close();
			for(Employee emp:employeesTemp) {
				System.out.println(emp.getName());
			}
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
