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
        <dt onClick='showHide("items1_1")'><b>���ò���</b></dt>
        <dd style='display:block' class='sitem' id='items1_1'>
          <ul class='sitemu'>
            <li>
              <div class='items'>
                <div class='fllct'><a href='addTea.jsp' target='main'>��Ӳ�Ҷ</a></div>
                <div class='flrct'> <a href='addTea.jsp' target='main'><img src='skin/images/frame/gtk-sadd.png' alt='��Ӳ�Ҷ' title='��Ӳ�Ҷ'/></a> </div>
              </div>
            </li>
            <li><a href='managerTea.jsp' target='main'>��Ҷ����</a> </li>
            <li>
              <div class='items'>
                <div class='fllct'><a href='managerAllOrders.jsp' target='main'>��������</a></div>
                <div class='flrct'> <a href='managerAllOrders.jsp' target='main'><img src='skin/images/frame/gtk-del.png' alt='��������' title='��������'/></a> </div>
              </div>
            </li>
          </ul>
        </dd>
      </dl>
      <!-- Item 1 End -->
      <!-- Item 2 Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items2_1")'><b>�û�����</b></dt>
        <dd style='display:block' class='sitem' id='items2_1'>
          <ul class='sitemu'>
            <li><a href='userInformation.jsp' target='_blank'>�鿴�û���Ϣ</a></li>
            <li><a href='http://www.taobao.com' target='_blank'>������û�</a></li>
            
          </ul>
        </dd>
      </dl>
      <!-- Item 2 End -->
	  </td>
  </tr>
</table>
</body>
</html>