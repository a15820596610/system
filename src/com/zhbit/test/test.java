package com.zhbit.test;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;


import com.zhbit.dao.buyerDao;
import com.zhbit.dao.cartDao;
import com.zhbit.dao.orderDao;
import com.zhbit.dao.sellerDao;
import com.zhbit.dao.shopDao;
import com.zhbit.entity.TBuyer;
import com.zhbit.entity.TOrder;
import com.zhbit.entity.TSeller;
import com.zhbit.entity.TShop;
import com.zhbit.entity.TShopCart;

public class test  {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
/*		 buyerDao buyer = new buyerDao();		 
		if( buyer.add("asdfasdf","1221212") ){
			System.out.println("6666");
		}*/
//		
//		
		
//		鏌ヨ�?----涓婃灦鍟嗗搧
//		shopDao shopdao = new shopDao();		  
//		List list = shopdao.query(""); 
//		Iterator it = list.iterator();
//      while (it.hasNext()) {
//        	TShop shop = (TShop)it.next();
//	         System.out.println(shop.getShopPhoto());
//        }

      
/*		 ��ʾ��Ʒ����   ����ǰ��λ�����ַ�
		 shopDao shopdao = new shopDao();		  
		  List list = shopdao.query("���ϼ�");
		  Iterator it = list.iterator();
		  while(it.hasNext()){
		 	 TShop shop = (TShop)it.next();
			 	if(shop.getShopIntroduce().length() < 20){
					System.out.println("shop.getShopIntroduce().substring(0, shop.getShopIntroduce().length())");
				}else{
					System.out.println("String="+shop.getShopIntroduce().substring(0,20 ));
				}
		  }*/

        
        
//		获取商品上架背后的卖家名�?
//		  shopDao shopdao = new shopDao();		  
//		  List list = shopdao.query("已上�?); 
//		  Iterator it = list.iterator();
//		  while(it.hasNext()){
//			 	TShop shop = (TShop)it.next();
//			 	System.out.println("啦啦啦啦"+shop.getTSeller().getUserName());
//		 }
		

		
//		cartDao cartDao = new cartDao();	  
//		List list = cartDao.query("from TShopCart where TBuyer.buyerId=1");  
//		Iterator it = list.iterator();
//		 while(it.hasNext()){
//			 	TShopCart cart = (TShopCart)it.next();
//			 	System.out.println("啦啦啦啦"+cart.getCartId());
//		 }

		 
		String str = ",5,5,2";
		 StringTokenizer st = new StringTokenizer(str,",");
	     while(st.hasMoreTokens() ){
	    	 String a = st.nextToken();

	    	 if( !a.equalsIgnoreCase("on") ){
	    		 System.out.println(a);
	    	 }
	       
	     }
	
		
	}


}
