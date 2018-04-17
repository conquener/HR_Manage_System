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
		<link rel="stylesheet" href="<%=basePath%>table.css" type="text/css" />
		<title>薪酬标准</title>
		<script type="text/javascript">
		function doEdit(id)
		{
			//document.forms[0].action = document.forms[0].action + "?operate=doEdit&method=change&id=" + id;
			document.forms[0].action = "salary/salarystandardmanage/salarystandard_register_checksuccess	.jsp";
			document.forms[0].submit();
		}
	
		</script>
	</head>

	<body>
		<form action="salarystandard.do" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是:人力资源管理--薪酬标准管理--薪酬标准登记--公司人员薪酬概述--个人薪酬详细概述</font>
					</td>
				</tr>
				<tr>
					<td>
						<div align="right">
							<input type="button" value="确定" class="BUTTON_STYLE1" onclick="doEdit(1)">
							<input type="button" value="返回" onclick="history.back();" class="BUTTON_STYLE1" >
						</div>
					</td>
				</tr>
			</table>
					${userName}员工的薪水详细${requestScope.stand.salarystanderdName}
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				
				<tr>
					<td class="TD_STYLE1">
						序号
					</td>
					<td colspan="3" class="TD_STYLE1">
						薪酬项目名称
					</td>
					<td colspan="4" class="TD_STYLE1">
						金额
					</td>
				</tr>
				
				<c:forEach items="${requestScope.standproject}" var="standp" varStatus="i">
				<tr class="TD_STYLE2">
					<td>
						${i.index+1}
					</td>
					<td colspan="3">
						${standp.salaryprojectName}
					</td>
					<td colspan="4">
						${standp.salaryprojectMoney}
					</td>
				</tr>
				</c:forEach>
			</table>
		</form>
	</body>
</html>
