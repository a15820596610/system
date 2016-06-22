package com.zhbit.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TShop entity. @author MyEclipse Persistence Tools
 */

public class TShop implements java.io.Serializable {

	// Fields

	private Integer shopId;
	private TSeller TSeller;
	private Double shopPrice;
	private String shopName;
	private Integer shopInventory;
	private String shopPhoto;
	private String shopIntroduce;
	private String isShow;
	private Set TShopCarts = new HashSet(0);
	private Set TOrders = new HashSet(0);

	// Constructors

	/** default constructor */
	public TShop() {
	}

	/** minimal constructor */
	public TShop(TSeller TSeller, Double shopPrice, String shopName,
			Integer shopInventory, String shopPhoto, String shopIntroduce,
			String isShow) {
		this.TSeller = TSeller;
		this.shopPrice = shopPrice;
		this.shopName = shopName;
		this.shopInventory = shopInventory;
		this.shopPhoto = shopPhoto;
		this.shopIntroduce = shopIntroduce;
		this.isShow = isShow;
	}

	/** full constructor */
	public TShop(TSeller TSeller, Double shopPrice, String shopName,
			Integer shopInventory, String shopPhoto, String shopIntroduce,
			String isShow, Set TShopCarts, Set TOrders) {
		this.TSeller = TSeller;
		this.shopPrice = shopPrice;
		this.shopName = shopName;
		this.shopInventory = shopInventory;
		this.shopPhoto = shopPhoto;
		this.shopIntroduce = shopIntroduce;
		this.isShow = isShow;
		this.TShopCarts = TShopCarts;
		this.TOrders = TOrders;
	}

	// Property accessors

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public TSeller getTSeller() {
		return this.TSeller;
	}

	public void setTSeller(TSeller TSeller) {
		this.TSeller = TSeller;
	}

	public Double getShopPrice() {
		return this.shopPrice;
	}

	public void setShopPrice(Double shopPrice) {
		this.shopPrice = shopPrice;
	}

	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Integer getShopInventory() {
		return this.shopInventory;
	}

	public void setShopInventory(Integer shopInventory) {
		this.shopInventory = shopInventory;
	}

	public String getShopPhoto() {
		return this.shopPhoto;
	}

	public void setShopPhoto(String shopPhoto) {
		this.shopPhoto = shopPhoto;
	}

	public String getShopIntroduce() {
		return this.shopIntroduce;
	}

	public void setShopIntroduce(String shopIntroduce) {
		this.shopIntroduce = shopIntroduce;
	}

	public String getIsShow() {
		return this.isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	public Set getTShopCarts() {
		return this.TShopCarts;
	}

	public void setTShopCarts(Set TShopCarts) {
		this.TShopCarts = TShopCarts;
	}

	public Set getTOrders() {
		return this.TOrders;
	}

	public void setTOrders(Set TOrders) {
		this.TOrders = TOrders;
	}

}