package ownGenericClass;

import arrayList.Boss;
import arrayList.Employee;

public class GenericInheritance {

	public static void main(String[] args) {
		
		Employee adm1 = new Employee("ana", 15000, 2000,12, 28);
		Boss bossAdm= new Boss("jj", 25000, 2001, 12, 29);
		Employee newAdm=bossAdm;
		
		Pair<Employee> adm2=new Pair<Employee>();
		Pair<Boss> bossAdm2=new Pair<Boss>();
		//Pair<Employee> newEmp2=bossAdm2; //error casting
		Pair.printEmployee(bossAdm2);
		
		

	}

}
