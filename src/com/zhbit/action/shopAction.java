package com.zhbit.action;

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
import com.zhbit.entity.TOrder;
import com.zhbit.entity.TSeller;
import com.zhbit.entity.TShop;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.dao.buyerDao;
import com.zhbit.dao.orderDao;
import com.zhbit.entity.TBuyer;
import com.zhbit.server.OrderServer;
import com.zhbit.server.SellerServer;
import com.zhbit.server.ShopServer;

public class shopAction extends ActionSupport implements ServletResponseAware {
	private int shopAmount;
	private HttpServletResponse response; 
	private orderDao orderdao = new orderDao();	
	private cartDao cartdao = new cartDao();
	private String express;
	private SellerServer sellerServer = new SellerServer();
	private ShopServer shopServer = new ShopServer();
    
	private OrderServer orderServer = new OrderServer();

	private List list;
	
	
	public String execute() throws Exception{
		return null;
	}
	
	/*public void showAllShop(){
		ActionContext context = ActionContext.getContext();  
		HttpServletRequest request = ServletActionContext.getRequest();  
		HttpServletResponse response = ServletActionContext.getResponse(); 
		
		shopDao shopdao = new shopDao();
		List list = shopdao.query("select *from t_shop where isShow='已上架'"); 
		request.setAttribute("list", list);
		try {
			request.getRequestDispatcher("index.jsp").forward(request,response);
			System.out.println("跳转到login.jsp页面");
		} catch (ServletException e) {
			System.out.println("ServletException e报错");
		} catch (IOException e) {
			System.out.println("IOException e报错");
			e.printStackTrace();
		}
		
	}*/
	
	public void shopDeal() throws IOException{
		System.out.println("--------------");
		System.out.println("跳转到shopAction的shopDeal()");
		
		ActionContext context = ActionContext.getContext();  
		HttpServletRequest request = ServletActionContext.getRequest();  
		
		
		String sellerID = request.getParameter("sellerID");
		String shopID = request.getParameter("shopID");
		String flag= request.getParameter("flag");
		TBuyer buyer = (TBuyer) context.getSession().get("buyer");
		
		System.out.println("sellerID="+sellerID);
		System.out.println("shopID="+shopID);
		if(sellerID == null || shopID == null){
			
			System.out.println("index.jsp跳转到shopAction出现错误 ,原因 传值失败");
			System.out.println("---------------------");
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
			TSeller seller = sellerServer.getSingleSeller("select *from t_seller where sellerID="+sellerID);		
			TShop shop = shopServer.getSingleShop("select *from t_shop where shopID="+shopID);
			
			request.setAttribute("seller", seller);
			request.setAttribute("shop", shop);
			
			if(flag!=null){
				if( flag.equals("0") ){
					System.out.println("buyerId="+buyer.getBuyerId());
					System.out.println("shopAmount="+shopAmount);
					System.out.println("express="+express);
					if( cartdao.add(shop, seller, buyer,  shopAmount, express ) ){
						System.out.println("添加到购物车成功");
						/*	  设置对话框*/
						response.setContentType("text/html;charset=UTF-8");
						response.setCharacterEncoding("UTF-8");        	
						PrintWriter out= response.getWriter();
						out.print("<script>alert('添加购物车成功')</script>");
						out.print("<script>window.location.href='shop!shopDeal.action?shopID="+shopID+"&sellerID="+sellerID+"'</script>"); 
						out.flush(); 
						out.close();
					}
				}
			}else{
				try {
					request.getRequestDispatcher("shop.jsp").forward(request,response);
					System.out.println("跳转到shop.jsp页面");
				} catch (ServletException e) {
					System.out.println("ServletException e报错");
				} catch (IOException e) {
					System.out.println("IOException e报错");
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("shopAction的执行到达最后");
		System.out.println("----------------------");
		
		
	}
	
	public void payDeal()  throws IOException{
		System.out.println("--------------");
		System.out.println("跳转到shopAction的payDeal()");
		
		
		ActionContext context = ActionContext.getContext();  
		HttpServletRequest request = ServletActionContext.getRequest();  
		
		TBuyer buyer = (TBuyer) context.getSession().get("buyer");
		
		String shopAmount1 = request.getParameter("shopAmount");
		String sellerID = request.getParameter("sellerID");
		String shopID = request.getParameter("shopID");
		
		System.out.println("sellerID="+sellerID);
		System.out.println("shopID="+shopID);
		System.out.println("shopAmount1="+shopAmount1);
		
		TSeller seller = sellerServer.getSingleSeller("select *from t_seller where sellerID="+sellerID);		
		TShop shop = shopServer.getSingleShop("select *from t_shop where shopID="+shopID);
		
		
		if(buyer == null ||sellerID == null || shopID == null){
			
			System.out.println("index.jsp跳转到shopAction出现错误 ,原因 传值失败");
			System.out.println("---------------------");
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
			
			if( orderdao.add(buyer, seller, shop, Integer.parseInt(shopAmount1), shopID) ){
				System.out.println("订单生成成功");
				
				TOrder maxOrder = orderServer.getSingleOrder("select * from t_order where orderID=(select max(orderID) from t_order)");
				
				int orderID = maxOrder.getOrderId();
				System.out.println("maxOrderId="+orderID);
				/*	  设置对话框*/
				response.setContentType("text/html;charset=UTF-8");
				response.setCharacterEncoding("UTF-8");        	
				PrintWriter out= response.getWriter();
				System.out.println("<script>if( confirm('订单生成成功,接下请问确认付款吗,金额一共为"+shop.getShopPrice()*Integer.parseInt(shopAmount1)+"元') ){"
						+ "window.location.href='order!orderPay.action?orderID="+orderID+"';}"
						+ "else{window.location.href='order!allOrder.action';}</script>");
				out.println("<script>if( confirm('订单生成成功,接下请问确认付款吗,金额一共为"+shop.getShopPrice()*Integer.parseInt(shopAmount1)+"元') ){"
						+ "window.location.href='order!orderPay.action?orderID="+orderID+"';}"
						+ "else{window.location.href='order!allOrder.action';}</script>");
				
			
				out.flush(); 
				out.close();
			}
		}
	}
	
	public HttpServletResponse getResponse() {
		return response;
	}



	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}


	public int getShopAmount() {
		return shopAmount;
	}



	public void setShopAmount(int shopAmount) {
		this.shopAmount = shopAmount;
	}



	



	public String getExpress() {
		return express;
	}



	public void setExpress(String express) {
		this.express = express;
	}



	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
		
	}




	


}
