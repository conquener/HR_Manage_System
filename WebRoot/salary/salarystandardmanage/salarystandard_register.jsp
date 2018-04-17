<%@page import="com.zking.hr.pojo.TSalaryproject"%>
<%@ page import="com.zking.hr.utils.DateUtil.FormatDateUtils"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date"%>
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
		<script type="text/javascript" src="<%=basePath %>javascript/comm/comm.js"></script>
		<title>薪酬标准登记</title>
		<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" language="javascript">
		function calcol(){
			<% List<TSalaryproject> lst = (List<TSalaryproject>)request.getAttribute("tp");%>
			var tplst = <%=lst.size()%>;
			var salaryTotal =0;
			for(var i=1;i<=tplst;i++){
				var salary = document.getElementById("salary"+i).value;
				if(salary!=null&&salary!=""){
					salaryTotal += parseInt(salary, 10);
				}
			}
			var calcolmoney= document.getElementById("calcolmoney");
			calcolmoney.innerHTML = salaryTotal;
			$("#hideCalcolmoney").val(salaryTotal);
		}
		
</script>
	</head>

	<body>
		<form name="salarystandardForm" method="post" action="salaryStandManage!salaryStandManageregister">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--薪酬标准管理--薪酬标准登记
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="submit" value="提交"  class="BUTTON_STYLE1">
						<input type="reset" value="清除" class="BUTTON_STYLE1" >
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding='0' cellspacing='1'
				bordercolorlight='#848284' bordercolordark='#eeeeee'
				class="TABLE_STYLE1">
				<tr>
					<td width="74" class="TD_STYLE1">
						薪酬标准编号
					</td>
					<td width="168" class="TD_STYLE2">
						<input type="text" name="standardId" value="1000001" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td width="83" class="TD_STYLE1">
						薪酬标准名称
					</td>
					<td width="171" class="TD_STYLE2">
						<input type="text" name="t1.salarystanderdName" value="" class="INPUT_STYLE2">
					</td>
					<td width="170" class="TD_STYLE1">
						薪酬总额
					<input type="hidden" name="t1.salarySummoney" id="hideCalcolmoney" value="0"/>
					</td>
					<td width="138" class="TD_STYLE2" id="calcolmoney">
						&nbsp;
					</td>
					<td width="103" class="TD_STYLE1">
						&nbsp;
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						制定人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="t1.maker" value="${session.user.userName}" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						登记人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="t1.register" value="${session.user.userName}" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						登记时间
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="t1.registertime" value="<fmt:formatDate value='<%=new java.util.Date() %>' pattern='YYYY-MM-dd'/>" readonly="readonly" class="INPUT_STYLE2">
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
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="t1.remark" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr class="TD_STYLE1">
					<td align="center">
						序号
					</td>
					<td colspan="3">
						薪酬项目名称
					</td>
					<td>
						金额
					</td>
					<td colspan="3">
						&nbsp;
					</td>
				</tr>
				<c:forEach items="${tp}" var="tpitem" varStatus="index">
					<tr class="TD_STYLE2">
						<td align="center">${index.index+1}<input type="hidden" name="salarystandProjectId" value="${tpitem.salaryprojectId}"></td>
						<td colspan="3">${tpitem.salaryprojectName}<input type="hidden" name="salarystandProjectName" value="${tpitem.salaryprojectName}"></td>
						<td>
						<input type="text" id="salary${index.index+1}" name="salarystandProjectMoney" value="" onblur="calcol();" class="INPUT_STYLE2">
						</td>
						<td colspan="3">
						&nbsp;
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
