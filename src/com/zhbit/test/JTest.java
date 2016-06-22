package com.zhbit.test;

import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import com.zhbit.dao.orderDao;
import com.zhbit.entity.TOrder;

public class JTest extends TestCase {

	// ²âÊÔÍ¨¹ýÂò¼ÒID²éÑ¯Âò¼ÒIDµÄ¶©µ¥Á¿  SQLÓï¾ä
	public void testOne(){
		orderDao orderdao = new orderDao();	  // and o.s.cartId=s.cartId")
		List list = orderdao.query("select *from t_order where cartID in (select cartID from t_shopCart where buyerID=1)");  
		Iterator it = list.iterator();
		 while(it.hasNext()){
			 TOrder order = (TOrder) it.next();
			 System.out.println("À²À²À²À²"+order.getOrderId());
		 }
	}
	
	//²âÊÔÂò¼ÒID²éÑ¯Âò¼ÒID¡¶ Î´¸¶¿î ¡·  µÄ¶©µ¥Á¿  SQLÓï¾ä
	public void testTwo(){
		orderDao orderdao = new orderDao();	  // and o.s.cartId=s.cartId")
		List list = orderdao.query("select *from t_order where orderStatus='Î´¸¶¿î' and cartID in (select cartID from t_shopCart "
	 		+ "where buyerID="+1+")");  
		Iterator it = list.iterator();
		 while(it.hasNext()){
			 	TOrder order = (TOrder) it.next();
			 
			 	System.out.println("À²À²À²À²"+order.getOrderId());
		 }
	}
}
