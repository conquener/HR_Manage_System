<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link rel="stylesheet" href="<%=basePath %>table.css" type="text/css">
		<link rel="stylesheet" type="text/css" media="all"
			href="<%=basePath %>javascript/calendar/calendar-win2k-cold-1.css">
		<script type="text/javascript" src="<%=basePath %>javascript/calendar/cal.js"></script>
		<script type="text/javascript" src="<%=basePath %>javascript/comm/comm.js"></script>
		<script language="javascript" src="<%=basePath %>javascript/winopen/winopenm.js"></script>
				<script language="javascript" type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
		<script language="javascript" type="text/javascript" src="<%=basePath%>My97DatePicker/calendar.js"></script>
		<link href="<%=basePath%>My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css">
		<style type="text/css">
			.inputcss{
				width: 20%;
			}
		
		</style>
	</head>
	<body>
			<form name="humanfileForm" method="post" action="updSalaryPay!updateSalaryPay">
			<font color="#0000CC">您正在做的业务是：人力资源--客户化设置--薪酬管理设置--薪酬发放方式添加
			</font><hr>
				<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="15%" class="TD_STYLE1">
						<input name=ts.salarypayoffId value="${salaryPay[0].salarypayoffId}" type="hidden" />
						请输入新的薪酬发放方式：
					</td>
					<td  class="TD_STYLE1">
						<input name="ts.salarypayoffName" value="${salaryPay[0].salarypayoffName}" type="text">
					</td>	
				</tr>
				<tr>
					<td  class="TD_STYLE1">
						请输入薪酬发放比例：
					</td>
					<td  class="TD_STYLE1">
						<input name="ts.remark" value="${salaryPay[0].remark}" type="text">
					</td>	
				</tr>
				<tr>
					<td  class="TD_STYLE1">
						请输入薪酬发放开始时间：
					</td>	
					<td  class="TD_STYLE1">
						<input  id="date_start" type="text" value="${salaryPay[0].salaryBegintime}" readonly="readonly" name="ts.salaryBegintime"  onclick="WdatePicker();" />
					</td>

				</tr>
				<tr>
					<td  class="TD_STYLE1">
						请输入薪酬发放结束时间：
					</td>	
					<td  class="TD_STYLE1">
						<input  id="date_end" type="text" value="${salaryPay[0].salaryEndtime}" readonly="readonly" name="ts.salaryEndtime"  onclick="WdatePicker();" />
					</td>	
				</tr>
				<tr>
					<td colspan="2" class="TD_STYLE1">
						&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="submit" value="确定">&nbsp;&nbsp;
						<input name="" type="button" value="返回"  onclick="history.back();">
					</td>
				</tr>
				</table>
			</form>

	</body>

</html>