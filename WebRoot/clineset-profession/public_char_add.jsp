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
function  validated(){
    	var pass = false;
    		if(document.getElementById("sl").value!=""){
    			var  reg=/^[\u4e00-\u9fa5]{2,20}$/;
    				if(reg.test( document.getElementById("sl").value)==true){
    					 pass=true;
    					return pass;
    				}else{
    					alert("属性种类不符合规范，必须中文,长度2-20之间");
    					return pass;
    				}		
    		}else{
    			alert("属性种类不能为空");
    			
    			return pass;
    		}
}


function  validatee(){
    	var pass = false;
    		if(document.getElementById("mingcheng").value!=""){

    			var  reg=/^[\u4e00-\u9fa5]|[A-Za-z0-9]{1,20}$/;
    				if(reg.test( document.getElementById("mingcheng").value)==true){
    					 pass=true;
    					return pass;
    				}else{
    					alert("职位名称不符合规范，必须中文,大写英文字母 ，数字，长度1-20之间");
    					return pass;
    				}		
    		}else{
    			alert("属性名称不能为空");
    			return pass;
    		}
}
function  validateh(){
        var pass = false;
		if(validated()){
		     if(validatee()){
			  pass=true;
			  return pass;
		}else{
		   return pass;
		}
		}
		else{
		return  pasa;
		}
}

</script>
</head>
<body>
<form name="configfilefirstkindForm" method="post" action="insPublicPro!insertPublicProperty" onsubmit="return validateh()">
<table width="100%" >
  <tr>
    <td> 
    <font color="#0000CC">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--公共属性添加 </font></td>
  </tr>
  <tr>
    <td align="right"><input type="submit" value="提交" class="BUTTON_STYLE1" >
      <input type="button" value="返回" class="BUTTON_STYLE1" onclick="window.location.href='publicPro!loadPublicProperty'">
    </td>
  </tr>
  </table>
  
<table width="100%"  border="1" cellpadding='0' cellspacing='1' bordercolorlight='#848284' bordercolordark='#eeeeee' class="TABLE_STYLE1">
  <tr>
    <td class="TD_STYLE1">属性种类</td>
    <td class="TD_STYLE2"><input type="text"  name="tp.propertytypeName" id="sl" value="" class="INPUT_STYLE1"></td>
  </tr>
 <tr>
    <td class="TD_STYLE1">属性名称</td>
    <td class="TD_STYLE2"><input type="text" name="tp.publcipropertyName" id="mingcheng" value="" class="INPUT_STYLE1"></td>
  </tr>
  
   <tr>
    <td class="TD_STYLE1">备注</td>
    <td class="TD_STYLE2"><input type="text"  name="tp.remark" id="beizhu" value="" class="INPUT_STYLE1"></td>
  </tr>
</table>
</form>
</body>
</html>
