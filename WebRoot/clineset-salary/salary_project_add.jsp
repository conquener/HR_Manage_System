<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="<%=basePath %>table.css" type="text/css">
	</head>
	<body>
			<form method="post" action="salaryProIns!insertSalaryPro">
			<font color="#0000CC">您正在做的业务是：人力资源--客户化设置--薪酬管理设置--薪酬项目添加
			</font><hr>
				<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td  class="TD_STYLE1">
						请输入需要增加的薪酬项目名称：<input name="ts.salaryprojectName" type="txt">
					</td>	
				</tr>
				<tr>
					<td>
						<input name="" type="submit" value="确定">
						<input name="" type="button" value="返回"  onclick="history.back();">
					</td>
				</tr>
				</table>
			</form>
	</body>
</html>