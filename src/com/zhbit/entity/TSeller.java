package com.zhbit.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * TSeller entity. @author MyEclipse Persistence Tools
 */

public class TSeller implements java.io.Serializable {

	// Fields

	private Integer sellerId;
	private String userName;
	private String password;
	private Timestamp time;
	private String nickName;
	private String email;
	private String phone;
	private Set TShops = new HashSet(0);
	private Set TOrders = new HashSet(0);
	private Set TShopCarts = new HashSet(0);

	// Constructors

	/** default constructor */
	public TSeller() {
	}

	/** minimal constructor */
	public TSeller(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	/** full constructor */
	public TSeller(String userName, String password, Timestamp time,
			String nickName, String email, String phone, Set TShops,
			Set TOrders, Set TShopCarts) {
		this.userName = userName;
		this.password = password;
		this.time = time;
		this.nickName = nickName;
		this.email = email;
		this.phone = phone;
		this.TShops = TShops;
		this.TOrders = TOrders;
		this.TShopCarts = TShopCarts;
	}

	// Property accessors

	public Integer getSellerId() {
		return this.sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set getTShops() {
		return this.TShops;
	}

	public void setTShops(Set TShops) {
		this.TShops = TShops;
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