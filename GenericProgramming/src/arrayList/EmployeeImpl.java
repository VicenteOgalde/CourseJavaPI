package arrayList;

import java.util.ArrayList;

public class EmployeeImpl {

	public static void main(String[] args) {
		
		ArrayList<Employee> employees= new ArrayList<Employee>();
		//employees.ensureCapacity(15);
		employees.add(new Employee("sun",50000,2000,11,25));
		employees.add(new Employee("moon",50500,2000,11,24));
		employees.add(new Employee("sid",56000,2000,11,15));
		//employees.trimToSize();
		for(Employee e:employees) {
			System.out.println(e.getName());
		}

	}

}
