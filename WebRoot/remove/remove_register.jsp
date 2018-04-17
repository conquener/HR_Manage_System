<%@page import="com.zking.hr.utils.DateUtil.FormatDateUtils"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="<%=basePath %>table.css" type="text/css">
		<link rel="stylesheet" type="text/css" media="all"
			href="<%=basePath %>javascript/calendar/calendar-win2k-cold-1.css">
		<script type="text/javascript" src="<%=basePath %>javascript/calendar/cal.js"></script>
		<script type="text/javascript" src="<%=basePath %>javascript/comm/comm.js"></script>
		<script type="text/javascript" src="<%=basePath %>javascript/comm/select.js"></script>
		<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.7.2.min.js"></script>
		<script language="javascript" type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
		<script language="javascript" type="text/javascript" src="<%=basePath%>My97DatePicker/calendar.js"></script>
		<link href="<%=basePath%>My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	var request= null;
	if(window.ActiveXObject){
	 	request= new ActiveXObject("MSXML2.XMLHttp");
	 }else{
 	 request=new XMLHttpRequest();
	 }
	function professional(){
		request.open("POST", "tranmamage!professionalajax", true);
		request.setRequestHeader("content-type", "application/x-www-form-urlencoded;charset=utf-8");
		var positiontype=document.getElementById("positiontype");
		var positiontype2=document.getElementById("positiontype2");
		request.onreadystatechange=function(){	
			var text=eval(request.responseText);
			var options="<option value='-1'>----请选择-----</option>";
			for( var i=0;i<text.length;i++) {
				options+= ("<option value="+text[i].id+">"+text[i].name+"</option>");
			}		
			positiontype.innerHTML=options;
			positiontype2.innerHTML=options;
		}
		request.send(null);
	}
	
	function positionajax1(pid){
		request.open("POST", "tranmamage!positionajax?positionid="+pid, true);
		request.setRequestHeader("content-type", "application/x-www-form-urlencoded;charset=utf-8");
		var position1 = document.getElementById("position1");
		request.onreadystatechange=function(){	
			var text=eval(request.responseText);
			var options="<option value='-1'>----请选择-----</option>";
			for( var i=0;i<text.length;i++) {
				options+= ("<option value="+text[i].id+">"+text[i].name+"</option>");
			}		
			position1.innerHTML=options;
		}
		request.send(null);
	}
	
	function positionajax2(pid){
		request.open("POST", "tranmamage!positionajax?positionid="+pid, true);
		request.setRequestHeader("content-type", "application/x-www-form-urlencoded;charset=utf-8");
		var position2 = document.getElementById("position2");
		request.onreadystatechange=function(){	
			var text=eval(request.responseText);
			var options="<option value='-1'>----请选择-----</option>";
			for( var i=0;i<text.length;i++) {
				options+= ("<option value="+text[i].id+">"+text[i].name+"</option>");
			}		
			position2.innerHTML=options;
		}
		request.send(null);
	}
		
	function transregister(){
		form1.action="tranmamage!transRegister";
		form1.submit();
	}

