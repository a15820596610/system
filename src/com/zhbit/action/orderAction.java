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
		System.out.println("��ת��orderAciton��"+source);
		
		ActionContext context = ActionContext.getContext();  
		HttpServletRequest request = ServletActionContext.getRequest();  
		HttpServletResponse response = ServletActionContext.getResponse(); 
		
		TBuyer buyer = buyerServer.getSingleBuyer("select *from t_buyer where buyerID=1");
		/*TBuyer buyer = (TBuyer) context.getSession().get("buyer");*/
		TSeller seller = (TSeller) context.getSession().get("sellers");
		
		
		if(buyer == null && seller == null){
			System.out.println("��ǰû���û���¼");
			try {
				request.getRequestDispatcher("clear!sessionClear.action").forward(request,response);
				System.out.println("��ת��login.jspҳ��");
			} catch (ServletException e) {
				System.out.println("ServletException e����");
			} catch (IOException e) {
				System.out.println("IOException e����");
				e.printStackTrace();
			}
			
		}else{
			/*
				������Ҫ�޸�
			*/
			System.out.println("else���");
			if(buyer!=null){
				System.out.println("��ǰ��ұ��Ϊ"+buyer.getBuyerId()+"��¼");
				list = orderdao.query("select *from t_order where buyerID="+buyer.getBuyerId()+flag+"order by orderTime desc");
				
			}
			if(seller!=null){
				System.out.println("��ǰ���ұ��Ϊ"+seller.getSellerId()+"��¼");
				list = orderdao.query("select *from t_order where sellerID="+seller.getSellerId()+flag+"order by orderTime desc");
			}
			request.setAttribute("list", list);
			try {
				request.getRequestDispatcher("orderMessage.jsp").forward(request,response);
				System.out.println("��ת��orderMessage.jspҳ��");
			} catch (ServletException e) {
				System.out.println("ServletException e����");
			} catch (IOException e) {
				System.out.println("IOException e����");
				e.printStackTrace();
			}
			
		}
		

		System.out.println("orderAction�� "+source+"ִ�е������");
		System.out.println("----------------------");
	}
	
	//�������ж���
	public void allOrder(){
		commonDeal("allOrder()", "");		
	}
	
	
	//���� <δ����> ����
	public void orderStatus_false(){
		commonDeal("orderStatus_false()", "and orderStatus='δ����'");
	}	
	

	//���� <�Ѹ���> ����
	public void orderStatus_true(){
		commonDeal("orderStatus_true()", "and orderStatus='�Ѹ���'");		
	}
	
	//���� <�������> ����
	public void isFinish_false(){
		commonDeal("isFinish_false()", "and isFinish='������'");		
	}
	
	//���� <�������> ����
	public void isFinish_true(){
		commonDeal("isFinish_true()", "and isFinish='�����'");		
	}
	
	public void orderPay() throws IOException{
		System.out.println("--------------");
		System.out.println("��ת��orderAction��orderPay()");
		
		ActionContext context = ActionContext.getContext();  
		HttpServletRequest request = ServletActionContext.getRequest();  
		HttpServletResponse response = ServletActionContext.getResponse(); 
		TBuyer buyer = (TBuyer) context.getSession().get("buyer");
		
		String orderID = request.getParameter("orderID");
		
		if( orderdao.alterStatus(Integer.parseInt(orderID), "�Ѹ���") ){
			System.out.println("����ɹ�");
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");        	
			PrintWriter out= response.getWriter();
			out.print("<script>alert('"+orderID+"����ɹ�')</script>");
			out.print("<script>window.location.href='order!allOrder.action'</script>"); 
			out.flush(); 
			out.close();
		}
	}		
	public void cartSettlementPay() throws IOException{
		System.out.println("--------------");
		System.out.println("��ת��orderAction��orderPay()");
		
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
			if( orderdao.alterStatus( id , "�Ѹ���")==false ){
				flag=1;
			}
			
		}
		
		if(flag == 1){
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");        	
			PrintWriter out= response.getWriter();
			out.print("<script>alert('����ʧ�ܣ������ض���ҳ��')</script>");
			out.print("<script>window.location.href='order!allOrder.action'</script>"); 
			out.flush(); 
			out.close();
		}else{
			System.out.println("����ɹ�");
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");        	
			PrintWriter out= response.getWriter();
			out.print("<script>alert('�����Ʒ����ɹ�')</script>");
			out.print("<script>window.location.href='order!allOrder.action'</script>"); 
			out.flush(); 
			out.close();
			
		}
		
		
		
	}	
	
	public void orderConfirmGoods() throws IOException{
		System.out.println("--------------");
		System.out.println("��ת��orderAction��orderConfirmGoods()");
		
		ActionContext context = ActionContext.getContext();  
		HttpServletRequest request = ServletActionContext.getRequest();  
		HttpServletResponse response = ServletActionContext.getResponse(); 
		TBuyer buyer = (TBuyer) context.getSession().get("buyer");
		
		String orderID = request.getParameter("orderID");
		System.out.println("orderID="+orderID);
		if( orderdao.alterFinish(Integer.parseInt(orderID), "�����") ){
			System.out.println("ȷ���ջ��ɹ�");
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");        	
			PrintWriter out= response.getWriter();
			out.print("<script>alert('"+orderID+"ȷ���ջ��ɹ�')</script>");
			out.print("<script>window.location.href='order!allOrder.action'</script>"); 
			out.flush(); 
			out.close();
		}
	}	

	public void deleteSingleOrder()  throws IOException{
		System.out.println("--------------");
		System.out.println("��ת��orderAction��deleteSingleOrder()");
		
		ActionContext context = ActionContext.getContext();  
		HttpServletRequest request = ServletActionContext.getRequest();  
		HttpServletResponse response = ServletActionContext.getResponse(); 
	
		
		String orderID = request.getParameter("orderID");
		System.out.println("orderID="+orderID);
		if( orderdao.delete(  Integer.parseInt(orderID))  ){
			System.out.println("ɾ������Ϊ"+orderID+"�ɹ�");
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");        	
			PrintWriter out= response.getWriter();
			out.print("<script>alert('ɾ������Ϊ"+orderID+"�ɹ�')</script>");
			out.print("<script>window.location.href='order!allOrder.action'</script>"); 
			out.flush(); 
			out.close();
		}
	}
	
	public void searchContent() throws IOException{
		System.out.println("--------------");
		System.out.println("��ת��orderAction��searchContent()");
		
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
