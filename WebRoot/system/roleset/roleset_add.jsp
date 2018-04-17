<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=basePath %>table.css" rel="stylesheet"/>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>autocomplete/jquery.autocomplete.css"/>
<script type="text/javascript" src="<%=basePath%>autocomplete/jquery.autocomplete.js"></script>
<title>用户角色添加</title>
<style type="text/css">
<!--
.style1 {
	font-size: 18px;
	font-weight: bold;
	color: #660000;
}
-->
</style>
<script type="text/javascript">
	function doAdd()
	{
			document.forms[0].action ="<%=basePath%>systemManage!rolesetadd";
			document.forms[0].submit();
	}
	function getRole(){
		$.ajax({
			url:'<%=basePath%>systemManage!rolequery',
			type:'post',
			dataType:'json',
			success:function(data){
				var options="<option value='-1'>----请选择-----</option>";
				for( var i=0;i<data.length;i++) {
					options+= ("<option value="+data[i].roleId+">"+data[i].roleName+"</option>");
				}		
				roleselect.innerHTML=options;
			}
		});
	}
	
	function completeUtil(){
		$("#currentUserName").autocomplete("<%=basePath%>systemManage!rolesetUserLike?userName="+$("#currentUserName").val(),
				{   
					delay:10,
		            minChars:0,
		            max:8,
		            matchCase:true,
		            matchSubset:false,
		            matchContains:true,
		            scrollHeight: 250,   
		            width:200, 
		            cacheLength:1,
		            dataType:'json',
		            parse:function(data) {
		                var parsed = [];  
		                for (var i = 0; i < data.length; i++) { 
		                    parsed[parsed.length] = {  
		                    data: data[i],  
		                    value: data[i].itemid,
		                    result: data[i].itemid //返回的结果显示内容  
		                    };  
		                }  
		                return parsed;  
	            },  
	            formatItem: function(item) {//显示下拉列表的内容  
	            	console.log(item)
					return "<div>"+item.userName+"</div>";  
				},  
				formatMatch: function(item) {  
					return item.itemid;  
				},  
				formatResult: function(item) {  
					return item.itemid;  
				}  
				}).result(function(event, item, formatted) {//把返回的结果内容显示在其他文本框上  
					  $("#userId").val(item.userId);
					  $("#currentUserName").val(item.userName)
	            });
	}
	
</script>
</head>

<body bgcolor="#E9F8F3" onload="getRole()">
<form method="post" action="" id="form1">
<font color="#0000CC">您正在做的业务是：角色设置--角色设置管理--用户角色添加 </font>
<table width="100%">
	
			
	
  <tr>
    <td height="169" colspan="3" align="center">
      <p >&nbsp;</p>
      <p >&nbsp;</p>
      <p >&nbsp;</p>
      <p class="style1">用户角色赋予</p></td>
  </tr>
  <tr>
  <td width="18%" height="166">&nbsp;</td>
  <td width="62%">
  <table width="95%" border="1" cellpadding=0 cellspacing=1 bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
  
  <tr>
    <td width="20%" class="TD_STYLE1">用户名</td>
	<td class="TD_STYLE2" height="25">
	<input type="text" name="rolesetuserName" id="currentUserName" onchange="completeUtil();" onkeypress="completeUtil();"  value="" style="background-color: #DEEBF7" class="INPUT_STYLE1">
	<input type="hidden" name="systemuserId" id="userId">
	</td>
  </tr>
  <tr>
    <td class="TD_STYLE1">添加角色</td>
    <td class="TD_STYLE2">
    	<select name="rolesetroleId" id="roleselect" value="" class="INPUT_STYLE1">
		</select></td>
  </tr>
  </table>
  </td>
  <td width="20%" >&nbsp;</td>
  </tr>
  <tr>
    <td></td>
    <td align="center"><input type="button" value="确定" class="BUTTON_STYLE1" onclick="javascript:doAdd();"> &nbsp;
      <input type="button" value="返回" onclick="history.back();" class="BUTTON_STYLE1"></td>
	  <td></td>
  </tr>
</table>
</form>      
</body>
</html>
