package com.zhbit.entity;

import java.sql.Timestamp;

/**
 * TOrder entity. @author MyEclipse Persistence Tools
 */

public class TOrder implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private TShop TShop;
	private TSeller TSeller;
	private TBuyer TBuyer;
	private Timestamp orderTime;
	private String orderStatus;
	private String isFinish;
	private String express;
	private Integer shopAmount;

	// Constructors

	/** default constructor */
	public TOrder() {
	}

	/** full constructor */
	public TOrder(TShop TShop, TSeller TSeller, TBuyer TBuyer,
			Timestamp orderTime, String orderStatus, String isFinish,
			String express, Integer shopAmount) {
		this.TShop = TShop;
		this.TSeller = TSeller;
		this.TBuyer = TBuyer;
		this.orderTime = orderTime;
		this.orderStatus = orderStatus;
		this.isFinish = isFinish;
		this.express = express;
		this.shopAmount = shopAmount;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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

	public Timestamp getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getIsFinish() {
		return this.isFinish;
	}

	public void setIsFinish(String isFinish) {
		this.isFinish = isFinish;
	}

	public String getExpress() {
		return this.express;
	}

	public void setExpress(String express) {
		this.express = express;
	}

	public Integer getShopAmount() {
		return this.shopAmount;
	}

	public void setShopAmount(Integer shopAmount) {
		this.shopAmount = shopAmount;
	}

}