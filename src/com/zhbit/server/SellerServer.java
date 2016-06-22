package com.zhbit.server;

import java.util.Iterator;
import java.util.List;

import com.zhbit.dao.buyerDao;
import com.zhbit.dao.sellerDao;
import com.zhbit.entity.TBuyer;
import com.zhbit.entity.TSeller;

public class SellerServer {
	private sellerDao no = new sellerDao();
	
	public TSeller getSingleSeller(String sql){
		List list = no.query(sql);
		Iterator it = list.iterator();
		TSeller seller = (TSeller)it.next();
		System.out.println("test id="+seller.getSellerId());
		return seller;
	}
	
	
	
	
}
