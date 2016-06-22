package com.zhbit.action;

import com.opensymphony.xwork2.ActionSupport;


public class test extends ActionSupport{
	private String shopAmount;
	private String role;
	private String buyer;
	private String seller;
	private String manager;
	public String getBuyer() {
		return buyer;
	}


	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}


	public String getSeller() {
		return seller;
	}


	public void setSeller(String seller) {
		this.seller = seller;
	}


	public String getManager() {
		return manager;
	}


	public void setManager(String manager) {
		this.manager = manager;
	}


	public String execute() throws Exception{
		System.out.println("buyer"+buyer);
		System.out.println("seller"+seller);
		System.out.println("manager"+manager);
		return null;
	}
	
	
	public String getShopAmount() {
		return shopAmount;
	}

	public void setShopAmount(String shopAmount) {
		this.shopAmount = shopAmount;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
