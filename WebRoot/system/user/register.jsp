<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="<%=basePath %>table.css" rel="stylesheet"/>
<title>HR系统用户注册</title>
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
var request= null;
	if(window.ActiveXObject){
	 	request= new ActiveXObject("MSXML2.XMLHttp");
	 }else{
 	 request=new XMLHttpRequest();
	 }
	function systemregisterunamecheck(username){
		var usernamemessage=document.getElementById("usernamemessage");
		if(username!=null&&username){
			request.open("POST", "systemManage!checkUName?checkUserName="+username, true);
			request.setRequestHeader("content-type", "application/x-www-form-urlencoded;charset=utf-8");
			request.onreadystatechange=function(){	
				var text=eval(request.responseText);
				usernamemessage.innerHTML=text[0].name;
		}
		}else{
			alert("用户名不能为空!");
		}
		request.send(null);
	}



function prochk()
{
	if (document.forms[0].elements["systemUser.userName"].value == "")
	{	
		alert ("请填写用户名");
		document.forms[0].elements["systemUser.userName"].focus();
	}
	else{
			
			var name = document.forms[0].elements["systemUser.userName"].value;
			window.open("users.do?operate=isExist&profix=" + document.register.profix.value+"&uname=" + document.forms[0].elements["systemUser.userName"].value); 
	}
}
function namechk()
{
	var name = document.forms[0].elements["systemUser.userName"];
	var tname = document.forms[0].elements["systemUser.userFile"];
	if(name.value == "")
	{
		alert ("请填写用户名");
		name.focus();
		return false;
	}
	else if(tname.value == "")
	{
		alert ("请填写档案编号");
		tname.focus();
		return false;
	}
	else
		return true;
}
function pwdchk()
{
	var pwd = document.forms[0].elements["systemUser.userPassword"];
	var spwd = document.register.surPwd;
	if (pwd.value == "")
	{	
		alert("请填写密码");
		pwd.focus();
		return false;
	}
	else if(spwd.value == "")
	{
		alert("请填写确认密码");
		spwd.focus();
		return false;
	}
	else if(pwd.value != spwd.value)
	{
		alert ("密码和确认密码不相同");
		pwd.value = "";
		spwd.value = "";	
		return false;
	}
	else
		return true;
}
function doAdd()
{
	if(namechk()&&pwdchk())
	{
		document.forms[0].action ="systemManage!systemUserRegister";
		document.forms[0].submit();
	}
}


	
</script>
</head>

<body bgcolor="#E9F8F3">
<form method="post" action="user_addsuccess.html" name="register">
<table width="100%">
  <tr>
    <td height="169" colspan="3" align="center">
      <p >&nbsp;</p>
      <p >&nbsp;</p>
      <p >&nbsp;</p>
      <p class="style1">腾飞HR系统用户注册</p></td>
  </tr>
  <tr>
  <td width="18%" height="166">&nbsp;</td>
  <td width="62%">
  <table width="95%" border="1" cellpadding=0 cellspacing=1 bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
  <tr>
    <td width="20%" class="TD_STYLE1">使用单位简称</td>
    <td width="80%" class="TD_STYLE2"><input name="systemUser.userReferredToAs" type="text" class="INPUT_STYLE1" value="腾飞发展科技有限公司" readonly="readonly"></td>
  </tr>
  <tr>
    <td width="20%" class="TD_STYLE1">用户名</td>
    <td width="80%" class="TD_STYLE2"><input type="text" name="systemUser.userName" value="" onblur="systemregisterunamecheck(this.value);" class="INPUT_STYLE1">&nbsp;<span id="usernamemessage">用户名是否可用</span></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">用户档案编号</td>
    <td class="TD_STYLE2"><input type="text" name="systemUser.userFile" value="" class="INPUT_STYLE1"></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">密码</td>
    <td class="TD_STYLE2"><input type="password" name="systemUser.userPassword" value="" style="background-color: #DEEBF7" class="INPUT_STYLE1"></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">确认密码</td>
    <td class="TD_STYLE2"><input name="surPwd" type="password" class="INPUT_STYLE1" style="background-color: #DEEBF7"></td>
  </tr>
  </table>
  </td>
  <td width="20%" >&nbsp;</td>
  </tr>
  <tr>
    <td></td>
    <td align="center"><input type="button" value="注册" class="BUTTON_STYLE1" onclick="javascript:doAdd();"> &nbsp;
      <input type="button" value="返回" onclick="history.back();" class="BUTTON_STYLE1"></td>
	  <td></td>
  </tr>
  <tr>
  	<td></td>
  	<td><c:if test="${!empty requestScope.errormessage1}">${requestScope.errormessage1}</c:if></td>
  	<td></td>
  </tr>
</table>
</form>      
</body>
</html>
