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
		<link rel="stylesheet" href="<%=basePath %>table.css" type="text/css" />
		<script type="text/javascript" src="<%=basePath %>javascript/comm/comm.js"></script>
		<title>无标题文档</title>
	</head>

	<body>
		<form name="salarystandardForm" method="post" action="/hr/salarystandard.do">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--薪酬标准管理--薪酬项目
						</font>
					</td>
				</tr>
				<tr>
					
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr><td colspan="3" align="right"><input type="button" value="返回" onclick="history.back();" class="BUTTON_STYLE1" ></td></tr>
				<tr class="TD_STYLE1">
					<td align="center" width="20%">
						序号
					</td>
					<td width="30%">
						薪酬项目
					</td>
					<td width="30%">
						金额
					</td>
				
				</tr>
				<c:forEach items="${requestScope.salaryprojectlst}" var="s">
					<tr class="TD_STYLE2">
						<td align="center">
							${s.salaryprojectId}
						</td>
						<td>
							${s.salaryprojectName}
						</td>
						<td>
							${s.salaryprojectMoney}
						</td>
					</tr>
				</c:forEach>
			</table>
			<p>
				&nbsp;
			</p>
		</form>
	</body>
</html>