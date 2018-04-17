<%@page import="com.zking.hr.utils.DateUtil.FormatDateUtils"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Date"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/table.css" type="text/css" />
		<title>薪酬发放</title>
		<script type="text/javascript">
		function doEdit(id,path)
		{	
			var checkAll = document.getElementsByName("salarychecked");
			var a=false;
			var b=0;
			for(var i=0;i<checkAll.length;i++){
				if(checkAll[i].checked == true){
					a=true;
					b++;
				}
			}
			
			if(a){
				document.forms[0].action ="salIssueMan!salarysendRegister";
				document.forms[0].submit();
			}else{
				alert("请选择要发放薪酬的人员!");
			}
		}
		function mannumcheck(){   
			var checkAll = document.getElementsByName("salarychecked");
			var b=0;
			for(var i=0;i<checkAll.length;i++){
				if(checkAll[i].checked == true){
					b++;
				}
			}	
			var m = document.getElementById("mannum");
			var s = document.getElementById("money");
			var si =document.getElementById("moneyInput");
			var mi = document.getElementById("mannumInput");
			si.value=b;
			mi.value= 7000*b;
			m.innerHTML = b;
			s.innerHTML = 7000*b;	
		}		
		function querypayoff(organid,ssoplevel){
			var f = document.forms[0];
			f.action="<%=basePath%>salIssueMan!salarysendOrganId?organId="+organid+"&ssoplevel="+ssoplevel;
			f.submit();
		}
		
		function selAll(){
			var checkAll = document.getElementsByName("salarychecked");
			var choice = document.getElementById("choice");
			for(var i=0;i<checkAll.length;i++){
				checkAll[i].checked = choice.checked;
			}
			var m = document.getElementById("mannum");
			var s = document.getElementById("money");
			m.innerHTML = checkAll.length;
			s.innerHTML = 7000*(checkAll.length);
			var si =document.getElementById("moneyInput");
			var mi = document.getElementById("mannumInput");
			si.value=b;
			mi.value=7000*b;				
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
							<input type="button" value="提交信息" class="BUTTON_STYLE1" onclick="doEdit(1,'${pageContext.request.contextPath}')">
							<input type="button" value="返回" onclick="history.back();" class="BUTTON_STYLE1" >
						</div>
					</td>
				</tr>
			</table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 薪酬发放记录 
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
				<%Date d = new Date();
					String d1 = FormatDateUtils.format("yyyy-MM-dd",d);
				%>
				<tr class="TD_STYLE2">
				<input type="hidden" name="tpayoffadd.registerman" value="${session.user.userName}">
					<td>
						${session.user.userName}
					</td>
					<td colspan="3">
						<input type="text" name="tpayoffadd.registertime" value="<%out.println(d1);%>"/>
					<input type="hidden" id="mannumInput" name="tpayoffadd.payofftotalpersonnum" value="">
					<input type="hidden" id="moneyInput" name="tpayoffadd.payofftotalmoney" value="">
					</td>
					<td colspan="4" id="money" name="totalmoney">
						0.0
					</td>
					<td colspan="4" id="mannum" name="mannum"></td>
					<td class="TD_STYLE2" colspan="4">
						<input type="hidden" value="${requestScope.organfristId}" name="organfristId">
						<select  class="SELECT_STYLE1" onchange="querypayoff(this.value,1);">
								<option selected="selected" value="-1">---选择一级机构---</option>
								<c:forEach items="${requestScope.salaryorganlst}" var="sol">
									<c:choose>
										<c:when test="${sol.oraganId==requestScope.organfristId}">
											<option value="${sol.oraganId}"  selected="selected">${sol.oraganName}</option>
										</c:when>
										<c:otherwise>
											<option value="${sol.oraganId}" >${sol.oraganName}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
					</select>
					</td>
					<td class="TD_STYLE2" colspan="4">
						<input type="hidden" value="${requestScope.organsecondId}" name="organsecondId">
						<select  class="SELECT_STYLE1" onchange="querypayoff(this.value,2);">
								<option value="-1">---选择要查询的二级机构----</option>
								<c:forEach items="${requestScope.salaryorganlsttwo}" var="sol">
									<c:choose>
										<c:when test="${sol.oraganId==requestScope.organsecondId}">
											<option value="${sol.oraganId}"  selected="selected">${sol.oraganName}</option>
										</c:when>
										<c:otherwise>
											<option value="${sol.oraganId}">${sol.oraganName}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
					</select>
					</td>
					<td class="TD_STYLE2" colspan="4">
					<input type="hidden" value="${request.organthreeId}" name="organthreeId" />
						<select  onChange="querypayoff(this.value,3);" class="SELECT_STYLE1">
						<option value="-1">---选择要查询的三级机构----</option>
						<c:forEach items="${requestScope.salaryorganlstthree}" var="sol">
							<c:choose>
								<c:when test="${request.organthreeId==sol.oraganId}">
									<option value="${sol.oraganId}" selected="selected">${sol.oraganName}</option>
								</c:when>
								<c:otherwise>
									<option value="${sol.oraganId}">${sol.oraganName}</option>
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
						选择发放酬金人员&nbsp;
						<input type="checkbox" name="choice" id="choice" value="全选"
							class="BUTTON_STYLE1" onclick="selAll(this.form)">
					</td>
				</tr>
					<tr>
					<c:forEach items="${requestScope.salarysendman}" var="lst">
						<td class="TD_STYLE2">
							<input type="checkbox" name="salarychecked" value="${lst.filesfilesid}" onclick="mannumcheck();"/><a href="salIssueMan!salarysendtoworkerdetails?standId=${lst.salarystanderdId}&userName=${lst.filesUserName}">${lst.filesUserName}</a>
						</td>
					</c:forEach>
					</tr>					
					
				</table>	
		</form>
	</body>
</html>