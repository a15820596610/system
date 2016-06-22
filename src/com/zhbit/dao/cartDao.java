package com.zhbit.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zhbit.entity.HibernateSessionFactory;
import com.zhbit.entity.TBuyer;
import com.zhbit.entity.TSeller;
import com.zhbit.entity.TShop;
import com.zhbit.entity.TShopCart;

public class cartDao {
	
	
	
	/**
	 * 删除购物车的一件商品
	 */
	public Boolean delete(int id){
		Session session = null;
		Transaction transaction = null;
		List<TShopCart> users = new ArrayList<TShopCart>();
		try{
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
	
			TShopCart user = (TShopCart) session.load(TShopCart.class, id);
			session.delete(user);			
			transaction.commit();			
		}catch(Exception e){
			System.out.println("cartDao delete（）发生异常");
			return false;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	
		return true;
	}
	
	
	
	
	/**
	 * 添加商品进购物车
	 */
	public Boolean add(TShop TShop, TSeller TSeller, TBuyer TBuyer, Integer shopAmount, String express) {
    	Timestamp ts = new Timestamp(System.currentTimeMillis());  
    	Session session = null;
		Transaction transaction = null;
		try{
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			
			TShopCart user = new TShopCart();
			
			user.setShopAmount(shopAmount);
			user.setTShop(TShop);
			user.setTSeller(TSeller);
			user.setTBuyer(TBuyer);
			user.setCartTime(ts);
			user.setExpress(express);
			
			session.save(user);
			transaction.commit();
			System.out.println("cartDao  add（）成功");
		}catch(Exception e){
	
			System.out.println("cartDao  add（）发生异常");
			return false;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	
		return true;
	}
	
	
	
	
	/**
	 * 修改购物车某件商品数量
	 */
	public Boolean alter(int id, Integer shopAmount){
		Session session = null;
		Transaction transaction = null;
		List<TShopCart> users = new ArrayList<TShopCart>();
		try{
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			
			TShopCart user = (TShopCart) session.get(TShopCart.class, id);
			user.setShopAmount(shopAmount);
			
			transaction.commit();			
		}catch(Exception e){
				System.out.println("cart alter（）发生异常");
				return false;
		}finally{
				HibernateSessionFactory.closeSession();
		}
			
		return true;
	}
	
	
	
	/**
	 *  购物车查询
	 */
	public List query(String sql){
		List users = new ArrayList();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();	
			users = session.createSQLQuery(sql).addEntity(TShopCart.class).list();
		} catch (Exception e) {
			System.out.println("cartDao query（）失败");
		}
		return users;
	}
}
