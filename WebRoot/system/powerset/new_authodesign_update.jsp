<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="<%=basePath %>table.css" type="text/css" />
		<link rel="stylesheet" type="text/css" media="all"
			href="<%=basePath %>javascript/calendar/calendar-win2k-cold-1.css">
		<script type="text/javascript" src="<%=basePath %>javascript/calendar/cal.js"></script>
		<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.7.2.min.js"></script>
		<title>无标题文档</title>
<%
	String permissName = new String((request.getParameter("permissName")).getBytes("iso8859-1"),"utf-8");
	String roleName = new String((request.getParameter("roleName")).getBytes("iso8859-1"),"utf-8");
	Integer rolepermissId = Integer.parseInt(request.getParameter("rolepermissId"));
	Integer roleId = Integer.parseInt(request.getParameter("roleId"));
	Integer permissId = Integer.parseInt(request.getParameter("permissId"));
%>
<script type="text/javascript">
function getPermission(){
	var roleId = <%=roleId%>;
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
				options+="<option value="+data[i].permissionId;
				if(data[i].permissionId==<%=permissId%>){
					options+=" selected='selected' ";
				}
				options+=">"+data[i].permissionName+"</option>";
			}
			$("#permissselect").html(options);
		}
	});
}
function formsubmit(){
	if($("#permissselect").val()==-1){
		alert('请先选择权限!如果角色已拥有了所有权限,则不可修改,应该选择删除!')
		return;
	}
	$("#form1").submit();
}

</script>
	</head>

	<body onload="getPermission();">
		<form method="post" action="<%=basePath %>systemManage!newauthodesignupdatesuccess" id="form1">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是:</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="确定" class="BUTTON_STYLE1"
							onclick="javascript:formsubmit();">
						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick="javascript:history.go(-1);">
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
					<input type="hidden" value="<%=permissName%>" name="permissName" />
					<input type="hidden" value="<%=rolepermissId%>" name="rolepermiss.rolePermissionId" />
					<input type="hidden" value="<%=roleId%>" name="rolepermiss.roleId" />
						<%=roleName%>
					</td>
				</tr>
				<tr>
					<td width="20%" class="TD_STYLE1">
						权限名称
					</td>
					<td class="TD_STYLE2">
					<select class="INPUT_STYLE1" name="rolepermiss.permissionId" id="permissselect">
					</select>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>