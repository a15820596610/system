<%@page import="com.zhbit.dao.cartDao"%>
<%@page import="com.zhbit.entity.TShopCart"%>
<%@page import="com.zhbit.entity.TShop"%>
<%@page import="com.zhbit.dao.buyerDao"%>
<%@page import="com.zhbit.entity.TOrder"%>
<%@page import="com.zhbit.dao.orderDao"%>
<%@page import="com.zhbit.entity.TBuyer"%>
<%@page import="com.zhbit.entity.TSeller"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%		
	
	
	System.out.println("测试：来到shop.jsp");
	TBuyer buyer = (TBuyer)session.getAttribute("buyer");
	TSeller seller = (TSeller)request.getAttribute("seller");
	
	System.out.println("测试：buyerName="+buyer.getUsername());
	System.out.println("测试：sellerName="+seller.getUserName());
	if(buyer == null && seller == null){
		System.out.println("由于当前没有用户登录，将跳转到login.jsp页面");
		%>		
			<jsp:forward page="shop!shopDeal.action"></jsp:forward>
		<%	
	}
	
	TShop shop = (TShop)request.getAttribute("shop");
	System.out.println("buyerId="+buyer.getBuyerId());
	System.out.println("sellerId="+seller.getSellerId());
	System.out.println("shopId="+shop.getShopId()); 
	
	
%>	


<head>
	<title>Free Masti Web Template | Songs :: w3layouts</title>
	 <meta charset="UTF-8">
	<link href="./css/style.css" rel="stylesheet" type="text/css" media="all" />
	<script type="text/javascript">
	
		//点击“立即购买” 对话框选择
		function pay() {
			var judge = confirm("您确定购买吗，即将为您生成订单");
			if( judge ){
				var shopId = document.getElementsByName("shopId");
				var sellerId = document.getElementsByName("sellerId");
				var shopAmount1 = document.getElementsByName("shopAmount");
				window.location.href='shop!payDeal.action?sellerID='+sellerId[0].value+'&shopID='+shopId[0].value+'&shopAmount='+shopAmount1[0].value;
			}
		}
	
	</script>
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
    <div class="shop_title">
    	<a href="index.jsp">返回</a>
    </div>
    <div class="shop_content">
    	<div class="shop_photo">
    		<img src=<%=shop.getShopPhoto() %> width="402px" height="350px"></img>
    	</div>
    	
    	<div class="shop_item">
    		<div class="shop_name">
    			<%=shop.getShopName() %>
    		</div>
    	
    		<div style="margin:0px 10px 20px 0;">
    			价格：&nbsp;&nbsp;&nbsp;&nbsp;<font size="7px" color="red">¥<%=shop.getShopPrice() %></font>
    		</div>
    		<form action="shop!shopDeal.action?sellerID=<%=seller.getSellerId()%>&shopID=<%=shop.getShopId() %>&flag=0  " method=post>
	    		<div>
	    			快递：&nbsp;&nbsp;&nbsp;&nbsp;
	    			<select name="express">
					  <option value="顺丰" >顺丰</option>
					  <option value="圆通">圆通</option>
					  <option value="中通">中通</option>
					  <option value="韵达">韵达</option>
					</select>
	    		</div>
	    		<div style="margin:20px 10px 20px 0"">
	    			数量：&nbsp;&nbsp;&nbsp;&nbsp;
	    			<input type="number" name="shopAmount" step="1" width="1" min="1" max=<%=shop.getShopInventory() %> value="1" /> 			
	    		</div>
	    		<div >
	    			库存：&nbsp;&nbsp;&nbsp;&nbsp;
	    			现存<%=shop.getShopInventory() %>件		
	    		</div>
	    		<div class="shop_item_button">
	    			<center>
	    				<input type="hidden" name="shopId" value=<%=shop.getShopId() %> /> 
	    				<input type="hidden" name="sellerId" value=<%=seller.getSellerId()%>  />
		    			<input type="button" width="180px" value="立即购买" 
		    				onClick=
		    				<%
		    					if(buyer==null){
		    						out.print("");
		    					}else{
		    						out.print("pay()");
		    					}
		    				%> />
		    			
		    			<input type="submit" width="180px" value="加入购物车"/>
	    			</center>
	    		</div>
	    	</form>		
	   </div>
    	
    	
    	
    	
    </div>
    
    <div class="shop_seller">
    	<div class="shop_seller_top">
    		卖家信息
    	</div>
    	
    	<div class="shop_seller_content">
    			
    		<ul>
    			<li><center style="font-weight:bold;font-size:20px;">天下高月</center></li>
    			<li>卖家：&nbsp;&nbsp;&nbsp;<%=seller.getUserName() %></li>
    			<li>资质：&nbsp;&nbsp;&nbsp;老卖家</li>
    			<li>创建时间：&nbsp;&nbsp;&nbsp;XXXXX</li>
    			
    			
    			
    		</ul>
    	</div>
    	
   	 </div>
   	 
   	 <div class="shop_introduce">
   	 	<div style="font-weight: bold;margin:10px;">
   	 		商品详情：
   	 	</div>
   
   	 	<table>
   
   	 		<tr>
   	 			<th>生产许可证编号:asdf</th>
   	 			<th>产品标准号: asdf</th>
   	 			<th>厂名: asdf</th>
   	 			<th>厂址: asdf</th>
   	 		</tr>
   	 		
   	 		<tr>
   	 			<th>生产许可证编号:asdf</th>
   	 			<th>产品标准号: asdf</th>
   	 			<th>厂名: asdf</th>
   	 			<th>厂址: asdf</th>
   	 		</tr>
   	 		
   	 		<tr>
   	 			<th>生产许可证编号:asdf</th>
   	 			<th>产品标准号: asdf</th>
   	 			<th>厂名: asdf</th>
   	 			<th>厂址: asdf</th>
   	 		</tr><tr>
   	 			<th>生产许可证编号:asdf</th>
   	 			<th>产品标准号: asdf</th>
   	 			<th>厂名: asdf</th>
   	 			<th>厂址: asdf</th>
   	 		</tr><tr>
   	 			<th>生产许可证编号:asdf</th>
   	 			<th>产品标准号: asdf</th>
   	 			<th>厂名: asdf</th>
   	 			<th>厂址: asdf</th>
   	 		</tr>
   	 	</table>
   	 </div>
 </body>
</html>
