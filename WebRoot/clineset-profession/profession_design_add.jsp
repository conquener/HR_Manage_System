<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" href="<%=basePath %>table.css" type="text/css">
<script type="text/javascript" >
function  validatec(){
    	var pass = false;
    		if(document.getElementById("zhicheng").value!=""){

    			var  reg=/^[\u4e00-\u9fa5]{2,20}$/;
    				if(reg.test( document.getElementById("zhicheng").value)==true){
    					 pass=true;
    					return pass;
    				}else{
    					alert("职称不符合规范，必须中文,长度2-20之间");
    					return pass;
    				}		
    		}else{
    			alert("职称不能为空");
    			
    			return pass;
    		}
}



</script>
</head>
<body>
<form name="configfilefirstkindForm" method="post" action="profeesionInsert!insertProfession" onsubmit="return validatec()">
<table width="100%" >
  <tr>
    <td> 
    <font color="#0000CC">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--职称添加 </font></td>
  </tr>
  <tr>
    <td align="right"><input type="submit" value="提交" class="BUTTON_STYLE1" >
      <input type="button" value="返回" class="BUTTON_STYLE1" onclick="window.location.href='profession!loadProfession'">
    </td>
  </tr>
  </table>
  
<table width="100%"  border="1" cellpadding=0 cellspacing=1 bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
  <tr>
    <td class="TD_STYLE1">职称名称</td>
    <td class="TD_STYLE2">
    	<input type="text" value="" name="profes.professionalName" class="INPUT_STYLE1">
  </tr>
   <tr>
    <td class="TD_STYLE1">备注</td>
    <td class="TD_STYLE2"><input type="text" name="profes.remark" value="" id="beizhu" class="INPUT_STYLE1"></td>
  </tr>
</table>
</form>
</body>
</html>
