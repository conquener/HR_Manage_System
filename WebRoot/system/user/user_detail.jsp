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
function toCheck(id)
{
	document.forms[0].action = document.forms[0].action + "?operate=toCheck&id=" + id;
	document.forms[0].submit();
}
</script>
	</head>
	<body>
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：系统管理--用户管理--用户查询 </font>
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1" >
				<tr class="TR_STYLE1" align="center">
					<td width="13%" class="TD_STYLE1">
						${requestScope.usermessage.userName}
					</td>
				</tr>
				<tr class="TR_STYLE1" align="center">
					<td width="13%" class="TD_STYLE1">
						所拥有的角色如下：
					</td>
				</tr>
				<tr class="TR_STYLE1" align="center">
					<td width="13%" class="TD_STYLE1">
						<c:choose>
							<c:when test="${!empty requestScope.usermessage.userRoleName}">
								${requestScope.usermessage.userRoleName}
							</c:when>
							<c:otherwise>
								该用户没有设置角色!								
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td align="center"><a href="javascript:history.back();">返回</a></td>
				</tr>
			</table>
	</body>
</html>