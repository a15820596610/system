<%@page import="com.zhbit.entity.TSeller"%>
<%@page import="com.zhbit.dao.buyerDao"%>
<%@page import="com.zhbit.entity.TOrder"%>
<%@page import="com.zhbit.dao.orderDao"%>
<%@page import="com.zhbit.entity.TBuyer"%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<link href="./css/order.css" rel="stylesheet" type="text/css" media="all" />
<%
	
		  
	List list = (List)request.getAttribute("list");  
	if(list==null){
		%>	
			<jsp:forward page="order!allOrder.action"></jsp:forward>>
		<%
	}
	Iterator it = list.iterator();
	
	TBuyer buyer = (TBuyer)session.getAttribute("buyer");
	TSeller seller = (TSeller)session.getAttribute("seller");
%>	
<!DOCTYPE jsp>
<html>
<head>
	<title>Free Masti Web Template | Songs :: w3layouts</title>
	 <meta charset="UTF-8">
	<link href="./css/style.css" rel="stylesheet" type="text/css" media="all" />
	
	<script type="text/javascript">
		function pay(i) {
			if( confirm("确认付款吗") ){
				var orderID = document.getElementsByName("orderID"+i);
				window.location.href='order!orderPay.action?orderID='+orderID[0].value;
			}
		}
		
		function confirmGoods(i) {
			if( confirm("确认收货吗？如果没收到商品确认的话可能会钱货两空") ){
				var orderID = document.getElementsByName("orderID"+i);
				window.location.href='order!orderConfirmGoods.action?orderID='+orderID[0].value;
				
			}
		}
		
		function confirmDelete(i) {
			var orderID = document.getElementsByName("orderID"+i);
			if( confirm("确认删除编号为"+orderID[0].value+"的订单吗") ){
				
				window.location.href='order!deleteSingleOrder.action?orderID='+orderID[0].value;
				
			}
		}
		
		function searchOrder() {
			var search = document.getElementsByName("search");
			alert(search[0].value);
			window.location.href='order!searchContent.action?search='+search[0].value;

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
                				 		 }
										if(seller!=null){
											out.print("卖家用户: "+seller.getNickName() );
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
				<h3 style="padding:10px;">
					<% 
						if(buyer!=null){
							out.print(buyer.getNickName());
						}else{
							out.print(seller.getNickName());
						}
						
					%>用户
				</h3>
                <ul>
                    <li><a href="#">个人信息</a></li>
					<li><a href="#">订单中心</a></li>
					<li><a href="#">已买宝贝</a></li>
                </ul>
            </div>
        </div>
	</div>
	
	<div id="content">
		<div class="order_selectStatus">
			<a href="order!allOrder.action">所有订单|</a>
			<a href="order!orderStatus_false.action">待付款 |</a>
			<a href="order!orderStatus_true.action">已付款 |</a>
			<a href="order!isFinish_false.action">交易中 | </a>
			<a href="order!isFinish_true.action">交易完成 </a>
			<hr color="blue" size="1px">
	
		</div>
		<br/>
		<input type="text" placeholder="搜索订单编号或者价格"  name="search"/>
		<input type="submit" value="搜索"  onclick="searchOrder()"  />
		
		<% if(buyer !=null){out.print("（买家版）");} 
		else{out.print("（卖家版）");}
		%>
		</br></br>
	
		
		<div class="wishlist-product">
			
			<table class="table1">
				<thead>
					<tr>
						<td class="shop_">宝贝</td>
						<td class="shopName">名字</td>
						<td class="shopIntroduce">详情</td>
						<td class="shop_price">单价</td>
						<td class="shop_number">数量</td>
						<td class="shop_allPrice">总付款</td>
						<td class="shop_status">状态</td>
						<td class="shop_isFinish">操作</td>
					</tr>
				</thead>
				
			</table>
			<%
		
			 int i=0;
			 while(it.hasNext()){
			 	TOrder order = (TOrder)it.next();
			%>
			<table class="cart_item">
				<tbody>
					<tr class="table_head">
						<td>编号:<%=order.getOrderId() %></td>
						<td>店铺</td>
						<td>卖家：<%=order.getTSeller().getNickName()%></td>
						<td>
					<!-- 		时间修改一下 -->
							时间：
							
						</td>
						<td></td>
						<td></td>
						
						<td></td>
						<td>
							<input type="button" value="删除" onclick="confirmDelete(<%=i %>)"></input>
						</td>
						<input type="hidden" value=<%=order.getOrderId() %> name="orderID<%=i %>"></input>
					</tr>
				
					<tr>
		
						<td class="shop_">
							<a href="#"><img src=<%=order.getTShop().getShopPhoto() %> width="110px" height="110px" />
							</a>
						</td>
						<td class="shopName"><%=order.getTShop().getShopName() %></td>
						<td class="shopIntroduce"><%=order.getTShop().getShopIntroduce() %></td>
						
						<td class="shop_price"><%=order.getTShop().getShopPrice() %></td>
				
						<td class="shop_number"><%=order.getShopAmount() %></td>
						<td class="shop_allPrice"><%=order.getTShop().getShopPrice()*order.getShopAmount()  %></td>
						<td class="shop_status">
						
						
						<%
		/* 					买家版 */
							if( order.getOrderStatus().equals("未付款") && buyer!=null){
								%>
<%-- 									<input type="button" value="点击付款" onclick="order!orderPay.action?orderID=<%=order.getOrderId()  %>"></input>
 --%>								
 										<input type="button" value="点击付款" onclick="pay(<%=i %>)"></input>
 			
								<%
								
							}else{
								if( order.getOrderStatus().equals("已付款") && buyer!=null){
									out.print("您已付款");
								}
							}
							
	/* 						卖家版 */
							if( order.getOrderStatus().equals("未付款") && seller!=null ){
								out.print("买家未付款");
							}
							if( order.getOrderStatus().equals("已付款") && seller!=null){
								out.print("买家已付款，可以发货");
							}
							
						%>
						</td>
						<td class="shop_isFinish">
							<%
							
	/* 							买家版 */
								if( buyer!=null && order.getOrderStatus().equals("已付款") && order.getIsFinish().equals("进行中")   ) {
									%>
										<input type="button" value="确认收货" onclick="confirmGoods(<%=i %>)"></input>
									<%
								}
									
								if( buyer!=null && order.getOrderStatus().equals("已付款") && order.getIsFinish().equals("已完成")    ) {
									
										out.print("交易完成");
								
								}
							
								if( buyer!=null && order.getOrderStatus().equals("未付款") && order.getIsFinish().equals("进行中")   ) {
									out.print("请进行付款");
								}
								
								
/* 								卖家版 */
								if( seller!=null && order.getOrderStatus().equals("已付款") && order.getIsFinish().equals("进行中")   ) {
									out.print("买家已付款，可以发货");
								}
								
								if( seller!=null && order.getOrderStatus().equals("已付款") && order.getIsFinish().equals("已完成")   ) {
									out.print("交易完成");
								}
							%>
						
						
						</td>
					</tr>
				</tbody>
			</table>
			<%
			  i++;
			 }
			%>
			
		</div>
	

	
</body>
</html>