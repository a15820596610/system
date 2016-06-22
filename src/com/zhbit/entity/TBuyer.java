package com.zhbit.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * TBuyer entity. @author MyEclipse Persistence Tools
 */

public class TBuyer implements java.io.Serializable {

	// Fields

	private Integer buyerId;
	private String username;
	private String userPassword;
	private Timestamp time;
	private String email;
	private String nickName;
	private String address;
	private Integer phone;
	private Set TOrders = new HashSet(0);
	private Set TShopCarts = new HashSet(0);

	// Constructors

	/** default constructor */
	public TBuyer() {
	}

	/** minimal constructor */
	public TBuyer(String username, String userPassword) {
		this.username = username;
		this.userPassword = userPassword;
	}

	/** full constructor */
	public TBuyer(String username, String userPassword, Timestamp time,
			String email, String nickName, String address, Integer phone,
			Set TOrders, Set TShopCarts) {
		this.username = username;
		this.userPassword = userPassword;
		this.time = time;
		this.email = email;
		this.nickName = nickName;
		this.address = address;
		this.phone = phone;
		this.TOrders = TOrders;
		this.TShopCarts = TShopCarts;
	}

	// Property accessors

	public Integer getBuyerId() {
		return this.buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPhone() {
		return this.phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public Set getTOrders() {
		return this.TOrders;
	}

	public void setTOrders(Set TOrders) {
		this.TOrders = TOrders;
	}

	public Set getTShopCarts() {
		return this.TShopCarts;
	}

	public void setTShopCarts(Set TShopCarts) {
		this.TShopCarts = TShopCarts;
	}

}