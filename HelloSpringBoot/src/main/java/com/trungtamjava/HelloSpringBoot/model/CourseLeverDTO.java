package com.trungtamjava.HelloSpringBoot.model;

public class CourseLeverDTO {
	private Long id ;
	private String leverName;
	private String leverUrl;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLeverName() {
		return leverName;
	}
	public void setLeverName(String leverName) {
		this.leverName = leverName;
	}
	public String getLeverUrl() {
		return leverUrl;
	}
	public void setLeverUrl(String leverUrl) {
		this.leverUrl = leverUrl;
	}
	public CourseLeverDTO(Long id, String leverName, String leverUrl) {
		super();
		this.id = id;
		this.leverName = leverName;
		this.leverUrl = leverUrl;
	}
	public CourseLeverDTO() {
		super();
	}
	
}
