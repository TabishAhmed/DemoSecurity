package com.rc.demo.account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=Account.TABLE_NAME)
public class Account {
	
	public static final String TABLE_NAME = "user";
	
	@Id
	private Long id;
	private String username;
	private String password;
	
	public Account(){}
	
	public Account(String username, String password, Long id) {
		this.username = username;
		this.password = password;
		this.id = id;
	}
	public Long getId() {
	    return id;
	}
	public void setId(Long id) {
	    this.id = id;
	}
	public String getUsername() {
	    return username;
	}
	public void setUsername(String username) {
	    this.username = username;
	}
	public String getPassword() {
	    return password;
	}
	public void setPassword(String password) {
	    this.password = password;
	}
}
