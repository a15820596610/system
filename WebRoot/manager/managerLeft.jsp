<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<link rel="stylesheet" href="skin/css/base.css" type="text/css" />
<link rel="stylesheet" href="skin/css/menu.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<script language='javascript'>var curopenItem = '1';</script>
<script language="javascript" type="text/javascript" src="skin/js/frame/menu.js"></script>
<base target="main" />
</head>
<body target="main">
<table width='99%' height="100%" border='0' cellspacing='0' cellpadding='0'>
  <tr>
    <td style='padding-left:3px;padding-top:8px' valign="top">
	<!-- Item 1 Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items1_1")'><b>常用操作</b></dt>
        <dd style='display:block' class='sitem' id='items1_1'>
          <ul class='sitemu'>
            <li>
              <div class='items'>
                <div class='fllct'><a href='addTea.jsp' target='main'>添加茶叶</a></div>
                <div class='flrct'> <a href='addTea.jsp' target='main'><img src='skin/images/frame/gtk-sadd.png' alt='添加茶叶' title='添加茶叶'/></a> </div>
              </div>
            </li>
            <li><a href='managerTea.jsp' target='main'>茶叶管理</a> </li>
            <li>
              <div class='items'>
                <div class='fllct'><a href='managerAllOrders.jsp' target='main'>订单管理</a></div>
                <div class='flrct'> <a href='managerAllOrders.jsp' target='main'><img src='skin/images/frame/gtk-del.png' alt='订单管理' title='订单管理'/></a> </div>
              </div>
            </li>
          </ul>
        </dd>
      </dl>
      <!-- Item 1 End -->
      <!-- Item 2 Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items2_1")'><b>用户管理</b></dt>
        <dd style='display:block' class='sitem' id='items2_1'>
          <ul class='sitemu'>
            <li><a href='userInformation.jsp' target='_blank'>查看用户信息</a></li>
            <li><a href='http://www.taobao.com' target='_blank'>添加新用户</a></li>
            
          </ul>
        </dd>
      </dl>
      <!-- Item 2 End -->
	  </td>
  </tr>
</table>
</body>
</html>