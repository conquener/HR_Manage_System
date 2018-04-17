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
		<link rel="stylesheet" href="table.css" type="text/css" />
		<link rel="stylesheet" type="text/css" media="all"
			href="<%=basePath %>javascript/calendar/calendar-win2k-cold-1.css">
		<script type="text/javascript" src="<%=basePath %>javascript/calendar/cal.js"></script>
		<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.7.2.min.js"></script>
		<title>无标题文档</title>
	<script type="text/javascript">
			function formsubmit(){
				if($("#powerselect").val()==-1){
					alert('请先选择权限!');
				}
				form1.action = "<%=basePath%>systemManage!newauthodesignaddsuccess";
				form1.submit();
			}
			
			function getPermission(){
				var roleId = $("#selectRoleId").val();
				if(roleId==-1){
					return;
				}
				$.ajax({
					url:'<%=basePath%>systemManage!getRoleNotPermission',
					dataType:'json',
					type:'post',
					data:{roleId:roleId},
					success:function(data){
						var options = "<option value='-1'>----请选择权限----</option>";
						for(var i=0,length=data.length;i<length;i++){
							options+="<option value="+data[i].permissionId+">"+data[i].permissionName+"</option>";
						}
						$("#powerselect").html(options);
					}
				});
			}
	</script>
	</head>
	<body>
		<form method="post" action="" id="form1" name="form1">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是:</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="添加" class="BUTTON_STYLE1"
							onclick="formsubmit();">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="20%" class="TD_STYLE1">
						角色名称
					</td>
					<td class="TD_STYLE2">
						<select class="INPUT_STYLE1" onchange="getPermission()" name="roleId" id="selectRoleId">
							<option selected="selected" value="-1">----请选择角色----</option>
							<c:forEach items="${requestScope.rolelst}" var="r">
								<option value="${r.roleId}">${r.roleName}</option>
							</c:forEach>		
						</select>
					</td>
				</tr>
				<tr>
					<td width="20%" class="TD_STYLE1">
						权限名称
					</td>
					<td class="TD_STYLE2">
					<select class="INPUT_STYLE1" id="powerselect" name="permissId">
						<option selected="selected" value="-1">----请选择权限----</option>
					</select>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>