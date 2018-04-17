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
		<link rel="stylesheet" href="<%=basePath %>table.css" type="text/css">
		<script type="text/javascript">
function toCheck()
{
	document.forms[0].action = "systemManage!rolecheckquery";
	document.forms[0].submit();
}
</script>
	</head>

	<body>
		<form name="humanfileForm" method="post" action="" id="form1">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：角色设置--角色设置管理--用户角色查询 </font>
					</td>
					<td>
					</td>
					<tr>
					<td>
						当前用户总数：
						${requestScope.rolesetselectpage.countRows}
						例
					</td>
				</tr>
				</tr>
				
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr class="TR_STYLE1">
				<td width="10%" class="TD_STYLE1">
						编号
					</td>
					<td width="10%" class="TD_STYLE1">
						用户
					</td>	
					<td width="10%" class="TD_STYLE1">
						角色
					</td>
					<td colspan="2" width="10%" class="TD_STYLE1" align="center">
						操作
					</td>
					
					<td width="7%" class="TD_STYLE1" align="center">
						复核状态
					</td>
				</tr>
					<c:forEach items="${requestScope.rolesetselectlst}" var="u">
					<tr>
					<td  class="TD_STYLE1">
						${u.userId}
					</td>
						<td class="TD_STYLE2">
							${u.userName}
						</td>
						
						<td class="TD_STYLE2">
							${u.userRoleName}
						</td>
						<td class="TD_STYLE2" align="center">
							<a href="systemManage!rolesetdeletequery?systemuserId=${u.userId}">删除</a>
						</td>
						<td class="TD_STYLE2" align="center">
							<a href="./system/roleset/roleset_update.jsp?userName=${u.userName}&systemuserId=${u.userId}">修改</a>
						</td>
						
						<td class="TD_STYLE2" align="center">
							<a href="systemManage!rolesetcheckquery?systemuserId=${u.userId}">复核</a>
						</td>
					</tr>
					</c:forEach>
			</table>
				<table align="right">
				<tr>
						 <td ></td>
						 <td> &nbsp;</td>
						 <td> &nbsp;</td>
						
					</tr>
			</table>
			<p>&nbsp;&nbsp;总数：${requestScope.rolesetselectpage.countRows}例 &nbsp;&nbsp;&nbsp;当前第 ${rolesetselectindexpage}页  &nbsp;&nbsp;&nbsp;共 ${requestScope.rolesetselectpage.countPage}页  &nbsp;&nbsp;跳到第 <input name="page" type="text" class="input1" size="1" name="rolesetselectpage"> 页&nbsp;&nbsp;<input type=image src="<%=basePath%>images/go.bmp" width=18 height="18" border="0" >
		</form>
	</body>
</html>
