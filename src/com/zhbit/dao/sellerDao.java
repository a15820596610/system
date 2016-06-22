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
	 * ɾ�������û�
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
			System.out.println("delete���������쳣");
			return false;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	
		return true;
	}
	
	
	
	
	/**
	 * ��������û�
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
			System.out.println("add���������쳣");
			return false;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	
		return true;
	}
	
	
	
	
	/**
	 * �޸������û���Ϣ
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
				System.out.println("alter���������쳣");
				return false;
		}finally{
				HibernateSessionFactory.closeSession();
		}
			
		return true;
	}
	
	/**
	 * �����û���Ϣ�б�
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
			System.out.println("�û���ʾʧ��");
			e.getMessage();
		 }
		return users;
	}
			
	



}
