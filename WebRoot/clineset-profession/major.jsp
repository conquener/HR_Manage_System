<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="<%=basePath %>table.css" type="text/css">
		<script type="text/javascript" >
			function Delete(id)
			{
				if(confirm("确定要删除吗？")) {
					location.href = "delPosition!deletePosition?positionId=" + id;
				}
			}
			
			function checkpage(countPage,indexPage){
				var index = document.getElementById("index");
				var a = document.getElementById("goload");
				if(a.value > countPage || a.value < 1){
					alert("对不起，不能超过总页数且不能小于1");
					a.value = indexPage;
					return false;
				}else{
					index.value = a.value;
					return true;
				}
			}
		</script>
	</head>

	<body>
		<form method="post" action="position!loadPosition" >
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--职位设置
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="添加"  onclick="window.location.href='queryInPosition!queryInsertPosition'"  class="BUTTON_STYLE1"">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="22%" class="TD_STYLE1">
						职位分类编号
					</td>
					<td width="23%" class="TD_STYLE1">
						职位分类名称
					</td>
					<td width="26%" class="TD_STYLE1">
						职位编号
					</td>
					<td width="24%" class="TD_STYLE1">
						职位名称
					</td>
					<td width="5%" class="TD_STYLE1">
					     删除
					  <input name="indexPage" id="index" type="hidden" value="1" />
					</td>
				</tr>
				<c:forEach items="${position}" var="p" end="${positionSize-2}">
					<tr>
						<td class="TD_STYLE2">
							${p.positiontypeId}
						</td>
						<td class="TD_STYLE2">
							${p.positiontypeName}
						</td>
						<td class="TD_STYLE2">
							${p.positionId}
						</td>
						<td class="TD_STYLE2">
							${p.positionName}
						</td>
						<td class="TD_STYLE2">
						
						 <a href="javascript:Delete(${p.positionId});">删除</a>
						</td>
					</tr>
				</c:forEach>
				
			</table>
			<p>&nbsp;&nbsp;总数：${position[positionSize-1].countRows}例 &nbsp;&nbsp;&nbsp;
			当前第 ${position[positionSize-1].indexPage} 页  &nbsp;&nbsp;&nbsp;
			共 ${position[positionSize-1].countPage} 页  &nbsp;&nbsp;&nbsp;
			跳到第 <input id="goload" name="" value="" onchange="checkpage('${position[positionSize-1].countPage}','${position[positionSize-1].indexPage}')" type=text class=input1 size=1> 页&nbsp;&nbsp;
			<input type=image src="<%=basePath %>images/go.bmp" width=18 height=18 border=0>
		</form>
	</body>
</html>

