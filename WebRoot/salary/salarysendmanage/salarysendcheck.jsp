	<%@page import="com.zking.hr.utils.DateUtil.FormatDateUtils"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Date"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/table.css" type="text/css" />
		<title>无标题文档</title>
<script type="text/javascript">
		function doEdit(id)
		{
			//document.forms[0].action = document.forms[0].action + "?operate=doEdit&method=change&id=" + id;
			document.forms[0].action = "salIssueMan!checksendstatus";
			document.forms[0].submit();
		}
		function querypayoff(organid,ssoplevel){
			var f = document.forms[0];
			f.action="salIssueMan!salarysendcheckOragan?organId="+organid+"&ssoplevel="+ssoplevel;
			f.submit();
		}
</script>
	</head>

	<body>
		<form action="salarystandard.do" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是:人力资源管理--薪酬发放管理--薪酬发放登记</font>
					</td>
				</tr>
				<tr>
					<td>
						<div align="right">
							<input type="button" value="复合" class="BUTTON_STYLE1" onclick="doEdit(1)">
							<input type="button" value="返回" onclick="history.back();" class="BUTTON_STYLE1" >
						</div>
					</td>
				</tr>
			</table> 
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">				
				<tr>
					<td class="TD_STYLE1"> 
						登记人<br></td>
					<td colspan="3" class="TD_STYLE1">登记时间<br></td>
					<td colspan="4" class="TD_STYLE1"> 
						发放总金额<br></td>
						<td colspan="4" class="TD_STYLE1"> 
						发放总人数<br></td>
						
						<td colspan="4" class="TD_STYLE1"> 
						机构一<br></td>
						<td colspan="4" class="TD_STYLE1"> 
						机构二<br></td>
						<td colspan="4" class="TD_STYLE1"> 
						机构三<br></td>
						
						
				</tr>
				<c:choose>
					<c:when test="${empty requestScope.salarypayAddlst }">
						<tr><td>${sessionScope.user.userName}</td><td colspan="6"></td></tr>
							<tr>
								<td colspan="7">薪水发放已经全部复核完毕</td>
							</tr> 
					</c:when>
					<c:otherwise>
				<tr class="TD_STYLE2">
				<c:forEach items="${requestScope.salarypayAddlst}" var="spal">
					<td>
						${spal.registerman}
						<input type="hidden" name="" value="" class="INPUT_STYLE2">
					</td>
					<td colspan="3">
						${spal.registertime}
					</td>
					<td colspan="4">
						${spal.payofftotalmoney}
					</td>					
					<td colspan="4">
						${spal.payofftotalpersonnum}
					</td>
				</c:forEach>
					<td class="TD_STYLE2" colspan="4">
						<input type="hidden" value="${requestScope.organfristId}" name="organfristId">
						<select  class="SELECT_STYLE1">
								<option selected="selected">---选择一级机构---</option>
								<c:forEach items="${requestScope.salaryorganlst}" var="sol">
									<c:choose>
										<c:when test="${sol.oraganId==requestScope.organfristId}">
											<option value="${sol.oraganId}" onclick="querypayoff(this.value,1);" selected="selected">${sol.oraganName}</option>
										</c:when>
										<c:otherwise>
											<option value="${sol.oraganId}" onclick="querypayoff(this.value,1);">${sol.oraganName}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
					</select>
					</td>
					<td class="TD_STYLE2" colspan="4">
						<input type="hidden" value="${requestScope.organsecondId}" name="organsecondId">
						<select  class="SELECT_STYLE1">
								<option value="C公司">---选择要查询的二级机构----</option>
								<c:forEach items="${requestScope.salaryorganlsttwo}" var="sol">
									<c:choose>
										<c:when test="${sol.oraganId==requestScope.organsecondId}">
											<option value="${sol.oraganId}" onclick="querypayoff(this.value,2);" selected="selected">${sol.oraganName}</option>
										</c:when>
										<c:otherwise>
											<option value="${sol.oraganId}" onclick="querypayoff(this.value,2);">${sol.oraganName}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
					</select>
					</td>
					<td class="TD_STYLE2" colspan="4">
					<input type="hidden" value="${request.organthreeId}" name="organthreeId" />
						<select  class="SELECT_STYLE1">
						<option value="C公司">---选择要查询的三级机构----</option>
						<c:forEach items="${requestScope.salaryorganlstthree}" var="sol">
							<c:choose>
								<c:when test="${request.organthreeId==sol.oraganId}">
									<option value="${sol.oraganId}" onclick="querypayoff(this.value,3);" selected="selected">${sol.oraganName}</option>
								</c:when>
								<c:otherwise>
									<option value="${sol.oraganId}" onclick="querypayoff(this.value,3);">${sol.oraganName}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
					</td>									
				</tr>		
			</table>			
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr class="TR_STYLE1">
					<td class="TD_STYLE1" colspan="4">
						已经发放酬金人员&nbsp;						
					</td>
				</tr>
					<tr>
					<c:forEach items="${requestScope.querysendchecklst}" var="slst">
							<input type="hidden" name="checkfileUserId" value="${slst.filesfilesid}"/>
						<td class="TD_STYLE2">
							<a href="salIssueMan!salarysendcheckwokrerdetails?standId=${slst.salarystanderdId}&userName=${slst.filesUserName}">${slst.filesUserName}</a>
						</td>
					</c:forEach>
					</tr>
						</c:otherwise>
				</c:choose>
			</table>				
		</form>
	</body>
</html>
