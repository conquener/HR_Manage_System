<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="<%=basePath%>table.css" type="text/css">
<script type="text/javascript" src="<%=basePath %>javascript/comm/comm.js"></script>
</head>
<body>
<form name="form1" id="form1" method="post" action="">
<table width="100%" >
  <tr>
    <td colspan="2"> 
    <font color="#0000CC">您正在做的业务是：用户--修改密码--密码修改 </font></td>
  </tr>
  <tr>
    <td width="49%"> 密码修改成功</td>
    <td width="51%" align="right">
    	<a href="<%=basePath %>system/change_password/change_password.jsp">返回</a>
	</td>
	</tr>
  </table>
</form>
</body>
</html>