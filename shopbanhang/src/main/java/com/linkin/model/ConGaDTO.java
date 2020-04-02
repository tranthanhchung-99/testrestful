package com.linkin.model;

public class ConGaDTO {
	private Long id;
	private String name;
	private int age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ConGaDTO(Long id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public ConGaDTO(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public ConGaDTO() {
		super();
	}

}
