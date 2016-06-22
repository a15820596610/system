package com.zhbit.test;
import com.zhbit.dao.buyerDao;
import com.zhbit.dao.managerDao;
import com.zhbit.entity.TBuyer;

public class daoTest {
	
	public static void main(String[] args){
		int i;
		buyerDao buyerDao=new buyerDao();
		TBuyer user = new TBuyer();
		boolean flag;
		managerDao managerDao=new managerDao();
		//user.setUsername("qwef");
		//user.setUserPassword("chusheng");
		user=buyerDao.checkUser("q123456", "123456");
		/*
		flag=managerDao.checkManager("admin", "admin");
		
		//boolean flag=false,a=false;
		//flag=buyerDao.add("thisistest", "password");
		if(flag){
			System.out.println("登录成功");
		}else{
			System.out.println("失败");
		}
		/*
		a=buyerDao.isUserNameExist("123456");
		if(a){
			System.out.println("调用判断方法");
		}else{
			System.out.println("调用判断方法失败");
		}
		
		a=buyerDao.delete(6);
		if(a){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}*/
	}

}
