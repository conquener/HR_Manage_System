<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/table.css" type="text/css">
		<script type="text/javascript" src="<%=basePath %>javascript/comm/comm.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.7.2.min.js"></script>
		<script type="text/javascript">
		function pagesubmit(){
			var index = $("#selectPage").val();
			$("#form1").attr("action","<%=basePath%>systemManage!rolesafeguardquery?indexPage="+index);
			$("#form1").submit();
		}
	
		function checkPage(){
			var index =$("#selectPage").val();
			if(!/^[0-9.-]*$/.test(index)){
				$("#selectPage").val('${rolepage.indexPage}');
				alert('请输入数字!');
			}else if(Number(index)<1){
				$("#selectPage").val('${rolepage.indexPage}');
				alert('页码必须大于1!');
			}else if(Number(index)>${rolepage.countPage}){
				$("#selectPage").val('${rolepage.indexPage}');
				alert('页码必须小于最大页码!');
			}
		}
	
	</script>
		
	</head>

	<body>
		<form method="post" id="form1" action="">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：角色--角色管理
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
					</td>
					<td align="right">
					</td>
				</tr>

			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
				<td width="20%" class="TD_STYLE1">
						编号
					</td>
					
					<td width="20%" class="TD_STYLE1">
						角色名称
					</td>
					
					<td colspan="2" align="center" width="20%" class="TD_STYLE1">
						操作
					</td>
				</tr>
				<c:forEach items="${requestScope.rolelst}" var="r">
				<tr>
					<td  class="TD_STYLE1">
						${r.roleId}
					</td>
                    <td class="TD_STYLE2">
						${r.roleName}
					</td>
						<td class="TD_STYLE2">
							<a href="system/role/role_update.jsp?roleId=${r.roleId}&roleName=${r.roleName}">修改</a>
						</td>
						<td class="TD_STYLE2">
							<a href="systemManage!roledelete?roleId=${r.roleId}">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<p>&nbsp;&nbsp;总数：${rolepage.countRows}例 &nbsp;&nbsp;&nbsp;当前第 ${rolepage.indexPage} 页  &nbsp;&nbsp;&nbsp;共 ${rolepage.countPage}页  &nbsp;&nbsp;&nbsp;
			<a href="#">首页</a>&nbsp;|&nbsp;<a href="#">上页</a>&nbsp;|&nbsp;<a href="#">下一页</a>&nbsp;|&nbsp;
			<a href="#">尾页</a>&nbsp;&nbsp;&nbsp;
			跳到第 <input name='page' type='text' class='input1' id="selectPage" onchange="checkPage()" value="${rolepage.indexPage}" size='1'> 页&nbsp;&nbsp;
			<input type=image src="<%=basePath%>images/go.bmp" onclick="pagesubmit()" width=18 height=18 border=0>
		</form>
	</body>
	
</html>

