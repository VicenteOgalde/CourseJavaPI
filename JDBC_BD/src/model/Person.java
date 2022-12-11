package model;

public class Person {
	
	private int id;
	private String name;
	private String comuna;
	private String region;
	
	public Person() {
		
	}

	public Person(int id, String name, String comuna, String region) {
		super();
		this.id = id;
		this.name = name;
		this.comuna = comuna;
		this.region = region;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}
