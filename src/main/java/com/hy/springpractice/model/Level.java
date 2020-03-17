package com.hy.springpractice.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "level_authorities")
public class Level {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "userid")
	private User userid;
	private String thelevel;
	
	public Level() {
	}
	
	public Level(User userid, String thelevel) {
		super();
		this.userid = userid;
		this.thelevel = thelevel;
	}
	
	public User getUserid() {
		return userid;
	}
	public void setUserid(User userid) {
		this.userid = userid;
	}
	public String getThelevel() {
		return thelevel;
	}
	public void setThelevel(String thelevel) {
		this.thelevel = thelevel;
	}
	public Long getId() {
		return id;
	}
	
	
	
	
	
}
