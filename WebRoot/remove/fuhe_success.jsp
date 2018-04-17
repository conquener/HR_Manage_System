<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="<%=basePath %>table.css" type="text/css">
		<link rel="stylesheet" type="text/css" media="all"
			href="<%=basePath %>javascript/calendar/calendar-win2k-cold-1.css">
		<script type="text/javascript">

 		</script>
	</head>

	<body>
		<form name="humanfileForm" method="post" action="">
			<table width="100%">
				<tr>
					<td colspan="2">
						<font color="#0000CC">您正在做的业务是：人力资源--调动管理--调动复核 </font>
					</td>
				</tr>
				<tr>
					<td>
						复核已通过！
					</td>
					<td align="right">
						<a href="tranmamage!removeregisterfuhequery">返回</a>					
					</td>
				</tr>
			</table></form>
</body>
</html>
