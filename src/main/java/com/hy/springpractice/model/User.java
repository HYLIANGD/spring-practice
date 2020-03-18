package com.hy.springpractice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "my_users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String theusername;
	private String thepassword;
	@OneToMany(fetch=FetchType.EAGER,
			mappedBy="userid")
	private List<Level> levels;
	
	public User() {
	}
	
	public void addLevel(Level level) {
		if(levels == null) levels = new ArrayList<Level>();
		levels.add(level);
		level.setUserid(this);
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

	public List<Level> getLevels() {
		return levels;
	}

	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}
	
	
	
	
}
