package com.hy.springpractice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "role_authorities")
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@JoinColumn(name = "userid")
	@ManyToOne
	private User user;
	private String therole;
	
	public Role() {
	}
	
	
	public Role(User user, String therole) {
		this.user = user;
		this.therole = therole;
	}


	public String getTherole() {
		return therole;
	}
	public void setTherole(String therole) {
		this.therole = therole;
	}
	public Long getId() {
		return id;
	}
	public User getUser() {
		return user;
	}

	
	
}
