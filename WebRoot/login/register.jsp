<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>

<script type="text/javascript">



function check(){
	if(!checkUserName()){
		return false;
	}
	if(!checkPassWord()){
		return false;
	}
	if(!checkConfirmPwd()){
		return false;
	}
	if(!checkEmail()){
		return false;
	}
	if(!checkPhone()){
		return false;
	}
	
	return true;
}

function checkUserName(){
	var username = document.getElementById("username");
	if(isNull(username.value)){
		alert("对不起用户，用户名不能为空");
		return false;
	}
	if(username.value.length<6 || username.value.length>12){
		alert("对不起用户，用户名必须在6到12位之间");
		return false;
	}
	var matches = /^[A-Za-z0-9]{6,12}$/;
	var flag = matches.test(username.value);
	if(!flag){
		alert("对不起用户，用户名必须为英文或数字");
		return false;
	}
	return true;
}


function checkPassWord(){
	var password = document.getElementById("password");
	if(isNull(password.value)){
		alert("对不起用户，密码不能为空");
		return false;
	}
	if(password.value.length<6 || password.value.length>16){
		alert("对不起用户，密码必须在6到16位之间");
		return false;
	}
	
	var matches = /^[A-Za-z][A-Za-z0-9]{5,16}$/;
	var flag = matches.test(password.value);
	if(!flag){
		alert("对不起用户，密码必须以字母开始，且不能输入符号");
		return false;
	}
	
	return true;
}

function checkConfirmPwd(){
	var confirmpwd = document.getElementById("confirmPwd").value;
	var password = document.getElementById("password").value;
	if(confirmpwd != password){
		alert("对不起用户，两次输入的密码不一样，清重新输入。");
		return false;
	}
	return true;
}


function isNull(value){
	if(value != "" && value != null){
		return false;
	}else{
		return true;
	}
}

function isNotNull(value){
	if(value != "" && value != null){
		return true;
	}else{
		return false;
	}
}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="<%=basePath %>table.css" rel="stylesheet"/>
<title>Better伯乐HR系统用户注册</title>
<style type="text/css">
<!--
.style1 {
	font-size: 18px;
	font-weight: bold;
	color: #660000;
}
-->
</style>
</head>

<body bgcolor="#E9F8F3">
<form method="post" action="register" onSubmit="return check();" name="register">
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
    <td width="80%" class="TD_STYLE2"><input name="profix" type="text" class="INPUT_STYLE1" value="腾飞" readonly="readonly"></td>
  </tr>
  
  <tr>
    <td width="20%" class="TD_STYLE1">用户名</td>
    <td width="80%" class="TD_STYLE2">
    <input type="hidden" name="user.userRoleId" value="0" />
    <input id="username" type="text" name="user.userName" value="" class="INPUT_STYLE1">&nbsp;
    <a href="javascript:prochk();">用户名是否可用</a>(用户名必须大于6位小于12位且用户名必须为英文或数字)</td>
  </tr>
  <tr>
    <td class="TD_STYLE1">真实姓名</td>
    <td class="TD_STYLE2"><input id="truename" type="text" name="user.userTruename" value="" class="INPUT_STYLE1"></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">密码</td>
    <td class="TD_STYLE2"><input id="password" type="password" name="user.userPassword" value="" style="background-color: #DEEBF7" class="INPUT_STYLE1">(密码必须在6到16位之间,并且以字母开始且不能输入符号)</td>
  </tr>
  <tr>
    <td class="TD_STYLE1">确认密码</td>
    <td class="TD_STYLE2"><input id="confirmPwd" name="userPassword2" type="password" class="INPUT_STYLE1" style="background-color: #DEEBF7"></td>
  </tr>
  </table>
  </td>
  <td width="20%" >&nbsp;</td>
  </tr>
  <tr>
    <td></td>
    <td align="center"><input type="submit" value="注册"> &nbsp;
      <input type="submit" value="返回" onclick="history.back();" class="BUTTON_STYLE1"></td>
	  <td></td>
  </tr>
</table>
</form>      
</body>
</html>
