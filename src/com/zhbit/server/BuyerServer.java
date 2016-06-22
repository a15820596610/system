package com.zhbit.server;

import java.util.Iterator;
import java.util.List;

import com.zhbit.dao.buyerDao;
import com.zhbit.entity.TBuyer;

public class BuyerServer {
	private buyerDao no = new buyerDao();
	
	public TBuyer getSingleBuyer(String sql){
		List list = no.query(sql);
		Iterator it = list.iterator();
		TBuyer buyer = (TBuyer)it.next();
		return buyer;
	}
	
	
}
