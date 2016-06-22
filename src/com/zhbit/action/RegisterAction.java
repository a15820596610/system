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
			addFieldError("userName", "�û�����ʹ��6-16λӢ����ĸ�����֣�������ĸ��ͷ��");
		}
		if(!Pattern.matches("[a-zA-Z0-9]{6,12}", userPassword)){
			addFieldError("userPassword", "������ʹ��6-12λӢ����ĸ�����֣�");
		}
		if(!userRePassword.equals(userPassword)){
			addFieldError("userRePassword", "�������벻һ�£�");
		}
		boolean flag = true; 
		flag = buyerDao.isUserNameExist(userName);
		if(flag){
			addFieldError("userName", "�û����Ѿ����ڣ�");
		}
	}

}
