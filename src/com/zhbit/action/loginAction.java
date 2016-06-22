package com.zhbit.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.dao.buyerDao;
import com.zhbit.dao.managerDao;
import com.zhbit.entity.TBuyer;
import com.zhbit.entity.TManager;

public class loginAction extends ActionSupport {
	private String userName;
	private String userPassword;
	buyerDao buyerDao=new buyerDao();
	managerDao managerDao=new managerDao();
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	//普通用户登录
	public String loginCheck(){
		String page = "fail";
		TBuyer user = new TBuyer();
		user = buyerDao.checkUser(userName, userPassword);
		if(user != null){
			page = "success";
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			if(session.getAttribute("loginUser") != null){
				session.removeAttribute("loginUser");
			}
			session.setAttribute("loginUser", user);
		}
		return page;
	}
	
	//管理员登录
	public String managerLoginCheck(){
		String page = "fail";
		TManager user = new TManager();
//		user = buyerDao.checkUser(page, page)
		if(user != null){
			page = "success";
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			if(session.getAttribute("loginUser") != null){
				session.removeAttribute("loginUser");
			}
			session.setAttribute("loginUser", user);
		}
		return page;
	}		
	public void validate(){
		TBuyer user = new TBuyer();
		user = buyerDao.checkUser(userName, userPassword);
		if(user == null){
			addFieldError("userName", "用户名密码错误！");
		}
	}
	

}
