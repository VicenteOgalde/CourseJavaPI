package ownGenericClass;

import arrayList.Employee;

public class PairImpl {

	public static void main(String[] args) {
		
		Pair<String> mePair= new Pair<>();
		mePair.setFirst("Generic Test");
		System.out.println(mePair.getFirst());
		
		Employee emp1 = new Employee("sol",15000,1955,11,20);
		Pair<Employee>p1=new Pair<Employee>();
		p1.setFirst(emp1);
		
		System.out.println(p1.getFirst().getName());

	}

}
