<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="<%=basePath %>table.css" type="text/css">
<script type="text/javascript">
	
	
</script>
</head>
<body>
<form method="post" action="">
<table width="100%" >
  <tr>
    <td colspan="2"> 
    <font color="#0000CC">您正在做的业务是：人力资源--薪酬标准管理--薪酬标准更改 </font></td>
  </tr>
  <tr>
    <td width="49%"> 更改成功！</td>
    <td width="51%" align="right">
    <a href="salary/salarystandardmanage/salarystandard_change_locate.jsp" target="mainFrame">返回</a></td></tr>
  </table>

</form>
</body>
</html>
