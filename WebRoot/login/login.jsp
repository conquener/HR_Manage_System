<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd" >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
<meta HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<meta HTTP-EQUIV="Expires" CONTENT="0">
<meta content="Microsoft FrontPage 4.0" name=GENERATOR>

<link href="<%=basePath %>table.css" rel="stylesheet" />
<link href="<%=basePath%>login.css">
<script type="text/javascript"
	src="<%=basePath%>javascript/comm/comm.js"></script>
<title>欢迎进入腾飞HR系统</title>

<script type="text/javascript">
 function login(path)
 {
 	if(infchk())
 	{
		document.forms[0].action = path+"/login/login";
 		document.forms[0].submit();
 	}
 }
 
 function infchk()
{
	var name = document.forms[0].elements["userName"];
	var pwd = document.forms[0].elements["userPwd"];
	if(name.value == "")
	{
		alert ("请填写用户名");
		name.focus();
		return false;
	}	else if(pwd.value == ""){
		alert ("请填写密码");
		pwd.focus();
		return false;
	}
		return true;
}
	/* function check(){
	var code = document.getElementById("key").value;
	var input = document.getElementById("input").value; 
	alert(code);
	alert(input);
	if(input!=code){
		alert("验证码不对!");
		return false;
	}
	return true;
} */

</script>
</head>
<body bgcolor="#73e2d9">
	<table class="TABLE_STYLE2" height="250">
		<tr class="TR_STYLE1">
			<td class="TD_STYLE3">
				<div id="Layer1"
					style="position:absolute; width:500px; height:77px; z-index:1; left: 620px; top: 33px; font-size: 50px; font-weight: bold; font-style: italic;">
					<span class="style9">腾 飞</span> <span class="style8">H R管理系统</span>
				</div></td>
		</tr>
	</table>
	<form method="post" action="<%=basePath%>login/login">
		<table align="center" border="10" class="TABLE_STYLE5" >
			<tr>
				<td>
					<table width="100%" border="0" bgcolor="#eebd14">
						<tr>
							<td colspan="2" align="center"><font color="#30F "><b>腾飞HR&nbsp;v2.0</b>
							</font></td>
						</tr>
						<tr class="TR_STYLE1">
							<td class="TD_STYLE3">
								<p style="line-height: 200%">
									<font color="#30F"><b>用户名:</b> </font>
							</td>
							<td><input type="text" name="userName" value=""
								style="width:150px"></td>
						</tr>
						<tr class="TR_STYLE1">
							<td class="TD_STYLE3">
								<p style="line-height: 200%">
									<font color="#30F"><b>密码:</b> </font>
							</td>
							<td><input type="password" name="userPwd" value=""
								style="width:150px"><br /> <%
										Object obj=(String)request.getAttribute("loginerrormessage");
																	if(obj!=null){
																		out.println(obj);
																	}
									 %>
							</td>
						</tr>
						<tr class="TR_STYLE1">
							<td class="TD_STYLE3">
								<p style="line-height: 200%">
									<font color="#30F "><b>验证码:</b> </font>
							</td>
							<td><input type="text" size="10" name="inputcode"
								id="inputcode" maxlength=4> <img id="imageCode"
								alt="验证码" src="image_getImgCode" onclick=""
								style="margin-left:20px;height:36px;cursor: pointer;" /></td>
						</tr>
						<tr class="TR_STYLE1">
							<td class="TD_STYLE3">
								<p style="line-height: 200%">
									<font color="#30F "><b>&nbsp;</b> </font>
							</td>
							<td align="right"></td>
						</tr>
						<tr class="TR_STYLE1">
							<td colspan="2" class="TD_STYLE3">&nbsp;</td>
						</tr>
						<tr class="TR_STYLE1">
							<td colspan="2" class="TD_STYLE3" align="center">
								<p style="line-height: 200%">
									<input type="button" value="登录" class="BUTTON_STYLE1"
										onClick="javascript:login('${pageContext.request.contextPath}');">
									<input type="button" class="BUTTON_STYLE1" value="注册"
										onClick="window.location.href='register.jsp'">
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
		<table class="TABLE_STYLE2" height="300">
			<tr class="TR_STYLE1">
				<td class="TD_STYLE3">&nbsp;</td>
			</tr>
		</table>
		<center>
			<table width="80%" height="10%" align="center">
				<tr class="TR_STYLE1">
					<td height="10%" align="center">
						<p class="testonline.style1">
							<br> <font color="# F30" size="2.5"><b>腾飞有限公司&nbsp;版权所有</b>
							</font>
					</td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>