<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=basePath %>table.css" rel="stylesheet"/>
<title>用户角色添加</title>
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
		document.forms[0].action ="systemManage!rolesetupdate";
		document.forms[0].submit();
}


var request= null;
	if(window.ActiveXObject){
	 	request= new ActiveXObject("MSXML2.XMLHttp");
	 }else{
 	 request=new XMLHttpRequest();
	 }
	function rolequery(){
		request.open("POST", "systemManage!rolequery", true);
		request.setRequestHeader("content-type", "application/x-www-form-urlencoded;charset=utf-8");
		var roleselect=document.getElementById("roleselect");
		request.onreadystatechange=function(){	
			var text=eval(request.responseText);
			var options="<option value='-1'>----请选择-----</option>";
			for( var i=0;i<text.length;i++) {
				options+= ("<option value="+text[i].roleId+">"+text[i].roleName+"</option>");
			}		
			roleselect.innerHTML=options;
		}
		request.send(null);
	}
</script>
</head>

<body bgcolor="#E9F8F3" onload="rolequery();">
<form method="post" action="" id="form1">
<font color="#0000CC">您正在做的业务是：角色设置--角色设置管理--用户角色修改 </font>
<table width="100%">
  <tr>
    <td height="169" colspan="3" align="center">
      <p >&nbsp;</p>
      <p >&nbsp;</p>
      <p >&nbsp;</p>
      <p class="style1">用户角色修改</p></td>
  </tr>
  <tr>
  <td width="18%" height="166">&nbsp;</td>
  <td width="62%">
  <table width="95%" border="1" cellpadding=0 cellspacing=1 bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
 	<%
 		String userName=new String((request.getParameter("userName")).getBytes("iso8859-1"),"utf-8");
 		String userId= request.getParameter("systemuserId");
 	 %>
  <tr>
    <td width="20%" class="TD_STYLE1">用户名</td>
	<td class="TD_STYLE2" height="25">
	<input type="text" name="rolesetuserName" value="<%=userName %>" style="background-color: #DEEBF7" class="INPUT_STYLE1">
	<input type="hidden" name="systemuserId" value="<%=userId %>" id="userId"/>
	</td>
  </tr>
  <tr>
    <td class="TD_STYLE1">添加角色</td>
    <td class="TD_STYLE2">
    	<select name="rolesetroleId" id="roleselect" value="" class="INPUT_STYLE1">
		</select></td>
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
