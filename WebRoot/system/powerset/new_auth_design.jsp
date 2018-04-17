<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/table.css" type="text/css">
		<script type="text/javascript" src="<%=basePath %>javascript/comm/comm.js"></script>
		
<script type="text/javascript">
	function pageSubmit(indexPage){
		var form1 = document.forms[0];
		form1.action="systemManage!newauthdesignquery?queryroleAndPremissindexPage="+indexPage;
		form1.submit();				
		}
		
		function rolepermissindexpage(){
		var rolepermissindexpage = document.getElementById("rolepermissindexpage").value;
		var countPage = document.getElementById("countPage").value;
		var form1 = document.forms[0];
		if(rolepermissindexpage==null||rolepermissindexpage==""){
			alert("请输入页码!");
		}else if(rolepermissindexpage>countPage){
			alert("输入页码超出范围!");
		}else{
			form1.action="systemManage!newauthdesignquery?queryroleAndPremissindexPage="+indexPage;
			form1.submit();				
		}
		}
</script>
	</head>

	<body >
		<form method="post" action="">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
				<td width="22%" class="TD_STYLE1">
						编号
					</td>
					<td width="22%" class="TD_STYLE1">
						角色名称
					</td>
					<td width="26%" class="TD_STYLE1">
						权限名称
					</td>
					<td width="5%" class="TD_STYLE1">
						修改
					 </td>
					<td width="5%" class="TD_STYLE1">
						删除
					</td>
				</tr>
				<c:forEach items="${requestScope.rolepermisslst}" var="rp">
					<tr>
					<td width="22%" class="TD_STYLE1">
						${rp.rolepermisssionId}
					</td>
						<td class="TD_STYLE2">
						<input type="hidden" name="" value="${rp.roleId}" /> 
							${rp.roleName}
						</td>
						<td class="TD_STYLE2">
						<input type="hidden" name="" value="${rp.permisssionalId }"/>
							${rp.permisssionalName}
						</td>
						<td width="5%" class="TD_STYLE2">
						<a href="<%=basePath%>system/powerset/new_authodesign_update.jsp?permissName=${rp.permisssionalName}&roleName=${rp.roleName}&rolepermissId=${rp.rolepermisssionId}&roleId=${rp.roleId}&permissId=${rp.permisssionalId}">修改</a>
					    </td>
					    <td width="5%" class="TD_STYLE2">
						<a href="<%=basePath%>systemManage!authdesigndelete?rolepermissId=${rp.rolepermisssionId}">删除</a>
					    </td>
					</tr>
					<tr>
				</c:forEach>
			</table>
			<input type="hidden" id="countPage" value=" ${requestScope.rolepermisspage.countPage}"/>
			<p>&nbsp;&nbsp;总数：${requestScope.rolepermisspage.countRows}例 &nbsp;&nbsp;&nbsp;当前第${requestScope.queryroleAndPremissindexPage} 页  &nbsp;&nbsp;&nbsp;共 ${requestScope.rolepermisspage.countPage} 页  &nbsp;&nbsp;&nbsp;
	<c:choose>
													<c:when test="${requestScope.rolepermisspage.indexPage == 1 }">
													首页
													</c:when>
													<c:otherwise>
														<a href="javascript:onclick=pageSubmit(1)">
														首页 
														</a>
													</c:otherwise>
												</c:choose>
												| 
												<c:choose>
													<c:when test="${parequestScope.rolepermisspagege.indexPage == 1}">
													上一页
													</c:when>
													<c:otherwise>
														<a href="javascript:onclick=pageSubmit(${requestScope.rolepermisspage.indexPage - 1 })">
															上一页
														</a> 	
													</c:otherwise>
												</c:choose>
												
												| 
												<c:choose>
													<c:when test="${requestScope.rolepermisspage.indexPage == requestScope.rolepermisspage.countPage}">
														下一页
													</c:when>
													<c:otherwise>
														<a href="javascript:onclick=pageSubmit(${requestScope.rolepermisspage.indexPage + 1})">
														下一页
														</a>	
													</c:otherwise>
												</c:choose>
												 | 
												 <c:choose>
													<c:when test="${requestScope.rolepermisspage.indexPage == requestScope.rolepermisspage.countPage }">
														尾页
													</c:when>
													<c:otherwise>
														<a href="javascript:onclick=pageSubmit(${requestScope.rolepermisspage.countPage })">
															尾页
														</a>	
													</c:otherwise>
												</c:choose>
			跳到第 <input name="" id="rolepermissindexpage" type="text" class="input1" size="1"> 页&nbsp;&nbsp;<input type="image" src="<%=basePath %>images/go.bmp" width="18" height="18" border="0" onclick="queryonsubmit();">
		</form>
	</body>
</html>


