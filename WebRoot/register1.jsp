<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html> 
	<head>
		<title>用户注册</title>
		</head>
		<body>
		<s:form action="registerAction">
					<s:textfield label="用户名" name="userName" ></s:textfield>
					<s:password label="密码" name="userPassword"></s:password>
					<s:password label="重复密码" name="userRePassword" ></s:password>
					
					<s:submit value="注册" align="center" ></s:submit>					
				</s:form>
		</body>
		</html>