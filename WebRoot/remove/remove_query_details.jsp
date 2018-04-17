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
<script type="text/javascript">
		function selecttransactionnature(){
			var checks = document.getElementById("transtype").value;
			var interests = document.getElementsByName("transactionnature");
			for(var i=0;i<interests.length;i++){
					var a = interests[i].value;
					if(checks.indexOf(a)!=-1){
					  interests[i].checked="checked";
					}
			}
		}
		
		function formSubmit(check){
				form1.action="tranmamage!stafftranscheck?checkSelect="+check;
				form1.submit();
		}
 </script>
	</head>
	<body onload="selecttransactionnature();">
		<form name="humanfileForm" method="post" action="" id="form1">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--<a style="color:gray;" href="javascript:history.go(-1);">调动管理</a>--调动查询 </font>
					</td>
				</tr>
			</table>
 <table width="75%"  border="1"   cellpadding=0 cellspacing=1 bordercolorlight=#848284 bordercolordark=#eeeeee align="center">
   <tr align="center">
   <%Date d = new Date();
		  String d1 = FormatDateUtils.format("yyyy-MM-dd",d);
		%>
       <td  class="TD_STYLE1" width="11%"> 工号</td>
	   <td   bgcolor="#D4F8D4"><input type="text" width="100%"   class="INPUT_STYLE2" value="${requestScope.stafftrans.staffid}"/></td>
	   <td  class="TD_STYLE1" width="11%"> 登记日期</td>
	   <td  bgcolor="#D4F8D4"> <input type="text" width="100%" name="re_register_time" value="<%=d1 %>" class="INPUT_STYLE2"/></td>
	   <td class="TD_STYLE1" width="11%">入职日期 </td>
	   <td  bgcolor="#D4F8D4"> <input type="text" width="100%" name="re_entrance_time" class="INPUT_STYLE2" value="${requestScope.stafftrans.registerdate}"/></td>
	   <td class="TD_STYLE1" width="11%"> 调动日期</td>
	   <td  bgcolor="#D4F8D4"> <input type="text" width="100%" name="re_time" class="INPUT_STYLE2" value="${requestScope.stafftrans.transferdate}"/></td>
   </tr>
    <tr>
       <td class="TD_STYLE1" width="11%"> 异动性质
       <input type="hidden" value="${requestScope.stafftrans.transactionnature}" id="transtype"/>
       </td>
	   <td colspan="7" bgcolor="#D4F8D4">
	   &nbsp;&nbsp;&nbsp;&nbsp;
	   <input id="a" type="checkbox" name="transactionnature" value="升职" />
	   <label for="a">升职</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   <input id="b" type="checkbox" name="transactionnature" value="加薪"/>
	   <label for="b">加薪</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   <input id="c" type="checkbox" name="transactionnature" value="转岗"/>
	   <label for="c">转岗</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   <input id="d" type="checkbox" name="transactionnature"  value="降职"/>
	   <label for="d">降职</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   <input id="e" type="checkbox" name="transactionnature"  value="降薪"/>
	   <label for="e">降薪</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   <input id="f" type="checkbox" name="transactionnature" value="转正"/>
	   <label for="f">转正</label>
	   </td>
   </tr>
    <tr align="center" >
       <td rowspan="4"bgcolor="#96E1A0" class="TD_STYLE1" width="11%"> 个<br />人<br />情<br />况</td>
	   <td colspan="3"bgcolor="#96E1A0" class="TD_STYLE1" width="11%"> 异动前</td>
	   <td colspan="4"bgcolor="#96E1A0" class="TD_STYLE1" width="11%"> 异动后</td>
   </tr>
     <tr align="center">
       <td class="TD_STYLE1" width="11%"> 部门</td>
	   <td colspan="2" class="TD_STYLE2">
						<input type="text" width="100%" value="${requestScope.stafftrans.beforeTransactionDepartment}" class="INPUT_STYLE2"/>
					</td>
	    <td class="TD_STYLE1" width="11%"> 部门</td>
	    <td colspan="2" class="TD_STYLE2">
						<input type="text" width="100%" value="${requestScope.stafftrans.laterTransactionDepartment}"  class="INPUT_STYLE2"/>
					</td>
   </tr>
     <tr align="center">
         <td class="TD_STYLE1" width="11%"> 职务</td>
	    <td colspan="2" class="TD_STYLE2">
						<input type="text" width="100%"  class="INPUT_STYLE2" value="${requestScope.stafftrans.beforeTransactionPost}"/>
					</td>
	    <td class="TD_STYLE1" width="11%"> 职务</td>
	    <td colspan="2" class="TD_STYLE2">
						<input type="text" width="100%"  class="INPUT_STYLE2" value="${requestScope.stafftrans.laterTransactionPost}"/>
					</td>   
   </tr>
     <tr align="center">
          <td class="TD_STYLE1" width="11%"> 调整前薪<br/>资构成</td>
	   <td colspan="2" bgcolor="#D4F8D4"><input type="text" value="${requestScope.stafftrans.beforeSalary}" class="INPUT_STYLE2"/> </td>
	    <td class="TD_STYLE1" width="11%"> 调整后薪<br/>资构成</td>
	   <td colspan="3" bgcolor="#D4F8D4"> <input type="text" value="${requestScope.stafftrans.laterSalary}" class="INPUT_STYLE2"/></td>	
   </tr>
     <tr>
       <td rowspan="2" align="center" class="TD_STYLE1" width="11%"> 工<br/>作<br/>事<br/>项</td>
	   <td colspan="7" class="TD_STYLE1" width="11%" >原主要负责工作情况：<br/>
	   <textarea cols="140" rows="2" name="re_primay_jop_case" class="INPUT_STYLE2">${requestScope.stafftrans.beforeWork}</textarea>
		</td>
     </tr>
     <tr>
      <td colspan="7" class="TD_STYLE1" width="11%" >现主要负责工作情况：<br/>
	  <textarea cols="140" rows="3" name="re_now_jop_case"  class="INPUT_STYLE2">${requestScope.stafftrans.lsterWork}</textarea>
	   </td>	   
     </tr>
     <tr>
	   <td class="TD_STYLE1" width="11%"> 部门意见</td>
       <td colspan="7" bgcolor="#D4F8D4">
	     <textarea cols="140" rows="10" name="re_department_idea" class="INPUT_STYLE2">${requestScope.stafftrans.departmentViews}</textarea>
	    </td>
   </tr>
     <tr>
      <td class="TD_STYLE1" width="11%"> 分管副总意见</td>
       <td colspan="7" bgcolor="#D4F8D4">
	     <textarea cols="140" rows="10" name="re_fenfuzong_idea" class="INPUT_STYLE2">${requestScope.stafftrans.deputymanagerViews}</textarea>
	    </td>
     </tr>
     <tr>
       <td rowspan="2" class="TD_STYLE1" width="11%">人事行政部意见 </td>
	   <td bgcolor="#D4F8D4">执行调动日期：</td>
	   <td colspan="6" ><input type="text" value="${requestScope.stafftrans.dotransferdate}"  name="re_personnel_implement_time" class="INPUT_STYLE2"/></td>
    </tr>

    <tr>
	  <td colspan="7" bgcolor="#D4F8D4">
	     <textarea cols="140" rows="10" name="re_personnel_idea" class="INPUT_STYLE2">${requestScope.stafftrans.personneldepartmentViews}</textarea>
	    </td>
	   
    </tr>
	 <tr>
      <td class="TD_STYLE1" width="11%"> 总经理意见</td>
       <td colspan="7" bgcolor="#D4F8D4">
	     <textarea cols="140" rows="10" name="re_president_idea" class="INPUT_STYLE2">${requestScope.stafftrans.presidentViews}</textarea>
	    </td>
     </tr>
  </table>
  </table>
		<table width="100%" align="center">
				<tr align="center">
				   <td>复核人：<input type="text" value="${sessionScope.user.userName }" />
				   复核时间：<input type="text" value="<%=d1%>"/>
				   复核状态：<input type="text" value="复核完毕"/></td>
				</tr>
		</table>
   </form>
</body>
</html>
