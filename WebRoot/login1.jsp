<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>


<html>
  <head>
    
    
    <title>用户登录</title>
    
	

  </head>
  
  <body>
  
    <s:form action="loginAction">
    <s:textfield label="用户" name="userName"></s:textfield>
    <s:password label="密码" name="userPassword"></s:password>
    <s:submit type="submit" value="登录"  align="center"></s:submit>
    </s:form>
  </body>
</html>
