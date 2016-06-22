package com.zhbit.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.dao.buyerDao;
import com.zhbit.dao.orderDao;
import com.zhbit.entity.TBuyer;
import com.zhbit.entity.TOrder;
import com.zhbit.entity.TSeller;
import com.zhbit.entity.TShopCart;
import com.zhbit.server.BuyerServer;

public class orderAction extends ActionSupport implements ServletResponseAware{
	private orderDao orderdao = new orderDao();	
	private HttpServletResponse response;
	private BuyerServer buyerServer = new BuyerServer();
	
	
	private List list;
	
	
	public String execute() throws Exception{
		return null;
	}
	
	
	
	public void commonDeal(String source, String flag){
		System.out.println("--------------");
		System.out.println("跳转到orderAciton的"+source);
		
		ActionContext context = ActionContext.getContext();  
		HttpServletRequest request = ServletActionContext.getRequest();  
		HttpServletResponse response = ServletActionContext.getResponse(); 
		
		TBuyer buyer = buyerServer.getSingleBuyer("select *from t_buyer where buyerID=1");
		/*TBuyer buyer = (TBuyer) context.getSession().get("buyer");*/
		TSeller seller = (TSeller) context.getSession().get("sellers");
		
		
		if(buyer == null && seller == null){
			System.out.println("当前没有用户登录");
			try {
				request.getRequestDispatcher("clear!sessionClear.action").forward(request,response);
				System.out.println("跳转到login.jsp页面");
			} catch (ServletException e) {
				System.out.println("ServletException e报错");
			} catch (IOException e) {
				System.out.println("IOException e报错");
				e.printStackTrace();
			}
			
		}else{
			/*
				后续需要修改
			*/
			System.out.println("else语句");
			if(buyer!=null){
				System.out.println("当前买家编号为"+buyer.getBuyerId()+"登录");
				list = orderdao.query("select *from t_order where buyerID="+buyer.getBuyerId()+flag+"order by orderTime desc");
				
			}
			if(seller!=null){
				System.out.println("当前卖家编号为"+seller.getSellerId()+"登录");
				list = orderdao.query("select *from t_order where sellerID="+seller.getSellerId()+flag+"order by orderTime desc");
			}
			request.setAttribute("list", list);
			try {
				request.getRequestDispatcher("orderMessage.jsp").forward(request,response);
				System.out.println("跳转到orderMessage.jsp页面");
			} catch (ServletException e) {
				System.out.println("ServletException e报错");
			} catch (IOException e) {
				System.out.println("IOException e报错");
				e.printStackTrace();
			}
			
		}
		

		System.out.println("orderAction的 "+source+"执行到达最后");
		System.out.println("----------------------");
	}
	
	//罗列所有订单
	public void allOrder(){
		commonDeal("allOrder()", "");		
	}
	
	
	//罗列 <未付款> 订单
	public void orderStatus_false(){
		commonDeal("orderStatus_false()", "and orderStatus='未付款'");
	}	
	

	//罗列 <已付款> 订单
	public void orderStatus_true(){
		commonDeal("orderStatus_true()", "and orderStatus='已付款'");		
	}
	
	//罗列 <交易完成> 订单
	public void isFinish_false(){
		commonDeal("isFinish_false()", "and isFinish='进行中'");		
	}
	
	//罗列 <交易完成> 订单
	public void isFinish_true(){
		commonDeal("isFinish_true()", "and isFinish='已完成'");		
	}
	
