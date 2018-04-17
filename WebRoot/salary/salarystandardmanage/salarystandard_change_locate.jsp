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
		<link rel="stylesheet" type="text/css" media="all"
			href="<%=basePath %>javascript/calendar/calendar-win2k-cold-1.css">
		<script type="text/javascript" src="<%=basePath %>javascript/calendar/cal.js"></script>
		<script language="javascript" type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
		<script language="javascript" type="text/javascript" src="<%=basePath%>My97DatePicker/calendar.js"></script>
		<link href="<%=basePath%>My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.7.2.min.js"></script>
		<title>无标题文档</title>
	</head>

	<body>
		<form method="post" action="salaryStandManage!salarystandardchangresult">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是:人力资源管理--薪酬标准管理--薪酬标准查询</font>
					</td>
				</tr>
				<tr>
					<td>
						<div align="right">
							<input type="submit" value="开始" class="BUTTON_STYLE1">
						</div>
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="20%" class="TD_STYLE1">
						请输入薪酬标准编号
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="salarystandcheckId" value="" class="INPUT_STYLE1">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						请输入关键字
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="standName" class="INPUT_STYLE1">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						请输入登记时间
					</td>
					<td class="TD_STYLE2">
						<input type="text"  onclick="WdatePicker();" name="startTime" value="" class="INPUT_STYLE1" id="date_start">
						至
						<input type="text"  onclick="WdatePicker();" name="endTime" value="" class="INPUT_STYLE1" id="date_end">
						(YYYY-MM-DD)
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
