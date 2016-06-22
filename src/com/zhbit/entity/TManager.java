package com.zhbit.entity;

import java.sql.Timestamp;

/**
 * TManager entity. @author MyEclipse Persistence Tools
 */

public class TManager implements java.io.Serializable {

	// Fields

	private Integer managerId;
	private String username;
	private String password;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public TManager() {
	}

	/** minimal constructor */
	public TManager(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public TManager(String username, String password, Timestamp time) {
		this.username = username;
		this.password = password;
		this.time = time;
	}

	// Property accessors

	public Integer getManagerId() {
		return this.managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}