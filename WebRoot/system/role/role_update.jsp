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
<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	function formsubmit(){
		form1.action="systemManage!roleupdatasuccess";
		form1.submit();
	}

</script>
</head>
<body>
<form name="form1" id="form1" method="post" action="">
<table width="100%" >
  <tr>
    <td> 
    <font color="#0000CC">您正在做的业务是：角色--角色管理--角色修改 </font></td>
  </tr>
  <tr>
    <td align="right"><input type="button" value="提交" class="BUTTON_STYLE1" onclick="formsubmit();s">
      <input type="button" value="返回" class="BUTTON_STYLE1" onclick="history.back();"></td>
  </tr>
  </table>
<table width="100%"  border="1" cellpadding=0 cellspacing=1 bordercolorlight='#848284' bordercolordark='#eeeeee' class="TABLE_STYLE1">
<%
	Integer roleId = Integer.parseInt(request.getParameter("roleId"));
	String roleName = new String((request.getParameter("roleName")).getBytes("iso8859-1"),"utf-8");
	
 %>
  <tr>
    <td class="TD_STYLE1">角色名称</td>
    <td class="TD_STYLE2">
    	<input type="hidden" name="role.roleId" value="<%=roleId %>" />
    	<input type="text" name="role.roleName" value="<%=roleName%>"  class="INPUT_STYLE1">
    </td>
  </tr>
</table>
</form>
</body>
</html>
