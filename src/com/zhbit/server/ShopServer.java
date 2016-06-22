package com.zhbit.server;

import java.util.Iterator;
import java.util.List;

import com.zhbit.dao.buyerDao;
import com.zhbit.dao.shopDao;
import com.zhbit.entity.TBuyer;
import com.zhbit.entity.TShop;

public class ShopServer {
	private shopDao no = new shopDao();
	
	public TShop getSingleShop(String sql){
		List list = no.query(sql);
		Iterator it = list.iterator();
		TShop shop = (TShop)it.next();
		return shop;
	}
	
}
