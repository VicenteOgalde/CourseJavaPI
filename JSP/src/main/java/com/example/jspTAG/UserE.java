package com.example.jspTAG;

public class UserE {
	
	private int id;
	private String name;
	private String surname;
	private String user;
	private String password;
	private String country;
	private String tech;
	public UserE(int id, String name, String surname, String user, String password, String country, String tech) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.user = user;
		this.password = password;
		this.country = country;
		this.tech = tech;
	}
	public UserE() {
		
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	
	
	
	
	
	
	

}
