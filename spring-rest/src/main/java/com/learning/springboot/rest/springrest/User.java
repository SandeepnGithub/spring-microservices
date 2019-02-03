package com.learning.springboot.rest.springrest;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFilter;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Details About User")
//@JsonFilter("userFilter")
@Entity
public class User {
	
	
	public User() {
		
	}

	private String name;
	@Id
	@GeneratedValue
	private Integer id;

	public User(String name, Integer id) {
		super();
		this.name = name;
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
