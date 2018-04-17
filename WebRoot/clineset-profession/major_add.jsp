<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" href="<%=basePath %>table.css" type="text/css">
<script type="text/javascript" >
 function  validatea(){
    	var pass = false;
    		if(document.getElementById("idpro").value!=""){

    			var  reg=/^[\u4e00-\u9fa5]{2,20}$/;
    				if(reg.test( document.getElementById("idpro").value)==true){
    					 pass=true;
    					return pass;
    				}else{
    					alert("职位名称不符合规范，必须中文,长度2-20之间");
    					return pass;	
    				}		
    		}else{
    			alert("职位名称不能为空");
    			
    			return pass;
    		}
}

</script>

</script>
</head>
<body>
<form name="configfilefirstkindForm" method="post" action="insPosition!insertPosition" onsubmit="return validatea()">
<table width="100%" >
  <tr>
    <td> 
    <font color="#0000CC">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--职位添加 </font></td>
  </tr>
  <tr>
    <td align="right"><input type="submit" value="提交" class="BUTTON_STYLE1"  >
      <input type="button" value="返回" class="BUTTON_STYLE1" onclick="window.location.href='position!loadPosition'">
    </td>
  </tr>
  </table>
  
<table width="100%"  border="1" cellpadding=0 cellspacing=1 bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
  <tr>
    <td width="19%" class="TD_STYLE1">职位编号</td>
    <td width="81%" class="TD_STYLE2"></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">职位名称</td>
    <td class="TD_STYLE2">
		<input class="INPUT_STYLE1" value="" name="tp.positionName" >
	</td>                
  </tr>
 <tr>
    <td class="TD_STYLE1">职位分类</td>
    <td class="TD_STYLE2"> 
	<select name="tp.positiontypeName" class="INPUT_STYLE1" >
			<option value="">&nbsp;</option>
		<c:forEach items="${PType}" var="PType">
		    <option value="${PType.positiontypeName},${PType.positiontypeId}">${PType.positiontypeName}</option>
		</c:forEach>
	</select>
	</td>
  </tr>
  <tr>
    <td class="TD_STYLE1">备注</td>
    <td class="TD_STYLE2"><input type="text" id="beizhu" name="tp.remark" value="" class="INPUT_STYLE1" ></td>
  </tr>
 
</table>
</form>
</body>
</html>
