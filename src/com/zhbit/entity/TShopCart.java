package com.zhbit.entity;

import java.sql.Timestamp;

/**
 * TShopCart entity. @author MyEclipse Persistence Tools
 */

public class TShopCart implements java.io.Serializable {

	// Fields

	private Integer cartId;
	private TShop TShop;
	private TSeller TSeller;
	private TBuyer TBuyer;
	private Integer shopAmount;
	private String express;
	private Timestamp cartTime;

	// Constructors

	/** default constructor */
	public TShopCart() {
	}

	/** full constructor */
	public TShopCart(TShop TShop, TSeller TSeller, TBuyer TBuyer,
			Integer shopAmount, String express, Timestamp cartTime) {
		this.TShop = TShop;
		this.TSeller = TSeller;
		this.TBuyer = TBuyer;
		this.shopAmount = shopAmount;
		this.express = express;
		this.cartTime = cartTime;
	}

	// Property accessors

	public Integer getCartId() {
		return this.cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public TShop getTShop() {
		return this.TShop;
	}

	public void setTShop(TShop TShop) {
		this.TShop = TShop;
	}

	public TSeller getTSeller() {
		return this.TSeller;
	}

	public void setTSeller(TSeller TSeller) {
		this.TSeller = TSeller;
	}

	public TBuyer getTBuyer() {
		return this.TBuyer;
	}

	public void setTBuyer(TBuyer TBuyer) {
		this.TBuyer = TBuyer;
	}

	public Integer getShopAmount() {
		return this.shopAmount;
	}

	public void setShopAmount(Integer shopAmount) {
		this.shopAmount = shopAmount;
	}

	public String getExpress() {
		return this.express;
	}

	public void setExpress(String express) {
		this.express = express;
	}

	public Timestamp getCartTime() {
		return this.cartTime;
	}

	public void setCartTime(Timestamp cartTime) {
		this.cartTime = cartTime;
	}

}