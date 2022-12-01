package oop;

public class TestFinalPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeTest emp1= new EmployeeTest("sun");
		EmployeeTest emp2= new EmployeeTest("moon");
		
		emp1.setSection("RRHH");
		System.out.println("Employee: "+emp2.getName()+
				" work in the section: "+emp2.getSection()+" with id: "+emp1.getId());
		System.out.println("Employee: "+emp1.getName()+
				" work in the section: "+emp1.getSection()+" with id: "+emp2.getId());
		
		System.out.println(EmployeeTest.getNextId());
		

	}

}
class EmployeeTest{
	private final String name;
	private String section;
	private int id;
	private static int nextId=1;//static only work for the class not the objects you create
	public EmployeeTest(String name) {
		this.name=name;
		this.section="adm";
		this.id=this.nextId;
		this.nextId++;
	}
	public void setSection(String section) {
		this.section=section;
	}
	public String getSection() {
		return this.section;
	}
	public String getName() {
		return this.name;
	}
	public int getId() {
		return this.id;
	}
	public static String getNextId() {
		return "the next id is : "+nextId;
	}

}
