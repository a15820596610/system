<%@page import="com.zhbit.dao.cartDao"%>
<%@page import="com.zhbit.entity.TShopCart"%>
<%@page import="com.zhbit.entity.TShop"%>
<%@page import="com.zhbit.dao.buyerDao"%>
<%@page import="com.zhbit.entity.TOrder"%>
<%@page import="com.zhbit.dao.orderDao"%>
<%@page import="com.zhbit.entity.TBuyer"%>
<%@page import="com.zhbit.entity.TSeller"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%	
	System.out.println("测试：来到cart.jsp");
	List list = (List)request.getAttribute("list");  
	if(list==null){
		System.out.println("cartAction ");
		%>	
			<jsp:forward page="cart!showAllCart.action"></jsp:forward>
		<%
	}
	Iterator it = list.iterator();
	TBuyer buyer = (TBuyer)session.getAttribute("buyer");
	TSeller seller = (TSeller)session.getAttribute("seller");
%>	


<head>
<title>Free Masti Web Template | Songs :: w3layouts</title>
<meta charset="UTF-8">
<link href="./css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="./css/cart.css" rel="stylesheet" type="text/css" media="all" />

 <script LANGUAGE="JavaScript">  

	//全选
 function checkall(name){
	 var el = document.getElementsByName(name);
 	 var len = el.length;
 	 var allprice = 0;
 	 for(var i=0; i<len; i++){
 	 	if( el[i].checked==false ){
 	 		el[i].checked = true;
 	 	}
 	 	var price = document.getElementsByName("price");
	 	allprice = Number(allprice)+Number(price[i].value) ;
  	 }
 	 var el1 = document.getElementsByName(name+"1");
 	 el1[0].checked=true;
 	 el1[1].checked=true;
 	 document.getElementById('number').innerHTML = len;
     document.getElementById('allprice').innerHTML = allprice;
 }



 
 // 清空
 function clearAll(name){
	 var el = document.getElementsByName(name);
 	 var len = el.length;
 	 for(var i=0; i<len; i++){
 	 	if( el[i].checked==true ){
 	 		el[i].checked = false;
 	 	}
  	 } 
 	 document.getElementById('number').innerHTML = 0;
	 
 	 var el1 = document.getElementsByName(name+"1");
	 el1[0].checked=false;
	 el1[1].checked=false;
	 document.getElementById('allprice').innerHTML = 0;
 }
 
 //选择“删除”
 function selectDelete(name){
	 var el = document.getElementsByName(name);
 	 var len = el.length;
 	 var cartID = new Array();
 	 for(var i=0; i<len; i++){
 	 	if( el[i].checked==true ){
 	 		cartID[i]=el[i].value;
 	 	}
  	 } 
 	 window.location.href="cart!deleteManyCart.action?cartID="+cartID;
 }
 
 //选中/不选中后的js效果
 function selected(name){
	 var el = document.getElementsByName(name);
 	 var len = el.length;
 	 var number=0;
 	 var allprice = 0;
 	 for(var i=0; i<len; i++){
 	 	if( el[i].checked==true ){
 	 		number++;
 	 		
 	 		var price = document.getElementsByName("price");
 	 		
 	 		allprice = Number(allprice)+Number(price[i].value) ;
 	 	
 	 	}
  	 } 
 	 document.getElementById('number').innerHTML = number;
	 document.getElementById('allprice').innerHTML = allprice;
 }
 
 // 当点击“结算”
 function settlement() {
	  var judge = confirm("您确认要结算吗？即将为您生成订单");
	  var cartID = new Array();
	  if(judge){
		 var el = document.getElementsByName("checkbox");
	 	 var len = el.length;
	 	 for(var i=0; i<len; i++){
	 	 	if( el[i].checked==true ){
	 	 		cartID[i]=el[i].value;
	 	 	}
		 } 
	 	 window.location.href="cart!settlement.action?cartID="+cartID;
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
	<div class="shop_title">
		<a href="index.jsp">返回</a>
	</div>
	<div id="content">
		<font size="5px">购物车</font>
	
		<form action="#" method="post" id="wishlist">
			<div class="wishlist-product">
				
				<table class="table1">
					<thead>
						<tr>
<!-- 							全选/清空 -->
							<td class="_checkbox">
								<input type="checkbox" name="checkbox1" onClick="if(this.checked==true) { checkall('checkbox'); } else { clearAll('checkbox'); }"  />全选<br/>
							</td>
							<td class="image">照片</td>
							<td class="name">商品名字</td>
							<td class="introduce">商品详情</td>
							<td class="price">单价</td>
							<td class="number">商品数量</td>
							<td class="total">总价</td>
							<td class="operator">操作</td>
						</tr>
					</thead>
					
				</table>
				<%
				  int i=1;
				  List<TShopCart> cartList = new ArrayList<TShopCart>();
				  while(it.hasNext()){
				 	 TShopCart cart = (TShopCart)it.next();
					 cartList.add(cart);
				%>	
				<table class="cart_item">
					<tbody>
						<tr>
							
							<td class="_checkbox"> </td>
							<td class="image"></td>
							<td class="name">
								卖家:<%=cart.getTSeller().getUserName() %>
							</td>
							<td class="introduce"></td>
							<td class="price"></td>
							<td class="number"></td>
							<td class="cart"></td>
							<td class="operator">
							</td>
						</tr>
					
						<tr>
		<!-- 			 删除选中的那个	 -->	
							<td class="_checkbox">
								<input type="checkbox" name="checkbox" value=<%=cart.getCartId() %> onclick="selected('checkbox')" /> 
								<input type="hidden" name="price" value=<%=cart.getShopAmount()*cart.getTShop().getShopPrice() %> /> 
								
								
							</td>
							<td class="image">
								<a href="#"><img src=<%=cart.getTShop().getShopPhoto() %> width="110px" height="110px" />
								</a>
							</td>
							<td class="name"><a href="#"><%=cart.getTShop().getShopName() %></a></td>
							<td class="introduce"><%=cart.getTShop().getShopIntroduce() %></td>
							<td class="price"><%=cart.getTShop().getShopPrice() %></td>
							<td class="number"><%=cart.getShopAmount() %></td>
							<td class="total"><%=cart.getShopAmount()*cart.getTShop().getShopPrice() %></td>
							<td class="operator">
								<a href="cart!deleteSingleCart.action?cartID=<%=cart.getCartId()%>" >    
									<input type="button" value="删除"></input>
								</a>
							</td>
						</tr>
					</tbody>
				</table>
				<%
					i++;
				  }
				%>
			</div>
		</form>
		
		
		<div class="total_cart">
		
			<div class="_checkbox">
				<input type="checkbox" name="checkbox1" onClick="if(this.checked==true) { checkall('checkbox'); } else { clearAll('checkbox'); }"  />全选<br/>
			</div>
			
			&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="删除"  onClick="selectDelete('checkbox')"></input>
			<div style="float:right">
				已选商品<font color="red" id="number"></font>件&nbsp;&nbsp;&nbsp;&nbsp;
				合计：<font size="5px" color="red" id="allprice">0</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
		</div>
		<div class="buttons">
			<div class="right">
				<a class="button" onclick="settlement()"><span>结算 </span></a>
			</div>
		</div>
	</div>
	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
	
</body>
</html>
