package com.linkin.model;

public class TestDTO {
	private String type;
	private int salary;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public TestDTO(String type, int salary) {
		super();
		this.type = type;
		this.salary = salary;
	}
	public TestDTO() {
		super();
	}
	
}
