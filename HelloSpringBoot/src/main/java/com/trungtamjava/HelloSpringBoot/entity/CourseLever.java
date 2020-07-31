package com.trungtamjava.HelloSpringBoot.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course_Lever")
public class CourseLever implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name="lever_name")
	private String leverName;
	
	@Column(name="lever_url")
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

	public CourseLever(Long id, String leverName, String leverUrl) {
		super();
		this.id = id;
		this.leverName = leverName;
		this.leverUrl = leverUrl;
	}

	public CourseLever() {
		super();
	}
	
}
