<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加图书</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<style type="text/css">
		
	</style>
  </head>
  
<body>
	<center>
		<jsp:include page="top.jsp"></jsp:include>
		<div id="managerPage" style="width: 100%;height: 630px;background-color: white;">
			<div id="managerLeft">
				<jsp:include page="managerLeft.jsp"></jsp:include>
			</div>	
			<div style="margin-top: 0px;background-color: yellow;width:100%;height:30px;text-align: left;">添加茶叶</div>
			<div id="" style="width: 90%;magin-top: -100px;" align="center">

				<s:form action="" method="post" enctype="multipart/form-data">
					<s:textfield label="名称" name="teaName"></s:textfield>
					<s:textfield label="作者" name="teaAuthor"></s:textfield>
					<s:textfield label="出版社" name="teaPress"></s:textfield>
					<s:file label="图片" name="doc"></s:file>
					<s:select label="类别" name="typeId" list="#{'1':'文学','2':'历史','3':'天文','4':'地理','5':'其他'}"></s:select>
					<s:textfield label="价格" name="teaPrice"></s:textfield>
					<s:textfield label="数量" name="teaAmount"></s:textfield>
					
					<s:textarea label="简介" name="teaRemark"></s:textarea>
					
					<s:submit value="添加"></s:submit>
				</s:form>
			</div>
		</div>
		<jsp:include page="bottom.html"></jsp:include>		
	</center>
</body>
</html>
