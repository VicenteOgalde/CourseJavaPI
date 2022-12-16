package com.VO.products;

import java.util.Date;

public class Product {
	
	private String id;
	private String  name;
	private String section;
	private Double price;
	private Date date;
	public Product(String id, String name, String section, Double price, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.section = section;
		this.price = price;
		this.date = date;
	}
	
	
	public Product(String name, String section, Double price, Date date) {
		super();
		this.name = name;
		this.section = section;
		this.price = price;
		this.date = date;
	}


	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Product Id=" + getId() + ",Name=" + getName() + ", Section=" + getSection()
				+ ", Price=" + getPrice() + ", Date=" + getDate();
	}
	
	
	

}
