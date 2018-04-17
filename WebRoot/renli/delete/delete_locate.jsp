<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="<%=basePath %>table.css" type="text/css" />
		<link rel="stylesheet" type="text/css" media="all"
			href="<%=basePath %>javascript/calendar/calendar-win2k-cold-1.css">
		<script type="text/javascript" src="<%=basePath %>javascript/calendar/cal.js"></script>
		<script type="text/javascript" src="<%=basePath %>javascript/comm/comm.js"></script>
		<script type="text/javascript" src="<%=basePath %>javascript/comm/list.js"></script>
		<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.7.2.min.js"></script>
		<script language="javascript" type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
		<script language="javascript" type="text/javascript" src="<%=basePath%>My97DatePicker/calendar.js"></script>
		<link href="<%=basePath%>My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css">
		<script type="text/javascript">
		function getFristOrginzation(){
			$.ajax({
				url:'<%=basePath%>renli/renlimange!getOrainzation',
				dataType:'json',
				data:{parentOrginzation:0},
				type:'post',
				success:function(data){
					var s = "<option value='-1'>--请选择--</option>";
					for(var i=0,length=data.length;i<length;i++){
						s+="<option value='"+data[i].oraganId+"'>"+data[i].oraganName+"</option>";
					}
						$("#queryselect1").html(s);
				}
			});
		}
		
		
		function getSecondOrginzation(){
			var parentId = $("#queryselect1").val();
			if(parentId==-1){
				return;
			}
			$.ajax({
				url:'<%=basePath%>renli/renlimange!getOrainzation',
				dataType:'json',
				data:{parentOrginzation:parentId},
				type:'post',
				success:function(data){
					var s = "<option value='-1'>--请选择--</option>";
					for(var i=0,length=data.length;i<length;i++){
						s+="<option value='"+data[i].oraganId+"'>"+data[i].oraganName+"</option>";
					}
						$("#queryselect2").html(s);
				}
			});
		}
		function getThirdOrginzation(){
			var parentId = $("#queryselect2").val();
			if(parentId==-1){
				return;
			}
			$.ajax({
				url:'<%=basePath%>renli/renlimange!getOrainzation',
				dataType:'json',
				data:{parentOrginzation:parentId},
				type:'post',
				success:function(data){
					var s = "<option value='-1'>--请选择--</option>";
					for(var i=0,length=data.length;i<length;i++){
						s+="<option value='"+data[i].oraganId+"'>"+data[i].oraganName+"</option>";
					}
						$("#queryselect3").html(s);
				}
			});
		}
		
 		</script>
	</head>

	<body onload="getFristOrginzation()">
		<form name="humanfileForm" method="post" action="<%=basePath%>renli/renlimange!queryFileList?index=3">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案删除 </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="submit" value="查询"
							class="BUTTON_STYLE1">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight='#848284' bordercolordark='#eeeeee'
				class="TABLE_STYLE1">
				<tr class="TR_STYLE1">
					<td width="16%" class="TD_STYLE1">
						请选择员工所在I级机构
					</td>
					<td width="84%" class="TD_STYLE2">
						<select id="queryselect1"  name="queryFiles.fristorganization"  class="SELECT_STYLE2" onchange="getSecondOrginzation()">
							<option value="-1">--请选择--</option>
						</select>
						
					</td>
				</tr>
				<tr>
					<td width="16%" class="TD_STYLE1">
						请选择员工所在II级机构
					</td>
					<td width="84%" class="TD_STYLE2">
						<select id="queryselect2" name="queryFiles.twoorganization"  class="SELECT_STYLE2" onchange="getThirdOrginzation()" >
							<option value="-1">--请选择--</option>
						</select>
					</td>
				</tr>
				<tr class="TR_STYLE1">
					<td width="16%" class="TD_STYLE1">
						请选择员工所在III级机构
					</td>
					<td width="84%" class="TD_STYLE2">
						<select id="queryselect3" name="queryFiles.threeorganization"  class="SELECT_STYLE2" >
							<option value="-1">--请选择--</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						请输入建档时间
					</td>
					<td width="84%" class="TD_STYLE2">
						<input type="text" onclick="WdatePicker();" name="queryFiles.startTime" value="" style="width:14% " class="INPUT_STYLE2" id="date_start">
						至
						<input type="text" onclick="WdatePicker();" name="queryFiles.endTime" value="" style="width:14% " class="INPUT_STYLE2" id="date_end">
						（YYYY-MM-DD）
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
