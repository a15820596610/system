<%@page import="com.zhbit.entity.TSeller"%>
<%@page import="com.zhbit.entity.TShop"%>
<%@page import="com.zhbit.dao.shopDao"%>
<%@page import="com.zhbit.entity.TBuyer"%>
<%@page import="com.zhbit.dao.buyerDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%-- <%
	
	TBuyer buyer = (TBuyer)session.getAttribute("buyer");

%>	 --%>	

<%
	buyerDao buyerdao = new buyerDao();
	List list1 = buyerdao.query("select *from t_buyer where buyerID=1");
	Iterator it1 = list1.iterator();
	TBuyer buyer = (TBuyer)it1.next();
	session.setAttribute("buyer", buyer);
	System.out.println("buyerID="+buyer.getBuyerId());
	
	
	TSeller seller = (TSeller)session.getAttribute("seller");
%>

<html>
<head>
	<title>Free Masti Web Template | Songs :: w3layouts</title>
	<meta charset="UTF-8">
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<header>
    	<div class="wrap">
			
            <div class="logo">
                <a href="index.jsp"><img src="./images/logo.png" alt=""></a>
            </div>

            <div class="menu">
                <ul>
                	    <%
                		 if( buyer != null || seller!=null ){
                		%>	 
                			<li>
								<a href="login.jsp">
									<%
										if(buyer!=null){
											out.print("买家用户: "+buyer.getNickName() );
                				 		 }else{
											if(seller!=null){
												out.print("卖家用户: "+seller.getNickName() );
		            				 		 }
                				 		 }
									%>
								</a>
							</li>
							<li><a href="">个人信息</a></li>
						<% 
							if(seller==null){
							%>
								<li><a href="cart!showAllCart.action">购物车</a></li>
							<%
							}
							
						%>
							
							
							<li><a href="order!allOrder.action">订单中心</a></li>
							<li><a href="clear.action">切换用户</a></li>
                		 <%
                		}
                	    if( buyer != null && seller!=null ){	
                		 %>	
                			<li><a href="login.jsp">点击登录</a></li>
       						<li><a href="register.jsp">点击注册</a></li>
       						
       					 <%
                		} 
                	 %>
					 
					 
                </ul>
            </div>
            <div class="clearFloat"></div>
         </div>
    </header>
    <div class="wrap">
        <div class="one sidebar">
            <div class="widget">
                <ul>
                    <li><a href="greenTea.jsp" class="icon">绿茶</a></li>
                    <li><a href="LongJingTea.jsp" class="icon">龙井茶</a></li>
                    <li><a href="redTea.jsp" class="icon">红茶</a></li>
                    <li><a href="blackTea.jsp" class="icon">黑茶</a></li>
                    <li><a href="OolongTea.jsp" class="icon">乌龙茶</a></li>
                </ul>
            </div>
        </div>
        <div class="content">
        	
            <div class="grids">
                <h2>商品页面</h2>
				<div class="search-box">
					<form action=" ">
						<input type="text" value=""></input>
						<input type="submit" value="" class="icon"></input>
					</form>
					<input type="button" value="按照价格排序"></input>
				
				</div>
				
				<br/><br/><br/><br/><br/><br/><br/><br/>
				
			
				<%
				  shopDao shopdao = new shopDao();		  
				  List list = shopdao.query("select *from t_shop where isShow='已上架' order by shopPrice");  
				  Iterator it = list.iterator();
				  while(it.hasNext()){
					  
				 	 TShop shop = (TShop)it.next();
			

				%>	
				<a href="shop!shopDeal.action?shopID=<%=shop.getShopId()%>&sellerID=<%=shop.getTSeller().getSellerId() %>"
					target="_blank">	
					<div class="grid">
	                    <div class="preview">
	                        <img src=<%= shop.getShopPhoto()%>  height="220px" alt="">
		                    <div class="grid_bottom">
		                    	
		                    	<div class="grid_bottom_price">
		                    		¥<%=shop.getShopPrice() %>
		                    	</div>
		                    	
		                    	<font color="black" size="1px">
		                    		<%
	                           			if(shop.getShopIntroduce().length() < 10){
	                           				out.print(shop.getShopIntroduce().substring(0, shop.getShopIntroduce().length()));
	                           			}else{
	                           				out.print(shop.getShopIntroduce().substring(0, 10));
	                           			}	
		                            %>
		                    	</font>
		                    	<br/><br/>
		                    	<font color="black" size="3px">
		                    		卖家：<%=shop.getTSeller().getNickName() %>
		                    	</font>
		                    
		                    </div>  
		                        
		                         	
		                      
	                       
	                    </div>
	                </div>
	            </a>
             	<%
                	}
                 %>
			</div>
			<!-- <center>
	            <div class="more">
	                <ul>
	                	<li><a href="#">&laquo;</a></li>
	                	<li class="active"><span>1</span></li>
	                	<li><a href="#">2</a></li>
	                	<li><a href="#">3</a></li>
	                	<li><a href="#">4</a></li>
	                	<li><a href="#">&raquo;</a></li>
	                </ul>
	            </div>
	        </center> -->
        </div>
      </div>
	    <footer>
	            <div class="wrap">
	                <div class="about">
	                    <div class="title">About Us</div>
	                    <p>中国茶叶历史悠久，各种各样的茶类品种，万紫千红，竟相争艳，犹如春天的百花园，使万里山河分外妖娆。</p>
	            </div>
                <ul>
                    <li class="title">用户</li>
                    <li><a href="#">个人信息</a></li>
                    <li><a href="#">我的订单</a></li>
                    <li><a href="#">我的购物车</a></li>
                    
                </ul>
                <ul>
                    <li class="title">商品</li>
                    <li><a href="greenTea.jsp">绿茶</a></li>
                    <li><a href="LongJingTea.jsp">龙井茶</a></li>
                    <li><a href="redTea.jsp">红茶</a></li>
                    <li><a href="blackTea.jsp">黑茶</a></li>
                    <li><a href="OolongTea.jsp">乌龙茶</a></li>
                   
                </ul>
                
                <div class="clearFloat"></div>
                <center>
                	<div class="copy"><p>&copy; 2012 All Rights Reserved | Designed by - <a href="">【马煜斌】【李土炎】</a></p></div>
            	</center>
            </div>
	    </footer>
</body>
</html>

