package oop;

public final class Boss extends Employee implements Cloneable {
	
	private double bonus;

	public Boss(String name,double salary,int year,int month,int day) {
		super(name,salary,year,month,day);
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public double getSalary(){//override the method of the father class or super class
		double sb=super.getSalary();//call the method for the father class
		return sb+bonus;
	}
	public Object clone ()  throws CloneNotSupportedException {
		/*
		Boss x = new Boss(null,0,0,0,0);
		x.setName(this.getName());
		x.setSalary(super.getSalary());
		x.setBonus(this.getBonus());
		x.setContractF(this.getContractF());
			*/
		Boss x = (Boss) super.clone();
		
		return x;
	}
}
