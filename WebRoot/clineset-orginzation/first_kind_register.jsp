<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
<head>
<link rel="stylesheet" href="<%=basePath %>table.css" type="text/css">
<script type="text/javascript" src="<%=basePath %>javascript/comm/comm.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>autocomplete/jquery.autocomplete.css"/>
<script type="text/javascript" src="<%=basePath%>autocomplete/jquery.autocomplete.js"></script>
<script lang="javascript">
	function pass(){
		var pass = false;
		if( document.Form.firstKindName.value =="" ){
			alert("机构名称不能为空");
			pass= false;
		} else if(document.Form.salarySendId.value ==""){
			alert("薪酬发放责任人编号不能为空");
			pass= false;
		}else if(!/^(\d+,)?\d+$/.test(document.Form.salarySendId.value)){
			alert("薪酬发放责任人编号名称只能为数字和英文“,”");
			pass= false;
		}else if(document.Form.firstKindSaleId.value ==""){
			alert("销售责任人编号不能为空");
			pass= false;
		}else if(!/^(\d+,)?\d+$/.test(document.Form.firstKindSaleId.value)){
			alert("销售责任人编号名称只能为数字和英文“,”");
			pass= false;
		}
		else {
			pass = true;
			document.Form.submit();
		}
		return pass;
	}

	function completeUtil(){
		$("#salarySendName").autocomplete("<%=basePath%>clineset-orginzation/insertOrgan1!getFileUserName?inputUserName="+$("#salarySendName").val(),
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
					return "<div>"+item.FILESUSERNAME+"</div>";  
				},  
				formatMatch: function(item) {  
					return item.itemid;  
				},  
				formatResult: function(item) {  
					return item.itemid;  
				}  
				}).result(function(event, item, formatted) {//把返回的结果内容显示在其他文本框上  
					  $("#salarySendId").val(item.FILESFILESID);
					  $("#salarySendName").val(item.FILESUSERNAME)
	            });
	}
	
	function completeUtil2(){
		$("#firstKindSaleName").autocomplete("<%=basePath%>clineset-orginzation/insertOrgan1!getFileUserName?inputUserName="+$("#firstKindSaleName").val(),
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
					return "<div>"+item.FILESUSERNAME+"</div>";  
				},  
				formatMatch: function(item) {  
					return item.itemid;  
				},  
				formatResult: function(item) {  
					return item.itemid;  
				}  
				}).result(function(event, item, formatted) {//把返回的结果内容显示在其他文本框上  
					  $("#firstKindSaleId").val(item.FILESFILESID);
					  $("#firstKindSaleName").val(item.FILESUSERNAME)
	            });
	}
	
</script>

</head>
<body>

<form name="Form" method="post" action="<%=basePath%>clineset-orginzation/insertOrgan1!insertOrgan1"  onsubmit="pass()"  >
<table width="100%" >
  <tr>
    <td> 
    <font color="#0000CC">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--I级机构设置 </font></td>
  </tr>
 
  </table>
  
<table width="100%"  border="1" cellpadding=0 cellspacing=1 bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
   <tr>
    <td colspan="2" align="right" ><input type="button" value="提交" class="BUTTON_STYLE1" onclick="pass()"  >
      <input type="button" value="返回" class="BUTTON_STYLE1" onclick="history.back();">
    </td>
  </tr>
  <tr>
    <td class="TD_STYLE1">I级机构名称<input type="hidden" value="0" name="oragan.parentId" /></td>
    <td class="TD_STYLE2"><input type="text" id="firstKindName" name="oragan.oraganName" value="" class="INPUT_STYLE1" ></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">薪酬发放责任名称（多个编号之间请用"半角逗号"加"一个空格"隔开，如", "）</td>
    <td class="TD_STYLE2">
    	<input type="text" id="salarySendName" onchange="completeUtil();" onkeypress="completeUtil();"  class="TEXTAREA_STYLE1" />
    	<input type="hidden" id="salarySendId" name="oragan.salarypaypersonId" class="TEXTAREA_STYLE1" /></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">销售责任人编号（多个编号之间请用"半角逗号"加"一个空格"隔开，如", "）</td>
    <td class="TD_STYLE2">
    <input type="text" id="firstKindSaleName" onchange="completeUtil2();" onkeypress="completeUtil2();"  class="TEXTAREA_STYLE1" />
    <input id="firstKindSaleId" type="hidden" name="oragan.salepersonId"  class="TEXTAREA_STYLE1" />
    </td>
  </tr>
</table>
</form>
</body>
</html>
