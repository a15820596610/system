package com.zhbit.dao;

import com.zhbit.entity.HibernateSessionFactory;
import com.zhbit.entity.TBuyer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.dao.cartDao;
import com.zhbit.dao.orderDao;
import com.zhbit.dao.sellerDao;
import com.zhbit.dao.shopDao;
import com.zhbit.entity.TBuyer;
import com.zhbit.entity.TSeller;
import com.zhbit.entity.TShop;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.dao.buyerDao;
import com.zhbit.dao.orderDao;
import com.zhbit.entity.TBuyer;
public class buyerDao {
	/**
	 * ɾ������û�
	 */
	public Boolean delete(int id){
		Session session = null;
		Transaction transaction = null;
		List<TBuyer> users = new ArrayList<TBuyer>();
		try{
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			TBuyer user = (TBuyer) session.load(TBuyer.class, id);
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
	 * �������û�
	 */
	public Boolean add(String username, String password) {
    	Timestamp ts = new Timestamp(System.currentTimeMillis());  
    	Session session = null;
		Transaction transaction = null;
		//List<TBuyer> user = new ArrayList<TBuyer>();
		
		try{
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			
			TBuyer user = new TBuyer();
			user.setUsername(username);
			user.setUserPassword(password);
			user.setTime(ts);
			System.out.println("����1");
			
			session.save(user);
			System.out.println("����2");
			transaction.commit();	
			System.out.println("����3");
		}catch(Exception e){
	
			System.out.println("add���������쳣");
			return false;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	
		return true;
	}
	
	
	
	
	/**
	 * �޸�����û���Ϣ
	 */
	public Boolean alter(int id,String username, String password){
		Session session = null;
		Transaction transaction = null;
		List<TBuyer> users = new ArrayList<TBuyer>();
		try{
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			TBuyer user = (TBuyer) session.get(TBuyer.class, id);
			user.setUsername(username);
			user.setUserPassword(password);
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
	 * ����û���Ϣ�б�
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public List query(String sql){
		List<TBuyer> users = new ArrayList<TBuyer>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			if(sql == null && sql == ""){
				users = session.createQuery("from TBuyer").list();				
			}else{
				users = session.createSQLQuery(sql).addEntity(TBuyer.class).list();				
			}	
			
		} catch (Exception e) {
			System.out.println("�û���ʾʧ��");
		}
	
		return users;
	}
	/**
	 * ���ע���û����Ƿ��Ѿ�����
	 */
	public boolean isUserNameExist(String userName){
		Session session = null;
		session = HibernateSessionFactory.getSession();
		boolean flag = true;
		String hql =  "from TBuyer as user where user.username = '"+userName+"'";
		List<TBuyer> userList = new ArrayList<TBuyer>();
		try{
			userList= session.createQuery(hql).list();
			if(userList.size() == 0){
				flag = false;
			}
			session.close();
			return flag;
		}catch (RuntimeException re) {
			throw re;
		}
	}
	/**
	 * ��ͨ�û���¼��֤
	 */
	public TBuyer checkUser(String userName,String userPassword){
		Session session = HibernateSessionFactory.getSession();
		String hql = "from TBuyer as user where user.username = '"+userName+"' and user.userPassword = '"+userPassword+"'";
		TBuyer user = null;
		try{
			List<TBuyer> userList = session.createQuery(hql).list();
			if(userList.size() > 0){
				user = new TBuyer();
				user = userList.get(0);
				System.out.println("��¼�ɹ�");
			}
		}catch(RuntimeException re){
			re.printStackTrace();
			System.out.println("��¼ʧ��");
		}
		HibernateSessionFactory.closeSession();
		return user;
	}


	
}


