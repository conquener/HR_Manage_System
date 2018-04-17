<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
						<font color="#0000CC">您正在做的业务是：人力资源--客户化设置--薪酬管理设置--订单销售绩效计算方式设置
						</font>
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE2">
						如果销售总金额小于目标金额1，那么采用零售绩效计算方式  
					</td>						
				</tr>
				<tr>
					<td class="TD_STYLE2">
						如果销售总金额大于目标金额1但小于目标金额2，薪酬提成=销售总额*提成百分比1 
					</td>						
				</tr>
				<tr>
					<td class="TD_STYLE2">
						如果销售总金额大于目标金额2，薪酬提成=目标金额2*提成百分比1+（销售总额-目标金额2）*提成百分比2 <hr>
					</td>						
				</tr>
								
				</tr>
				<c:forEach items="${orderP}" var="o" end="${orderPSize-1}" >
				<tr>
					<td  class="TD_STYLE1">
						目标金额${o.opPerformanceid}：${o.opGoalMoney}
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE2" colspan="2">
						提成百分比${o.opPerformanceid}：${o.opDrawapercent}&nbsp;%
						<a href="LoadOrderPerUpd!queryOrderPer?orderId=${o.opPerformanceid}">修改</a>
					</td>
				</tr>
				
				</c:forEach>
			</table>
		</form>

	</body>
</html>