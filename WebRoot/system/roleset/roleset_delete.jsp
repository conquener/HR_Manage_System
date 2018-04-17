<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="<%=basePath %>table.css" rel="stylesheet"/>
<title>用户角色删除</title>
<style type="text/css">
<!--
.style1 {
	font-size: 18px;
	font-weight: bold;
	color: #660000;
}
-->
</style>
<script type="text/javascript">

function doAdd()
{
	document.forms[0].action = "systemManage!rolesetdelete";
	document.forms[0].submit();
}
</script>
</head>

<body bgcolor="#E9F8F3">
<form method="post" action="users.do" name="register">
<font color="#0000CC">您正在做的业务是：角色设置--角色设置管理--用户角色删除 </font>
<table width="100%">
	
			
	

  <tr>
  <td width="18%" height="166">&nbsp;</td>
  <td width="62%">
  <table width="95%" border="1" cellpadding=0 cellspacing=1 bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
  
  <tr>
    <td width="20%" class="TD_STYLE1">用户名</td>
	<td class="TD_STYLE2" height="25">${requestScope.usermessage.userName}</td>
  </tr>
  <tr>
    <td class="TD_STYLE1">用户角色</td>
   <td class="TD_STYLE2" height="25">${requestScope.usermessage.userRoleName}</td>
  </tr>
  <tr>
    <td width="20%" class="TD_STYLE1">用户角色状态</td>
	<td class="TD_STYLE2" height="25">待审核</td>
  </tr>
  <input type="hidden" name="systemuserId" value="${requestScope.usermessage.userId}" />
  </table>
  </td>
  <td width="20%" >&nbsp;</td>
  </tr>
  <tr>
    <td></td>
    <td align="center"><input type="button" value="确认删除" class="BUTTON_STYLE1" onclick="javascript:doAdd();"> &nbsp;
      <input type="button" value="返回" onclick="history.back();" class="BUTTON_STYLE1"></td>
	  <td></td>
  </tr>
</table>
</form>      
</body>
</html>