</script>
	</head>

	<body onload="professional();">
		<form name="humanfileForm" method="post" action="" id="form1" >
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--调动管理--调动登记 </font>
					</td>
				</tr>
				
			</table>
 <table width="75%"  border="1"   cellpadding=0 cellspacing=1 bordercolorlight=#848284 bordercolordark=#eeeeee align="center">
   <tr align="center">
   		<%Date d = new Date();
		  String d1 = FormatDateUtils.format("yyyy-MM-dd",d);
		%>
       <td  class="TD_STYLE1" width="11%"> 工号</td>
	   <td   bgcolor="#D4F8D4"><input type="text" width="100%" name="stafftransfer.staffid"  class="INPUT_STYLE2" /></td>
	   <td  class="TD_STYLE1" width="11%"> 登记日期</td>
	   <td  bgcolor="#D4F8D4"> <input type="text" width="100%" name="" value="<%=d1 %>"  class="INPUT_STYLE2" /></td>
	   <td class="TD_STYLE1" width="11%">入职日期 </td>
	   <td  bgcolor="#D4F8D4"> <input type="text" width="100%"  onclick="WdatePicker();" name="stafftransfer.registerdate" class="INPUT_STYLE2" /></td>
	   <td class="TD_STYLE1" width="11%"> 调动日期</td>
	   <td  bgcolor="#D4F8D4"> <input type="text" width="100%"  onclick="WdatePicker();" name="stafftransfer.transferdate" class="INPUT_STYLE2" /></td>
	   
   </tr>
    <tr>
       <td class="TD_STYLE1" width="11%"> 异动性质</td>
	   <td colspan="7" bgcolor="#D4F8D4">
	   &nbsp;&nbsp;&nbsp;&nbsp;
	   <input id="a" type="checkbox" name="transactionnature" value="升职" />
	   <label for="a">升职</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   <input id="b" type="checkbox" name="transactionnature" value="加薪" />
	   <label for="b">加薪</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   <input id="c" type="checkbox" name="transactionnature" value="转岗" />
	   <label for="c">转岗</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   <input id="d" type="checkbox" name="transactionnature" value="降职" />
	   <label for="d">降职</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   <input id="e" type="checkbox" name="transactionnature" value="降薪" />
	   <label for="e">降薪</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   <input id="f" type="checkbox" name="transactionnature" value="转正" />
	   <label for="f">转正</label>
	   </td>
   </tr>
    <tr align="center" >
       <td rowspan="4"bgcolor="#96E1A0" class="TD_STYLE1" width="11%"> 个<br />人<br />情<br />况</td>
	   <td colspan="3"bgcolor="#96E1A0" class="TD_STYLE1" width="11%"> 异动前</td>
	   <td colspan="4"bgcolor="#96E1A0" class="TD_STYLE1" width="11%"> 异动后</td>
	 
	   
   </tr>
     <tr align="center">
       <td class="TD_STYLE1" width="11%"> 职位类型</td>
	   <td colspan="2" class="TD_STYLE2">
			<select name="stafftransfer.beforeTransactionDepartment" class="SELECT_STYLE1" id="positiontype" onclick="positionajax1(this.value);"></select>
		</td>
	    <td class="TD_STYLE1" width="11%"> 职位</td>
	    <td colspan="2" class="TD_STYLE2">
			<select name="stafftransfer.laterTransactionDepartment" class="SELECT_STYLE1" id="positiontype2" onclick="positionajax2(this.value);"></select>
		</td>
   </tr>
     <tr align="center">
         <td class="TD_STYLE1" width="11%"> 职位类型</td>
	    <td colspan="2" class="TD_STYLE2">
			<select name="stafftransfer.beforeTransactionPost" class="SELECT_STYLE1" id="position1"></select>
		</td>
	    <td class="TD_STYLE1" width="11%"> 职位</td>
	    <td colspan="2" class="TD_STYLE2">
			<select name="stafftransfer.laterTransactionPost" class="SELECT_STYLE1" id="position2"></select>
		</td>   
   </tr>
     <tr align="center">
          <td class="TD_STYLE1" width="11%"> 调整前薪<br/>资构成</td>
	   <td colspan="2" bgcolor="#D4F8D4"><input type="text" name="stafftransfer.beforeSalary" class="INPUT_STYLE2"/> </td>
	    <td class="TD_STYLE1" width="11%"> 调整后薪<br/>资构成</td>
	   <td colspan="3" bgcolor="#D4F8D4"> <input type="text" name="stafftransfer.laterSalary" class="INPUT_STYLE2"/></td>	
   </tr>
     <tr>
       <td rowspan="2" align="center" class="TD_STYLE1" width="11%"> 工<br/>作<br/>事<br/>项</td>
	   <td colspan="7" class="TD_STYLE1" width="11%" >原主要负责工作情况：<br/>
	   <textarea cols="140" rows="2" name="stafftransfer.beforeWork" class="INPUT_STYLE2"></textarea>
		</td>
     </tr>
     <tr>
      <td colspan="7" class="TD_STYLE1" width="11%" >现主要负责工作情况：<br/>
	  <textarea cols="140" rows="3" name="stafftransfer.lsterWork" class="INPUT_STYLE2"></textarea>
	   </td>	   
     </tr>
     <tr>
	   <td class="TD_STYLE1" width="11%"> 部门意见</td>
       <td colspan="7" bgcolor="#D4F8D4">
	     <textarea cols="140" rows="10" name="stafftransfer.departmentViews" class="INPUT_STYLE2"></textarea>
	    </td>
   </tr>
     <tr>
      <td class="TD_STYLE1" width="11%"> 分管副总意见</td>
       <td colspan="7" bgcolor="#D4F8D4">
	     <textarea cols="140" rows="10" name="stafftransfer.deputymanagerViews" class="INPUT_STYLE2"></textarea>
	    </td>
     </tr>
   <tr>
       <td rowspan="2" class="TD_STYLE1" width="11%">人事行政部意见 </td>
	   <td bgcolor="#D4F8D4">执行调动日期：</td>
	   <td colspan="6" ><input type="text" onclick="WdatePicker();" name="stafftransfer.dotransferdate" class="INPUT_STYLE2"/></td>
    </tr>
    <tr>
	  <td colspan="7" bgcolor="#D4F8D4">
	     <textarea cols="140" rows="10" name="stafftransfer.personneldepartmentViews" class="INPUT_STYLE2"></textarea>
	    </td>
    </tr>
	 <tr>
      <td class="TD_STYLE1" width="11%"> 总经理意见</td>
       <td colspan="7" bgcolor="#D4F8D4">
	     <textarea cols="140" rows="10" name="stafftransfer.presidentViews" class="INPUT_STYLE2"></textarea>
	    </td>
     </tr>
	</table>
		<table width="100%">
				<tr >
					<td align="center">
					<center>
						<input type="button" value="提交" class="BUTTON_STYLE1"
							onclick="transregister();">
						<input type="reset" value="重填" class="BUTTON_STYLE1">
					</center>
					</td>
		        </tr>
   </table>
   </form>
</body>
</html>

