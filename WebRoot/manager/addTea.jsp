<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>���ͼ��</title>
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
			<div style="margin-top: 0px;background-color: yellow;width:100%;height:30px;text-align: left;">��Ӳ�Ҷ</div>
			<div id="" style="width: 90%;magin-top: -100px;" align="center">

				<s:form action="" method="post" enctype="multipart/form-data">
					<s:textfield label="����" name="teaName"></s:textfield>
					<s:textfield label="����" name="teaAuthor"></s:textfield>
					<s:textfield label="������" name="teaPress"></s:textfield>
					<s:file label="ͼƬ" name="doc"></s:file>
					<s:select label="���" name="typeId" list="#{'1':'��ѧ','2':'��ʷ','3':'����','4':'����','5':'����'}"></s:select>
					<s:textfield label="�۸�" name="teaPrice"></s:textfield>
					<s:textfield label="����" name="teaAmount"></s:textfield>
					
					<s:textarea label="���" name="teaRemark"></s:textarea>
					
					<s:submit value="���"></s:submit>
				</s:form>
			</div>
		</div>
		<jsp:include page="bottom.html"></jsp:include>		
	</center>
</body>
</html>
