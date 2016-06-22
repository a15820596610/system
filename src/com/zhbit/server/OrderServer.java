package com.zhbit.server;

import java.util.Iterator;
import java.util.List;

import com.zhbit.dao.orderDao;
import com.zhbit.dao.sellerDao;
import com.zhbit.entity.TOrder;
import com.zhbit.entity.TSeller;

public class OrderServer {
	private orderDao no = new orderDao();
	
	public TOrder getSingleOrder(String sql){
		List list = no.query(sql);
		Iterator it = list.iterator();
		TOrder order = (TOrder)it.next();
		return order;
	}
}
