package ownGenericClass;

import arrayList.Employee;

public class Pair<T> {

	private T first;
	
	public Pair() {
		this.first=null;
	}
	public T getFirst() {
		return first;
	}
	public void setFirst(T first) {
		this.first = first;
	}
	public static void printEmployee(Pair<? extends Employee> p) {
		Employee empTemp=p.first;
		System.out.println(empTemp);
	}
	
}
