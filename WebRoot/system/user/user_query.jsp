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

function pageSubmit(){
	var targetpage = document.getElementById("targetpage").value;
	var maxpage = document.getElementById("maxpage").value;
	if(targetpage==null||targetpage==""){
		alert("请输入要跳转的页码!");
	}else if(targetpage>maxpage){
		alert("输入的页码超出最大页码!");
	}else{	
		form1.action="systemManage!userquery?userquesryIndexPage="+targetpage;
		form1.submit();
	}
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
				<tr align="center">
					<td>
						<form action="#" method="post" id="form1">
						</form>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="添加" class="BUTTON_STYLE1"
							onclick="window.location.href='system/user/register.jsp'">
						
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1" >
				<tr class="TR_STYLE1">
					<td width="13%" class="TD_STYLE1">
						编号
					</td>
					<td width="13%" class="TD_STYLE1">
						用户名称
					</td>
					<td width="13%" class="TD_STYLE1">
						用户档案编号
					</td>
					<td width="13%" class="TD_STYLE1">
						修改
					</td>
					<td width="13%" class="TD_STYLE1">
						删除
					</td>
				</tr>
				<c:if test="${!empty requestScope.systemuserlst}">
					<c:forEach items="${requestScope.systemuserlst}" var="u">
					<tr>
					<td  class="TD_STYLE1">
						${u.userId}
					</td>
						<td class="TD_STYLE2">
							<a href="systemManage!userdetail?systemuserId=${u.userId}">${u.userName}</a>
						</td>
						<td class="TD_STYLE2">
							${u.userFile}
						</td>
						<td class="TD_STYLE2">
							<a href="systemManage!userupdatequery?systemuserId=${u.userId}">修改</a>
						</td>
						<td class="TD_STYLE2">
							<a href="systemManage!humandelete?systemuserId=${u.userId}">删除</a>
						</td>
					</tr>
					</c:forEach>
				</c:if>
			</table>
			<input type="hidden" value="${requestScope.userlstpage.countPage}" id="maxpage" />
			<p>&nbsp;&nbsp;总数：${requestScope.userlstpage.countRows}例 &nbsp;&nbsp;&nbsp;
			当前第 ${requestScope.userquesryIndexPage}页  &nbsp;&nbsp;&nbsp;
			共 ${requestScope.userlstpage.countPage}页  &nbsp;&nbsp;&nbsp;
			<a href="#">首页</a>&nbsp;|&nbsp;<a href="#">上页</a>&nbsp;|&nbsp;<a href="#">下一页</a>&nbsp;|&nbsp;<a href="#">尾页</a>&nbsp;&nbsp;&nbsp;跳到第 <input name="userquesryIndexPage" type="text" class="input1" id="targetpage" size="1"> 页&nbsp;&nbsp;<input type="image" src="images/go.bmp" width="18" height="18" border="0" onclick="pageSubmit();" />
	</body>
</html>

