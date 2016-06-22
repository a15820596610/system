package com.zhbit.action;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.dao.buyerDao;

public class RegisterAction extends ActionSupport {
	private String userName;
	private String userPassword;
	private String userRePassword;
	buyerDao buyerDao =new buyerDao();
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
	public String getUserRePassword() {
		return userRePassword;
	}
	public void setUserRePassword(String userRePassword) {
		this.userRePassword = userRePassword;
	}
	
	
		
	
	public String execute(){
		boolean flag;
		System.out.println("userName="+userName);
		System.out.println("userPassword="+userPassword);
		flag=buyerDao.add(userName, userPassword);
		if(flag){
			return SUCCESS;
		}
		return ERROR;
	}
	public void validate(){
		if(!Pattern.matches("[a-zA-Z][a-zA-Z0-9]{5,15}", userName)){
			addFieldError("userName", "用户名请使用6-16位英文字母或数字，且以字母开头！");
		}
		if(!Pattern.matches("[a-zA-Z0-9]{6,12}", userPassword)){
			addFieldError("userPassword", "密码请使用6-12位英文字母或数字！");
		}
		if(!userRePassword.equals(userPassword)){
			addFieldError("userRePassword", "两次密码不一致！");
		}
		boolean flag = true; 
		flag = buyerDao.isUserNameExist(userName);
		if(flag){
			addFieldError("userName", "用户名已经存在！");
		}
	}

}
