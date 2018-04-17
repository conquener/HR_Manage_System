<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<script type="text/javascript">
		function checkPage(){
			var index =$("#selectPage").val();
			if(!/^[0-9.-]*$/.test(index)){
				$("#selectPage").val('${page.indexPage}');
				alert('请输入数字!');
			}else if(Number(index)<1){
				$("#selectPage").val('${page.indexPage}');
				alert('页码必须大于1!');
			}else if(Number(index)>${page.countPage}){
				$("#selectPage").val('${page.indexPage}');
				alert('页码必须小于最大页码!');
			}
		}
		
		function pagesubmit(){
			var index = $("#selectPage").val();
			$("#form1").attr("action","<%=basePath%>salIssueMan!salarysendqueryresult?indexPage="+index);
			$("#form1").submit();
		}
	</script>
		<title>无标题文档</title>
		<style type="text/css">
<!--
.style3 {color: #0000CC}
-->
</style>
	</head>

	<body>
		<form method="post" action="salarystandard.do">
			<table width="100%">
				<tr>
					<td>
					<input type="hidden" name="salarysendAddId"  value="salaryQuery.salarysendAddId"/>
					<input type="hidden" name="salarySendOrganName"  value="salaryQuery.salarySendOrganName"/>
					<input type="hidden" name="salarysendstartTime"  value="salaryQuery.salarysendstartTime"/>
					<input type="hidden" name="salarysendendTime"  value="salaryQuery.salarysendendTime"/>
						<font color="#0000CC">您正在做的业务是:人力资源管理--薪酬标准管理--薪酬标准登记变更</font>
					</td>
				</tr>
				<tr>
					<td>&nbsp;
						
					</td>
				</tr>
				<tr>
					<td>
						符合条件的薪酬标准总数:
						${page.countRows}
						例
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="4%" class="TD_STYLE1" align="center">
						<span>序号</span>
					</td>
					
					<td width="8%" class="TD_STYLE1" align="center">
						<span>员工编号</span>
					</td>
					<td width="12%" class="TD_STYLE1" align="center">
						<span>姓名</span>
					</td>
					<td width="11%" class="TD_STYLE1" align="center">
						<span>所属部门</span>
					</td>
					<td  class="TD_STYLE1">
						<span>薪酬项目列表:</span>
					</td>
				</tr>
				<c:choose>
					<c:when test="${not empty salarysendquerymap}">
					<c:forEach items="${requestScope.salarysendquerymap }" var="s" varStatus="i">
						<tr class="TD_STYLE2">
							<td align="center">${i.index+1}</td>
							<td align="center">${s.filesuserid}</td>
								<td align="center">${s.filesuserName}</td>
								<td align="center">${s.oraganname}</td>
								<td>
								<table width="100%" border="1" cellpadding=0 cellspacing=1
										bordercolorlight=#848284 bordercolordark=#eeeeee
										class="TABLE_STYLE1">
									<tr><td>薪酬项目名</td><td>金额</td></tr>
									<c:choose>
										<c:when test="${i.index==0}">
											<c:forEach items="${requestScope.stand0}" var="stand">
												<tr><td>${stand.salaryprojectName}</td>
												<td>Money:${stand.salaryprojectMoney}</td></tr>
											</c:forEach>
										</c:when>
										<c:when test="${i.index==1}">
											<c:forEach items="${requestScope.stand1}" var="stand">
												<tr><td>${stand.salaryprojectName}</td>
												<td>Money:${stand.salaryprojectMoney}</td></tr>
											</c:forEach>
										</c:when>
										<c:when test="${i.index==2}">
											<c:forEach items="${requestScope.stand2}" var="stand">
												<tr><td>${stand.salaryprojectName}</td>
												<td>Money:${stand.salaryprojectMoney}</td></tr>
											</c:forEach>
										</c:when>
										<c:when test="${i.index==3}">
											<c:forEach items="${requestScope.stand3}" var="stand">
												<tr><td>${stand.salaryprojectName}</td>
												<td>Money:${stand.salaryprojectMoney}</td></tr>
											</c:forEach>
										</c:when>
										<c:when test="${i.index==4}">
											<c:forEach items="${requestScope.stand4}" var="stand">
												<tr><td>${stand.salaryprojectName}</td>
												<td>Money:${stand.salaryprojectMoney}</td></tr>
											</c:forEach>
										</c:when>
											<c:otherwise>
												<tr><td>${stand.salaryprojectName}</td>
												<td>Money:${stand.salaryprojectMoney}</td></tr>
											</c:otherwise>
									</c:choose>
								</table>
							<td>
							</tr>
						</c:forEach>
						</c:when>
					<c:otherwise>
					<tr><td colspan="5">
						没有查到符合条件的数据!
					</td></tr>
					</c:otherwise>
				</c:choose>
			</table>
			<p>&nbsp;&nbsp;总数：${page.countRows}例 &nbsp;&nbsp;&nbsp;当前第 1 页  &nbsp;&nbsp;&nbsp;共 1 页  &nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 id="selectPage" onchange="checkPage()" size=1> 页&nbsp;&nbsp;<input type=image src="images/go.bmp" onclick="pagesubmit()" width=18 height=18 border=0>
		</form>
	</body>
</html>
