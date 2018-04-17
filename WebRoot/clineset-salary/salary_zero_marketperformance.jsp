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
			<form method="post" action="configmajorkind.do">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--客户化设置--薪酬管理设置--零售绩效计算方式设置
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="修改" class="BUTTON_STYLE1"  onclick="window.location.href='salary_zero_marketperformance_change.html'">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE2">
						薪酬提成=销售总金额X零售绩效提成百分比
					</td>						
				</tr>	
				<tr>
					<td class="TD_STYLE2">
						零售绩效提成百分比：0.1%
					</td>						
				</tr>	
			</table>
		</form>

	</body>
</html>