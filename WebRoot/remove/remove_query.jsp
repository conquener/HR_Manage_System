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
		<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.7.2.min.js"></script>
		<script language="javascript" type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
		<script language="javascript" type="text/javascript" src="<%=basePath%>My97DatePicker/calendar.js"></script>
		<link href="<%=basePath%>My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function formSubmit(){
		form1.action="<%=basePath%>tranmamage!stafftranquery";
		form1.submit();
	}
				
</script>
	</head>
<body>
<form name="humanfileForm" method="post" action="" id="form1">
			<table width="100%">
			<tr><td>
						<font color="#0000CC">您正在做的业务是：人力资源--调动管理--调动查询 </font><br/>
						调动人姓名:
						<input type="text" name="tranPerosonName" >
						调动时间:
						<input type="text"  onclick="WdatePicker();" name="begintrantime" value="" style="width:14% " class="INPUT_STYLE2" id="date_start">
						至
						<input type="text"  onclick="WdatePicker();" name="endtrantime" value="" style="width:14% " class="INPUT_STYLE2" id="date_end">
						（YYYY-MM-DD）
						<input type="button" value="查询" class="BUTTON_STYLE1"
							onclick="formSubmit();">
				</td></tr>
			</table>
</form>
</body>
</html>
