<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>�����������</title>
  </head>
  
<body bgcolor="white">
	<center>
		<jsp:include page="top.jsp"></jsp:include>	
		<div id="managePage" style="width: 100%;height: 630px;background-color: white;">
			<div id="manageLeft">
				<jsp:include page="managerLeft.jsp"></jsp:include>	
			</div>
			<div id="manageWelcome" style="width: 80%" align="center">
				<div style="font-weight: bold;font-size: 16px;">��ӭ����
					<font style="color: green;font-size: 24px;"><s:property value="#session.managerLoginName"/></font>
				</div>
				<div style="margin-top: 100px;">
					���ǹ�˾�����������
					<hr style="width: 200px;"/>
					һ��Ϊ������&nbsp;&nbsp;&nbsp;&nbsp;Ϊ������һ��
				</div>
			</div>
		</div>
		<jsp:include page="bottom.html"></jsp:include>		
	</center>
</body>
</html>
