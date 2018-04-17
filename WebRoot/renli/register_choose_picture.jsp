<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="<%=basePath %>table.css" type="text/css">
<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=basePath %>javascript/comm/comm.js"></script>
<script type="text/javascript">
	function uploadPicture(){
		$("#uploadFrom").attr("action","<%=basePath%>renli/renlimange!humanPicture");
		$("#uploadFrom").submit();
	}
	function finish(){
		$("#uploadFrom").attr("action","<%=basePath%>renli/human_register.jsp");
		$("#uploadFrom").submit();
		
	}
</script>
</head>
<body>
<form method="post" id="uploadFrom" action="humanfile.do" enctype="multipart/form-data">
<table width="100%" >
  <tr>
    <td colspan="2"> 
    <font color="#0000CC">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案登记</font></td>
  </tr>
  <tr>
    <td width="59%">提交成功，如有照片，请选择上传照片(.jpg、.gif文件)
    <input type="hidden" name="fileId" value="${fileId}" />
	<input type="file" class="FILE_STYLE1" name="prcture" width="100%"></td>
    <td width="41%" align="right">
    <input type="button" value="上传照片" class="BUTTON_STYLE1" onclick="javascript:uploadPicture();">
    <input type="button" value="完成" class="BUTTON_STYLE1" onclick="javascript:finish();"></td>
  </tr>
  </table>

</form>
</body>
</html>
