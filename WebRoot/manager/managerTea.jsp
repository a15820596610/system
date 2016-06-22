<%@ page language="java" pageEncoding="gb2312"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  
  <body>
    <center>
    	<jsp:include page="top.jsp"></jsp:include>
    	<div id="managerPage">
    		<div id="managerLeft">
    			<jsp:include page="managerLeft.jsp"></jsp:include>
    		</div>
	    	<div id="" style="width:85%;background-color: white">
		    	<s:action name="allBookAction" executeResult="false"></s:action>
	    		<ul class="managerTeaUl" style="width:100%">
	    			<li class="manageBookHead"  style="width: 100%;background-color: yellow;color: black;text-align:right;">
	    				最新上架<a class="more" href="oneType.jsp?searchType=bookStatus&searchDescribe=latest">更多..</a>
	    			</li>
					<s:iterator value="#attr.latestBook" status="st">
						<li class="manageBookPicture">
							<a href="singleBook.jsp?bookId=<s:property value="bookId" />"><img src='../upload/<s:property value="bookPicture" />'/></a>
						</li>
						<li class="manageBookInfor">
							<a class="bookName" href="singleBook.jsp?bookId=<s:property value="bookId" />"><s:property value="bookName" /></a><br/><br/>
							作者：<a class="aboutBook" href="oneType.jsp?searchType=bookAuthor&searchDescribe=<s:property value="bookAuthor"/>"><s:property value="bookAuthor"/></a><br/><br/>
							出版社：<a class="aboutBook" href="oneType.jsp?searchType=bookPress&searchDescribe=<s:property value="bookPress"/>"><s:property value="bookPress"/></a><br/><br/>
							类别：<a class="aboutBook" href="oneType.jsp?searchType=bookType&searchDescribe=<s:property value="type.typeId"/>"><s:property value="type.typeName"/></a><br/><br/>
						</li>
					</s:iterator>
	    		</ul>
	    		<ul class="manageBookUl" style="width:100%">
	    			<li class="manageBookHead" style="width: 100%;background-color: yellow;color: black;text-align:right;">
	    				特价热销<a class="more" href="oneType.jsp?searchType=bookStatus&searchDescribe=bargain">更多..</a>
	    			</li>
					<s:iterator value="#attr.bargainBook" status="st">
						<li class="manageBookPicture">
							<a href="singleBook.jsp?bookId=<s:property value="bookId" />"><img src='../upload/<s:property value="bookPicture" />'/></a>
						</li>
						<li class="manageBookInfor">
							<a class="bookName" href="singleBook.jsp?bookId=<s:property value="bookId" />"><s:property value="bookName" /></a><br/><br/>
							作者：<a class="aboutBook" href="oneType.jsp?searchType=bookAuthor&searchDescribe=<s:property value="bookAuthor"/>"><s:property value="bookAuthor"/></a><br/><br/>
							出版社：<a class="aboutBook" href="oneType.jsp?searchType=bookPress&searchDescribe=<s:property value="bookPress"/>"><s:property value="bookPress"/></a><br/><br/>
							类别：<a class="aboutBook" href="oneType.jsp?searchType=bookType&searchDescribe=<s:property value="type.typeId"/>"><s:property value="type.typeName"/></a><br/><br/>
						</li>
					</s:iterator>
	    		</ul>
	    		<ul class="manageBookUl" style="width:100%">
	    			<li class="manageBookHead" style="width: 100%;background-color: yellow;color: black;text-align:right;">
	    				精品推荐<a class="more" href="oneType.jsp?searchType=bookStatus&searchDescribe=recommended">更多..</a>
	    			</li>
					<s:iterator value="#attr.recommendedBook" status="st">
						<li class="manageBookPicture">
							<a href="singleBook.jsp?bookId=<s:property value="bookId" />"><img src='../upload/<s:property value="bookPicture" />'/></a>
						</li>
						<li class="manageBookInfor">
							<a class="bookName" href="singleBook.jsp?bookId=<s:property value="bookId" />"><s:property value="bookName" /></a><br/><br/>
							作者：<a class="aboutBook" href="oneType.jsp?searchType=bookAuthor&searchDescribe=<s:property value="bookAuthor"/>"><s:property value="bookAuthor"/></a><br/><br/>
							出版社：<a class="aboutBook" href="oneType.jsp?searchType=bookPress&searchDescribe=<s:property value="bookPress"/>"><s:property value="bookPress"/></a><br/><br/>
							类别：<a class="aboutBook" href="oneType.jsp?searchType=bookType&searchDescribe=<s:property value="type.typeId"/>"><s:property value="type.typeName"/></a><br/><br/>
						</li>
					</s:iterator>    			
	    		</ul>
	    	</div>
	    </div>
    	<jsp:include page="bottom.html"></jsp:include>
    </center>
    
  </body>
</html>