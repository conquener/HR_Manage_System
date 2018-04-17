<%@page import="com.zking.hr.pojo.TSalaryproject"%>
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
		<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.7.2.min.js"></script>
		<title>薪酬标准登记</title>
		<script type="text/javascript">
		function doEdit(id)
		{
			document.forms[0].action ="salaryStandManage!salarystandardupdatesuccess";
			$("#form1").attr("action","<%=basePath%>salaryStandManage!salarystandardupdatesuccess")
			document.forms[0].submit();
		}
		
		function calcol(){
			<% List<TSalaryproject> lst = (List<TSalaryproject>)request.getAttribute("standProjectlist");%>
			var tplst = <%=lst.size()%>;
			var salaryTotal =0;
			for(var i=1;i<=tplst;i++){
				var salary = $("#salary"+i).val();
				if(!/^[0-9.-]*$/.test(salary)){
					alert('修改的薪酬格式不正确!');
					$("#salary"+i).val(0);
					salary=0;
				}
				if(salary!=null&&salary!=""){
					salaryTotal += Number(salary);
				}
			}
			$("#calcolmoney").val(salaryTotal);
		}
		
		</script>
	</head>

	<body>
		<form action="salarystandard.do" method="post" id="form1">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是:人力资源管理--薪酬发放管理--薪酬薪酬发放查询</font>
					</td>
				</tr>
				<tr>
					<td>
						<div align="right">
							<input type="button" value="确认更改" class="BUTTON_STYLE1" onclick="doEdit();">
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
						<input type="hidden" name="t1.salarystanderdId" value="${requestScope.salarystanderd.salarystanderdId}"/>
						${requestScope.salarystanderd.salarystanderdId}
					</td>
					<td width="12%" class="TD_STYLE1">
						薪酬标准名称
					</td>
					<td width="11%" class="TD_STYLE2">
					<input type="text" class="INPUT_STYLE2" value="${requestScope.salarystanderd.salarystanderdName}" name="t1.salarystanderdName" />
					</td>
					<td width="11%" class="TD_STYLE1">
						薪酬总额
					</td>
					<td width="17%" class="TD_STYLE2">
					<input type="text" class="INPUT_STYLE2" id="calcolmoney" value="${requestScope.salarystanderd.salarySummoney}" name="t1.salarySummoney" />
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
						更改人
					</td>
					<td class="TD_STYLE2">
						<input value="${session.user.userName}" class="INPUT_STYLE2" name="t1.register"/>
					</td>
					<%Date d = new Date();
					String d1 = FormatDateUtils.format("yyyy-MM-dd",d);
					 %>
					<td class="TD_STYLE1">
						更改时间
					</td>
					<td class="TD_STYLE2">
					<input type="text" value="<%=d1%>" class="INPUT_STYLE2" name="t1.registertime" />
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
						更改意见
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="checkComment" rows="4" class="TEXTAREA_STYLE1"></textarea>
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
				
				<c:forEach items="${requestScope.standProjectlist}" var="s" varStatus="index">
					<tr class="TD_STYLE2">
						<td>
							${index.index+1}
						</td>
						<td colspan="3">
							<input type="hidden" name="salarystandProjectId"  value="${s.salaryprojectId}">
							<input type="hidden" name="salarystandProjectName"  value="${s.salaryprojectName}">
							${s.salaryprojectName}
						</td>
						<td colspan="4">
							<input id="salary${index.index+1}" onchange="calcol();" value="${s.salaryprojectMoney}" name="salarystandProjectMoney"/>
						</td>
						<td>&nbsp;</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</body>
</html>
