package arrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class EmployeeImpl {

	public static void main(String[] args) {
		
		ArrayList<Employee> employees= new ArrayList<Employee>();
		//employees.ensureCapacity(15);
		employees.add(new Employee("sun",50000,2000,11,25));
		employees.add(new Employee("moon",50500,2000,11,24));
		employees.add(new Employee("sid",56000,2000,11,15));
		//employees.trimToSize();
		
		//employees.set(0, new Employee("mud",56000,2000,11,15));
		//System.out.println(employees.get(1).getName());
		/*
		for(Employee e:employees) {
			System.out.println(e.getName());
		}*/
		Iterator<Employee> meIterator=employees.iterator();
		
		while(meIterator.hasNext()) {
			System.out.println(meIterator.next().getName());
		}

	}

}
