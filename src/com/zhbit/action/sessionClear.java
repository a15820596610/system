package com.zhbit.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class sessionClear extends ActionSupport {
	
	public String execute() throws Exception{
		
		System.out.println("----------------");
		System.out.println("����session���");
		ActionContext context = ActionContext.getContext();
		context.getSession().clear();
		
		System.out.println("session������");
		System.out.println("----------------");
		return "login";
	}
}
