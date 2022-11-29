package OOP;

public class TestFinalPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeTest emp1= new EmployeeTest("sun");
		EmployeeTest emp2= new EmployeeTest("moon");
		
		emp1.setSection("RRHH");
		System.out.println("Employee: "+emp2.getName()+" work in the section: "+emp2.getSection());
		System.out.println("Employee: "+emp1.getName()+" work in the section: "+emp1.getSection());
		

	}

}
class EmployeeTest{
	private final String name;
	private String section;
	public EmployeeTest(String name) {
		this.name=name;
		this.section="adm";
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

}
