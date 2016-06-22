package com.zhbit.dao;
import com.zhbit.entity.HibernateSessionFactory;
import com.zhbit.entity.TShop;
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

public class shopDao {
		/**
		 * ɾ����Ʒ
		 */
		public Boolean delete(int id){
			Session session = null;
			Transaction transaction = null;
			List<TShop> users = new ArrayList<TShop>();
			try{
				session = HibernateSessionFactory.getSession();
				transaction = session.beginTransaction();
		
				TShop user = (TShop) session.load(TShop.class, id);
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
		 * �����Ʒ 
		 */
		public Boolean add(double shopPrice, String shopName, Integer shopInventory, 
				String shopPhoto, String shopIntroduce, String isShow) {

	    	Session session = null;
			Transaction transaction = null;
			try{
				session = HibernateSessionFactory.getSession();
				transaction = session.beginTransaction();
				
				TShop user = new TShop();
				
				user.setIsShow(isShow);
				user.setShopPrice(shopPrice);
				user.setShopIntroduce(shopIntroduce);
				user.setShopInventory(shopInventory);
				user.setShopName(shopName);
				user.setShopPhoto(shopPhoto);
	
				
				session.save(user);
				transaction.commit();			
			}catch(Exception e){
		
				System.out.println("add���������쳣");
				return false;
			}finally{
				HibernateSessionFactory.closeSession();
			}
		
			return true;
		}
		
		
		
		
		/**
		 * �޸���Ʒ�۸���Ϣ
		 */
		public Boolean alterPrice(int id,double shopPrice){
			Session session = null;
			Transaction transaction = null;
			List<TShop> users = new ArrayList<TShop>();
			try{
				session = HibernateSessionFactory.getSession();
				transaction = session.beginTransaction();
				TShop user = (TShop) session.get(TShop.class, id);
				user.setShopPrice(shopPrice);			
				transaction.commit();			
			}catch(Exception e){
					System.out.println("alter �����쳣");
					return false;
			}finally{
					HibernateSessionFactory.closeSession();
			}
				
			return true;
		}
		
		
		/**
		 * �޸���Ʒ�����Ϣ
		 */
		public Boolean alterInventory(int id, Integer shopInventory){
			Session session = null;
			Transaction transaction = null;
			List<TShop> users = new ArrayList<TShop>();
			try{
				session = HibernateSessionFactory.getSession();
				transaction = session.beginTransaction();
				TShop user = (TShop) session.get(TShop.class, id);
				user.setShopInventory(shopInventory);			
				transaction.commit();			
			}catch(Exception e){
					System.out.println("alter �����쳣");
					return false;
			}finally{
					HibernateSessionFactory.closeSession();
			}
				
			return true;
		}
		
		
		/**
		 * �޸���Ʒ��Ƭ��Ϣ
		 */
		public Boolean alterPhoto(int id, String shopPhoto){
			Session session = null;
			Transaction transaction = null;
			List<TShop> users = new ArrayList<TShop>();
			try{
				session = HibernateSessionFactory.getSession();
				transaction = session.beginTransaction();
				TShop user = (TShop) session.get(TShop.class, id);
				user.setShopPhoto(shopPhoto);			
				transaction.commit();			
			}catch(Exception e){
					System.out.println("alter �����쳣");
					return false;
			}finally{
					HibernateSessionFactory.closeSession();
			}
				
			return true;
		}
		
		public Boolean alterIntroduce(int id, String shopIntroduce){
			Session session = null;
			Transaction transaction = null;
			List<TShop> users = new ArrayList<TShop>();
			try{
				session = HibernateSessionFactory.getSession();
				transaction = session.beginTransaction();
				TShop user = (TShop) session.get(TShop.class, id);
				int id1 = user.getShopId();
				user.setShopIntroduce(shopIntroduce);			
				transaction.commit();			
			}catch(Exception e){
					System.out.println("alter �����쳣");
					return false;
			}finally{
					HibernateSessionFactory.closeSession();
			}
				
			return true;
		}
		
		
		/**
		 * �޸���Ʒ�ϼ���Ϣ
		 */
		public Boolean alterShow(int id, String isShow){
			Session session = null;
			Transaction transaction = null;
			List<TShop> users = new ArrayList<TShop>();
			try{
				session = HibernateSessionFactory.getSession();
				transaction = session.beginTransaction();
				TShop user = (TShop) session.get(TShop.class, id);
				user.setIsShow(isShow);			
				transaction.commit();			
			}catch(Exception e){
					System.out.println("alter �����쳣");
					return false;
			}finally{
					HibernateSessionFactory.closeSession();
			}
				
			return true;
		}
		
		
		
		/**
		 * ��Ʒ��Ϣ�б�
		 */
		
		public List query(String sql){
			List<TShop> users = new ArrayList<TShop>();
			Session session = null;
			try {
				session = HibernateSessionFactory.getSession();
				if(sql == null || sql == ""){
					users = session.createQuery("from TShop ").list();				
				}else{
					users = session.createSQLQuery(sql).addEntity(TShop.class).list();					
				}	
			} catch (Exception e) {
				System.out.println("��Ʒ��ѯ��Ϣʧ��");
			}
			return users;
		}
				
		



	

}
