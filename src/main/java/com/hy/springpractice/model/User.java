package com.hy.springpractice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "my_users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String theusername;
	private String thepassword;
	
	public User() {
	}
	
	public Long getId() {
		return id;
	}
	public String getTheusername() {
		return theusername;
	}
	public void setTheusername(String theusername) {
		this.theusername = theusername;
	}
	public String getThepassword() {
		return thepassword;
	}
	public void setThepassword(String thepassword) {
		this.thepassword = thepassword;
	}
	
	
	
	
}
