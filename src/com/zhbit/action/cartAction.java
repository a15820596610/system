package com.zhbit.action;

import com.zhbit.dao.cartDao;
import com.zhbit.dao.orderDao;
import com.zhbit.entity.TBuyer;
import com.zhbit.entity.TShopCart;

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
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

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
public class cartAction extends ActionSupport  implements ServletResponseAware{
	private ActionContext context;  
	private orderDao orderdao = new orderDao();
	private cartDao cartdao = new cartDao();
	private OrderServer orderServer = new OrderServer();
	private HttpServletResponse response;
	
	
	public String execute() throws Exception{
		return null;
	}

	public void showAllCart(){
		System.out.println("--------------");
		System.out.println("��ת��cartAction��  showAllCart() ");
		ActionContext context = ActionContext.getContext();  
		HttpServletRequest request = ServletActionContext.getRequest();  
		System.out.println("����");
		TBuyer buyer = (TBuyer) context.getSession().get("buyer");

		System.out.println("buyerID= "+buyer.getBuyerId());
		if(buyer == null){
			System.out.println("��ǰû���û���¼");
			System.out.println("---------------------");
			try {
				request.getRequestDispatcher("clear.action").forward(request,response);
				System.out.println("��ת��login.jspҳ��");
			} catch (ServletException e) {
				System.out.println("ServletException e����");
			} catch (IOException e) {
				System.out.println("IOException e����");
				e.printStackTrace();
			}
		}else{
			List list = (List) cartdao.query("select *from t_shopCart where buyerID="+buyer.getBuyerId()+
					" order by cartTime desc");
			request.setAttribute("list", list);
			try {
				request.getRequestDispatcher("cart.jsp").forward(request,response);
			} catch (ServletException e) {
				System.out.println("ServletException e����");
			} catch (IOException e) {
				System.out.println("IOException e����");
				e.printStackTrace();
			}
		}





	}


	//ɾ������cart 
	public void deleteSingleCart() throws IOException{
		System.out.println("cartAction ����deleteCart()");
		ActionContext context = ActionContext.getContext();  
		HttpServletRequest request = ServletActionContext.getRequest();  
		HttpServletResponse response = ServletActionContext.getResponse(); 

		/*String cartID1 = request.getParameter("cartID");
		int cartID = Integer.parseInt(cartID1);*/

		int cartID = Integer.parseInt( request.getParameter("cartID") );

		System.out.println("cartID="+cartID);
		if(cartdao.delete(cartID)){
			System.out.println("ɾ��IDΪ"+cartID+"�Ĺ��ﳵ�ɹ�");

			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");        	
			PrintWriter out= response.getWriter();
			out.print("<script>alert('ɾ���Ĺ��ﳵ�ɹ�')</script>");
			out.print("<script>window.location.href='cart!showAllCart.action'</script>"); 
			out.flush(); 
			out.close();

		}
	}

	//ɾ�����cart
	public void deleteManyCart() throws IOException{
		System.out.println("cartAction ����deleteCart()");
		ActionContext context = ActionContext.getContext();  
		HttpServletRequest request = ServletActionContext.getRequest();  
		HttpServletResponse response = ServletActionContext.getResponse(); 

		//��ȡ����������     ��ʽ:  on,X,X,X,on
		String cartID = request.getParameter("cartID");
		System.out.println("cartID="+cartID);

		String hint="ɾ��";
		//�Ը�ʽ:on,X,X,X,on���н�ȡ
		StringTokenizer st = new StringTokenizer(cartID,",");
		while(st.hasMoreTokens() ){
			String a = st.nextToken();
			if( !a.equalsIgnoreCase("on") ){
				int id = Integer.parseInt(a);
				if(cartdao.delete(id)){
					hint = hint+id+"��";
				}
			}

		}
		if( !hint.equalsIgnoreCase("ɾ��")){
			hint = hint+"�ɹ�";
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");        	
			PrintWriter out= response.getWriter();
			out.print("<script>alert("+hint+")</script>");
			out.print("<script>window.location.href='cart!showAllCart.action'</script>"); 
			out.flush(); 
			out.close();
		}



	}

	//���ﳵ����settlement
	public void settlement() throws IOException{
		System.out.println("cartAction ����settlement()");
		ActionContext context = ActionContext.getContext();  
		HttpServletRequest request = ServletActionContext.getRequest();  
		HttpServletResponse response = ServletActionContext.getResponse(); 

		//��ȡ����������     ��ʽ:  on,X,X,X,on
		String cartID = request.getParameter("cartID");
		System.out.println("cartID="+cartID);


		//�Ը�ʽ:on,X,X,X,on���н�ȡ
		StringTokenizer st = new StringTokenizer(cartID,",");
		String order_id = "";
		while(st.hasMoreTokens() ){
			String a = st.nextToken();
			if( !a.equalsIgnoreCase("on") ){
				int id = Integer.parseInt(a);
				System.out.println("id="+id);
				
				List list = cartdao.query("select *from t_shopCart where cartID="+id);
				TShopCart cart = (TShopCart) list.get(0);



				if(orderdao.add(cart.getTBuyer(), cart.getTSeller(), cart.getTShop(), cart.getShopAmount()
						, cart.getExpress())  ){
					System.out.println("�������ɳɹ�");
					if(  cartdao.delete(cart.getCartId())   ){
						System.out.println("�������ɣ����ﳵidɾ���ɹ�");
						
					}
					
					TOrder maxOrder = orderServer.getSingleOrder("select * from t_order where orderID=(select max(orderID) from t_order)");
					System.out.println("order_id="+maxOrder.getOrderId());
					order_id = order_id+","+maxOrder.getOrderId();
					
				}
			}
			/*i++;*/
		}
		System.out.println("order_id="+order_id);
		
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");        	
		PrintWriter out= response.getWriter();
		out.println("<script>if( confirm('�������ɳɹ�,��������ȷ�ϸ�����') ){"
				+ "window.location.href='order!cartSettlementPay.action?order_id="+order_id+"';}"
				+ "else{window.location.href='order!allOrder.action';}</script>");
		
	
		out.flush(); 
		out.close();
		
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;

	}
}
