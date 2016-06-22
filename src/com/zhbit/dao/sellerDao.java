package com.zhbit.dao;
import com.zhbit.entity.HibernateSessionFactory;
import com.zhbit.entity.TSeller;
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
public class sellerDao {
	/**
	 * 删除卖家用户
	 */
	public Boolean delete(int id){
		Session session = null;
		Transaction transaction = null;
		try{
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
	
			TSeller user = (TSeller) session.load(TSeller.class, id);
			session.delete(user);			
			transaction.commit();			
		}catch(Exception e){
			System.out.println("delete（）发生异常");
			return false;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	
		return true;
	}
	
	
	
	
	/**
	 * 添加卖家用户
	 */
	public Boolean add(String username, String password) {
    	Timestamp ts = new Timestamp(System.currentTimeMillis());  
    	Session session = null;
		Transaction transaction = null;
		try{
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			TSeller user = new TSeller();
			
			user.setUserName(username);
			user.setPassword(password);
			user.setTime(ts);
			System.out.println("222222222"+ts);
			
			
			session.save(user);
				
			transaction.commit();

		}catch(Exception e){
			e.printStackTrace();
			System.out.println("add（）发生异常");
			return false;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	
		return true;
	}
	
	
	
	
	/**
	 * 修改卖家用户信息
	 */
	public Boolean alter(int id,String username, String password){
		Session session = null;
		Transaction transaction = null;
		List<TSeller> users = new ArrayList<TSeller>();
		try{
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			TSeller user = (TSeller) session.get(TSeller.class, id);
			user.setUserName(username);
			user.setPassword(password);
			transaction.commit();			
		}catch(Exception e){
				System.out.println("alter（）发生异常");
				return false;
		}finally{
				HibernateSessionFactory.closeSession();
		}
			
		return true;
	}
	
	/**
	 * 卖家用户信息列表
	 */
	
	public List query(String sql){
		List users = new ArrayList();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			if(sql == null || sql == ""){
				users = session.createQuery("from TSeller ").list();		
			
			}else{
				users = session.createSQLQuery(sql).addEntity(TSeller.class).list();			
			}			
		} catch (Exception e) {
			System.out.println("用户显示失败");
			e.getMessage();
		 }
		return users;
	}
			
	



}
