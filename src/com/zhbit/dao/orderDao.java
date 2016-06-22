package com.zhbit.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zhbit.entity.HibernateSessionFactory;
import com.zhbit.entity.TBuyer;
import com.zhbit.entity.TOrder;
import com.zhbit.entity.TSeller;
import com.zhbit.entity.TShop;
import com.zhbit.entity.TShopCart;

public class orderDao {
	/**
	 * ɾ������
	 */
	public Boolean delete(int id){
		Session session = null;
		Transaction transaction = null;
		List users = new ArrayList();
		try{
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
	
			TOrder user = (TOrder) session.load(TOrder.class, id);
			session.delete(user);			
			transaction.commit();			
		}catch(Exception e){
			System.out.println("TOrder delete���������쳣");
			return false;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	
		return true;
	}
	
	
	
	
	/**
	 * ��Ӷ�����Ϣ
	 */
	public Boolean add(TBuyer buyer, TSeller seller, TShop shop, int shopAmount, String express) {
    	Timestamp orderTime = new Timestamp(System.currentTimeMillis());  
    	
    	Session session = null;
		Transaction transaction = null;
		try{
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			
			TOrder user = new TOrder();
			//����״̬Ϊʲô��Ҫ���룿
			user.setOrderStatus("δ����");
			user.setIsFinish("������");
			user.setTBuyer(buyer);
			user.setTSeller(seller);
			user.setTShop(shop);
			user.setExpress(express);
			user.setOrderTime(orderTime);
		    user.setShopAmount(shopAmount);
			
			
			session.save(user);
			
			transaction.commit();			
		}catch(Exception e){
	
			System.out.println("orderDao  add���������쳣");
			e.printStackTrace();
			return false;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	
		return true;
	}
	
	
	
	
	/**
	 * �޸Ķ���״̬    1���Ѹ���   2��δ����
	 */
	
	public Boolean alterStatus(int id, String orderStatus){
		Session session = null;
		Transaction transaction = null;
		List<TOrder> users = new ArrayList<TOrder>();
		try{
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			
			TOrder user = (TOrder) session.get(TOrder.class, id);
			user.setOrderStatus(orderStatus);
			
			transaction.commit();			
		}catch(Exception e){
				System.out.println("TOrder alterStatus���������쳣");
				return false;
		}finally{
				HibernateSessionFactory.closeSession();
		}
			
		return true;
	}
	
	/**
	 * �޸Ķ�����������----���ȷ���ջ��������յ�Ǯ
	 */
	public Boolean alterFinish(int id, String isFinish){
		Session session = null;
		Transaction transaction = null;
		List<TOrder> users = new ArrayList<TOrder>();
		try{
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			
			TOrder user = (TOrder) session.get(TOrder.class, id);
			user.setIsFinish(isFinish);
			
			transaction.commit();			
		}catch(Exception e){
				System.out.println("TOrder alterFinish���������쳣");
				return false;
		}finally{
				HibernateSessionFactory.closeSession();
		}
			
		return true;
	}
	
	/**
	 *  ������ѯ
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public List query(String sql){
		List<TOrder> users = new ArrayList();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();	
			if(sql==""){
				System.out.println("����orderDao ���еĲ�ѯ");
				users = session.createQuery("from TOrder ").list();				
			}else{
				System.out.println("����orderDaoѡ��sql���Ĳ�ѯ");
				users = session.createSQLQuery(sql).addEntity(TOrder. class).list();
			}
			System.out.println("����orderDao�Ĳ�ѯ���");
		} catch (Exception e) {
			System.out.println("TOrder query����ʧ��");
		}
		return users;
	}
	//��ѯ���ж�������ҳ��ʾ
		@SuppressWarnings("unchecked")
		public List<TOrder> allOrders(final int pageNumber,final int pageSize){
			Session session = HibernateSessionFactory.getSession();
			String hql = "from TOrder as orders order by ordersTime desc";
			List<TOrder> allOrders = null;
			try {
				Query query = session.createQuery(hql);
				query.setFirstResult((pageNumber-1)*pageSize);
				query.setMaxResults(pageSize);
				allOrders = query.list();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.close();
			return allOrders;
		}
		//��ѯ���ж���
		@SuppressWarnings("unchecked")
		public List<TOrder> allOrdersByDeal(final String isFinish,final int pageNumber,final int pageSize){
			Session session =HibernateSessionFactory.getSession();
			String hql = "from TOrder as orders where orders.isFinish = '"+isFinish+"' order by ordersTime desc";
			Query query = session.createQuery(hql);
			query.setFirstResult((pageNumber-1)*pageSize);
			query.setMaxResults(pageSize);
			List<TOrder> list = query.list();
			session.close();
			return list;
		}
		
		

}
