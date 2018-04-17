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
<title>卓景京HR系统用户注册</title>
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
		document.forms[0].action ="systemManage!userupdate";
		document.forms[0].submit();
}
</script>
</head>

<body bgcolor="#E9F8F3">
<form method="post" action="users.do" name="register">
<table width="100%">
  <tr>
    <td height="169" colspan="3" align="center">
      <p >&nbsp;</p>
      <p >&nbsp;</p>
      <p >&nbsp;</p>
      <p class="style1">卓景京HR系统用户修改</p></td>
  </tr>
  <tr>
  <td width="18%" height="166">&nbsp;</td>
  <td width="62%">
  <table width="95%" border="1" cellpadding=0 cellspacing=1 bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
  <tr>
  <input type="hidden" value="${requestScope.usermessage.userId}"  name="systemUser.userId"/>
    <td width="20%" class="TD_STYLE1">使用单位简称</td>
    <td width="80%" class="TD_STYLE2"><input name="systemUser.userReferredToAs" type="text" class="INPUT_STYLE1" value="${requestScope.usermessage.userReferredToAs}" readonly="readonly"></td>
  </tr>
  <tr>
    <td width="20%" class="TD_STYLE1">用户名</td>
    <td width="80%" class="TD_STYLE2"><input type="text" name="systemUser.userName" value="${requestScope.usermessage.userName}" class="INPUT_STYLE1"></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">用户档案编号</td>
    <td class="TD_STYLE2"><input type="text" name="systemUser.userFile" value="${requestScope.usermessage.userFile}" class="INPUT_STYLE1"></td>
  </tr>
  </table>
  </td>
  <td width="20%" >&nbsp;</td>
  </tr>
  <tr>
    <td></td>
    <td align="center"><input type="button" value="确认修改" class="BUTTON_STYLE1" onclick="javascript:doAdd();"> &nbsp;
      <input type="button" value="返回" onclick="history.back();" class="BUTTON_STYLE1"></td>
	  <td></td>
  </tr>
</table>
</form>      
</body>
</html>
