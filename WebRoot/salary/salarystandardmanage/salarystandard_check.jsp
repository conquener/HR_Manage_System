<%@ page import="com.zking.hr.utils.DateUtil.FormatDateUtils"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="<%=basePath %>table.css" type="text/css" />
		<title>无标题文档</title>
		<script type="text/javascript">
		function doEdit(id)
		{
			//document.forms[0].action = document.forms[0].action + "?operate=doEdit&method=check&id=" + id;
			document.forms[0].action ="salaryStandManage!salarystandardchecksuccess";
			document.forms[0].submit();
		}
		</script>
	</head>

	<body>
		<form action="salarystandard.do" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是:人力资源管理--薪酬标准管理--薪酬标准登记复核</font>
					</td>
				</tr>
				<tr>
					<td>
						<div align="right">
							<input type="button" value="复核通过" class="BUTTON_STYLE1" onclick="doEdit(1);">
							<input type="button" value="返回" onclick="history.back();" class="BUTTON_STYLE1">
						</div>
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="12%" class="TD_STYLE1">
						薪酬编号
					</td>
					<td width="15%" class="TD_STYLE2">
						<input type="hidden" name="salarystandcheckId" value="${requestScope.salarystanderd.salarystanderdId}"/>
						${requestScope.salarystanderd.salarystanderdId}
					</td>
					<td width="12%" class="TD_STYLE1">
						薪酬标准名称
					</td>
					<td width="11%" class="TD_STYLE2">
						${requestScope.salarystanderd.salarystanderdName}
					</td>
					<td width="11%" class="TD_STYLE1">
						薪酬总额
					</td>
					<td width="17%" class="TD_STYLE2">
						${requestScope.salarystanderd.salarySummoney}
					</td>
					<td width="12%" class="TD_STYLE1">
						&nbsp;
					</td>
					<td width="10%" class="TD_STYLE2">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						制定人
					</td>
					<td class="TD_STYLE2">
						${requestScope.salarystanderd.maker}
					</td>
					<td class="TD_STYLE1">
						复核人
					</td>
					<td class="TD_STYLE2">
						${session.user.userName}
					</td>
					<%Date d = new Date();
					String d1 = FormatDateUtils.format("yyyy-MM-dd",d);
					 %>
					<td class="TD_STYLE1">
						复核时间
					</td>
					<td class="TD_STYLE2">
						<%=d1%>
					</td>
					<td class="TD_STYLE1">
						&nbsp;
					</td>
					<td class="TD_STYLE2">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						复核意见
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="checkComment" rows="10" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
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
				
				<c:forEach items="${requestScope.standProjectlist}" var="s">
				<tr class="TD_STYLE2">
					<td align="center">
						${s.salaryprojectId}
					</td>
					<td colspan="3">
						${s.salaryprojectName}
					</td>
					<td>
						${s.salaryprojectMoney}
					</td>
					<td>&nbsp;</td>
				</tr>
				</c:forEach>
			</table>
		</form>
	</body>
</html>
