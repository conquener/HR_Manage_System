<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="<%=basePath %>table.css" type="text/css">
<script type="text/javascript" src="<%=basePath %>javascript/comm/comm.js"></script>
</head>
<body>
<form name="form1" method="post" action="">
<table width="100%" >
  <tr>
    <td colspan="2"> 
    <font color="#0000CC">您正在做的业务是：用户--用户管理--用户维护 </font></td>
  </tr>
  <tr>
    <td width="49%">用户修改成功，请返回！</td>
    <td width="51%" align="right">
		<a href="systemManage!userquery">返回</a>
	</td>
	</tr>
  </table>

</form>
</body>
</html>