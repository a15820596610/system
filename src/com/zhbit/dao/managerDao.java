package com.zhbit.dao;

import com.zhbit.entity.HibernateSessionFactory;
import com.zhbit.entity.TManager;
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

public class managerDao {
//	//得到数据数目
//		public int getCount(){
//			List<TManager> users = new ArrayList<TManager>();
//
//			int num = -1;
//			Session session = null;
//		
//			try{
//				session = HibernateSessionFactory.getSession();
//							
//				//count(*) from nuser 试试�?
//				users = session.createQuery("from Nuser").list();				
//				num = users.size();
////				System.out.println("lall"+num);	
//			}catch(Exception e){
//				num = -1;
//				System.out.println("getCount()发生异常");
//			}finally{
//				HibernateSessionFactory.closeSession();
//			}
//			return num;
//		}
		
	
	
		
		/**
		 * 删除管理员用�?
		 */
		public Boolean delete(int id){
			Session session = null;
			Transaction transaction = null;
			List<TManager> users = new ArrayList<TManager>();
			try{
				session = HibernateSessionFactory.getSession();
				transaction = session.beginTransaction();
		
				TManager user = (TManager) session.load(TManager.class, id);
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
		 * 添加管理员用�?
		 */
		public Boolean add(String usename, String password) {
	    	Timestamp ts = new Timestamp(System.currentTimeMillis());  
	    	Session session = null;
			Transaction transaction = null;
			try{
				session = HibernateSessionFactory.getSession();
				transaction = session.beginTransaction();
				TManager user = new TManager();
				user.setUsername(usename);
				user.setPassword(password);
				user.setTime(ts);
				
				session.save(user);
				transaction.commit();			
			}catch(Exception e){
		
				System.out.println("add（）发生异常");
				return false;
			}finally{
				HibernateSessionFactory.closeSession();
			}
		
			return true;
		}
		
		
		
		
		/**
		 * 修改管理员用户信�?
		 */
		public Boolean alter(int id,String usename, String password){
			Session session = null;
			Transaction transaction = null;
			List<TManager> users = new ArrayList<TManager>();
			try{
				session = HibernateSessionFactory.getSession();
				transaction = session.beginTransaction();
				TManager user = (TManager) session.get(TManager.class, id);
				user.setUsername(usename);
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
		

		//����Ա��¼��֤
		@SuppressWarnings("unchecked")
		public boolean checkManager(String managerName,String managerPassword){
			Session session = HibernateSessionFactory.getSession();
			boolean flag = false;
			String hql = "from TManager as manager where manager.username = '"+managerName+"' and manager.password = '"+managerPassword+"'";
			List<TManager> managerList = session.createQuery(hql).list();
			if(managerList.size()>0){
				flag = true;
			}
			session.close();
			return flag;
		}

	
}
