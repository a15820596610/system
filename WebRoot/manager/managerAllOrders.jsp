<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>��������</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  
<body>
	<center>
		<jsp:include page="top.jsp"></jsp:include>
		<div id="managerPage" style="width: 100%;height: 630px;background-color: white;">
			<div id="managerLeft">
				<jsp:include page="managerLeft.jsp"></jsp:include>
			</div>
			<div id="managerAllOrders">
				<ul class="singleOrders"  style="width: 100%;">
					<li style="padding-top:5px;padding-left: 10px;text-align: left;background-color: #66CC33;">
						<a class="aboutOrders" href="managerAllOrders.jsp?searchType=all">���ж���</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="aboutOrders" href="managerAllOrders.jsp?searchType=isDeal">�Ѵ�����</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="aboutOrders" href="managerAllOrders.jsp?searchType=isNotDeal">δ������</a>
					</li>
				</ul>
				
				<ul class="singleOrders" style="width: 100%;background-color:yellow;">
					<li class="sequence">����</li>			
					<li class="ordersNumber">�������</li>			
					<li class="ordersTime">��������</li>			
					<li class="ordersUser">�����û�</li>			
					<li class="dealOrders">������</li>			
				</ul>
				<s:action name="allOrdersAction" executeResult="false"></s:action>
				<s:iterator value="#request.allOrders" status="st">
					<ul class="singleOrders" style="background-color: #EEF4EA;width: 100%;">
						<li class="sequence"><s:property value="#st.getIndex()+#request.sequence+1"/></li>			
						<li class="ordersNumber">
							<a class="aboutBook" href="singleOrders.jsp?ordersId=<s:property value="ordersId"/>"><s:property value="ordersNumber"/></a>
						</li>			
						<li class="ordersTime"><s:date name="ordersTime" format="yyyy-MM-dd HH:mm:ss"/></li>			
						<li class="ordersUser">
							<a class="aboutBook" href="userInformation.jsp?userId=<s:property value="user.userId"/>"><s:property value="user.userName"/></a>
						</li>
						<li class="dealOrders">
							<s:if test='%{isDeal =="0"}'>
								<a class="aboutBook" href='../com.huizhi.action/dealOrdersAction.action?ordersId=<s:property value="ordersId"/>'>������</a>
							</s:if>
							<s:else>
								----
							</s:else>
						</li>			
					</ul>
				</s:iterator>
			</div>
		</div>
		<jsp:include page="bottom.html"></jsp:include>
	</center>
</body>
</html>