	public void orderPay() throws IOException{
		System.out.println("--------------");
		System.out.println("跳转到orderAction的orderPay()");
		
		ActionContext context = ActionContext.getContext();  
		HttpServletRequest request = ServletActionContext.getRequest();  
		HttpServletResponse response = ServletActionContext.getResponse(); 
		TBuyer buyer = (TBuyer) context.getSession().get("buyer");
		
		String orderID = request.getParameter("orderID");
		
		if( orderdao.alterStatus(Integer.parseInt(orderID), "已付款") ){
			System.out.println("付款成功");
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");        	
			PrintWriter out= response.getWriter();
			out.print("<script>alert('"+orderID+"付款成功')</script>");
			out.print("<script>window.location.href='order!allOrder.action'</script>"); 
			out.flush(); 
			out.close();
		}
	}		
	public void cartSettlementPay() throws IOException{
		System.out.println("--------------");
		System.out.println("跳转到orderAction的orderPay()");
		
		ActionContext context = ActionContext.getContext();  
		HttpServletRequest request = ServletActionContext.getRequest();  
		HttpServletResponse response = ServletActionContext.getResponse(); 
		TBuyer buyer = (TBuyer) context.getSession().get("buyer");
		
		int flag=0;
		
		String order_id = request.getParameter("order_id");
		System.out.println("order_id"+order_id);
		StringTokenizer st = new StringTokenizer(order_id,",");
		while(st.hasMoreTokens() ){
			String a = st.nextToken();
			
			int id = Integer.parseInt(a);
			System.out.println("id="+id);
			if( orderdao.alterStatus( id , "已付款")==false ){
				flag=1;
			}
			
		}
		
		if(flag == 1){
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");        	
			PrintWriter out= response.getWriter();
			out.print("<script>alert('结算失败，将返回订单页面')</script>");
			out.print("<script>window.location.href='order!allOrder.action'</script>"); 
			out.flush(); 
			out.close();
		}else{
			System.out.println("付款成功");
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");        	
			PrintWriter out= response.getWriter();
			out.print("<script>alert('多个商品付款成功')</script>");
			out.print("<script>window.location.href='order!allOrder.action'</script>"); 
			out.flush(); 
			out.close();
			
		}
		
		
		
	}	
	
	public void orderConfirmGoods() throws IOException{
		System.out.println("--------------");
		System.out.println("跳转到orderAction的orderConfirmGoods()");
		
		ActionContext context = ActionContext.getContext();  
		HttpServletRequest request = ServletActionContext.getRequest();  
		HttpServletResponse response = ServletActionContext.getResponse(); 
		TBuyer buyer = (TBuyer) context.getSession().get("buyer");
		
		String orderID = request.getParameter("orderID");
		System.out.println("orderID="+orderID);
		if( orderdao.alterFinish(Integer.parseInt(orderID), "已完成") ){
			System.out.println("确认收货成功");
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");        	
			PrintWriter out= response.getWriter();
			out.print("<script>alert('"+orderID+"确认收货成功')</script>");
			out.print("<script>window.location.href='order!allOrder.action'</script>"); 
			out.flush(); 
			out.close();
		}
	}	

	public void deleteSingleOrder()  throws IOException{
		System.out.println("--------------");
		System.out.println("跳转到orderAction的deleteSingleOrder()");
		
		ActionContext context = ActionContext.getContext();  
		HttpServletRequest request = ServletActionContext.getRequest();  
		HttpServletResponse response = ServletActionContext.getResponse(); 
	
		
		String orderID = request.getParameter("orderID");
		System.out.println("orderID="+orderID);
		if( orderdao.delete(  Integer.parseInt(orderID))  ){
			System.out.println("删除订单为"+orderID+"成功");
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");        	
			PrintWriter out= response.getWriter();
			out.print("<script>alert('删除订单为"+orderID+"成功')</script>");
			out.print("<script>window.location.href='order!allOrder.action'</script>"); 
			out.flush(); 
			out.close();
		}
	}
	
	public void searchContent() throws IOException{
		System.out.println("--------------");
		System.out.println("跳转到orderAction的searchContent()");
		
		ActionContext context = ActionContext.getContext();  
		HttpServletRequest request = ServletActionContext.getRequest();  
		HttpServletResponse response = ServletActionContext.getResponse(); 
		
		request.setCharacterEncoding("iso8859-1");
		response.setContentType("text/jsp;charset=iso8859-1");
		
		String search = request.getParameter("search");
		System.out.println("search="+search);
		commonDeal("searchContent()", 
				"and orderID="+search
					+ "or shopID=any(select shopID from t_shop where shopPrice="+search+" ) "
					
					);
		
	}
	
	
	
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}



	public HttpServletResponse getResponse() {
		return response;
	}



	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	
}
