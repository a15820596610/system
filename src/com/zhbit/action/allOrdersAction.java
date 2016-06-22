package com.zhbit.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.dao.orderDao;
import com.zhbit.entity.TOrder;

public class allOrdersAction extends ActionSupport {
	orderDao orderDao =new orderDao();
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<TOrder> allOrders = new ArrayList<TOrder>();
		String pageNumberString = request.getParameter("pageNumber");
		if(pageNumberString == null || "".equals(pageNumberString.trim())){
			pageNumberString = "1";
		}
		int pageNumber = Integer.parseInt(pageNumberString);
		pageNumber = 1;
		int pageSize = 20;
		String searchType = request.getParameter("searchType");
		if(searchType == null || "".equals(searchType.trim())){
			searchType = "all";
		}
		if("all".equals(searchType)){
			allOrders = orderDao.allOrders(pageNumber, pageSize);
		}
		if("isDeal".equals(searchType)){
			allOrders = orderDao.allOrdersByDeal("1", pageNumber, pageSize);
		}
		if("isNotDeal".equals(searchType)){
			allOrders = orderDao.allOrdersByDeal("0", pageNumber, pageSize);
		}
		int sequence = (pageNumber-1)*pageSize;
		request.setAttribute("allOrders", allOrders);
		request.setAttribute("sequence", sequence);
		return null;
	}

}
