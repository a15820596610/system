package com.zhbit.test;

import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import com.zhbit.dao.orderDao;
import com.zhbit.entity.TOrder;

public class JTest extends TestCase {

	// ����ͨ�����ID��ѯ���ID�Ķ�����  SQL���
	public void testOne(){
		orderDao orderdao = new orderDao();	  // and o.s.cartId=s.cartId")
		List list = orderdao.query("select *from t_order where cartID in (select cartID from t_shopCart where buyerID=1)");  
		Iterator it = list.iterator();
		 while(it.hasNext()){
			 TOrder order = (TOrder) it.next();
			 System.out.println("��������"+order.getOrderId());
		 }
	}
	
	//�������ID��ѯ���ID�� δ���� ��  �Ķ�����  SQL���
	public void testTwo(){
		orderDao orderdao = new orderDao();	  // and o.s.cartId=s.cartId")
		List list = orderdao.query("select *from t_order where orderStatus='δ����' and cartID in (select cartID from t_shopCart "
	 		+ "where buyerID="+1+")");  
		Iterator it = list.iterator();
		 while(it.hasNext()){
			 	TOrder order = (TOrder) it.next();
			 
			 	System.out.println("��������"+order.getOrderId());
		 }
	}
}
