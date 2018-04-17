<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript">
			function Delete(id,beginRow,endRow)
			{	
				if(confirm("确定要删除吗？")) {
					location.href = "salaryProDel!deleteSalaryPro?saProId=" + id;
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
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="<%=basePath %>table.css" type="text/css">
	</head>
	<body>
			<form method="post" action="salaryPro!loadSalaryPro">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--客户化设置--薪酬管理设置--薪酬项目设置
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="添加" class="BUTTON_STYLE1"  onclick="window.location.href='salary_project_add.jsp'">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="46%" class="TD_STYLE1">
						薪酬项目分类编号
					</td>
					<td width="47%" class="TD_STYLE1">
						薪酬项目分类名称
					</td>
					<td width="5%" class="TD_STYLE1">
						删除
						<input name="indexPage" id="index" type="hidden" value="1" />
					</td>
				</tr>
				<c:forEach items="${salaryPro}" var="t" end="${salaryProSize-2}">
					<tr>
						<td class="TD_STYLE2">
							${t.salaryprojectId}
						</td>
						<td class="TD_STYLE2">
							${t.salaryprojectName}
						</td>
						<td class="TD_STYLE2">
							<a href="javascript:Delete(${t.salaryprojectId},${salaryPro[salaryProSize-1].beginRow},${salaryPro[salaryProSize-1].endRow})">删除</a>
						</td>
					</tr>
				</c:forEach>
				
			</table>
				<p>&nbsp;&nbsp;总数：${salaryPro[salaryProSize-1].countRows}例 &nbsp;&nbsp;&nbsp;
				当前第 ${salaryPro[salaryProSize-1].indexPage} 页  &nbsp;&nbsp;&nbsp;
				共 ${salaryPro[salaryProSize-1].countPage} 页  &nbsp;&nbsp;&nbsp;
				跳到第 <input id="goload" name="" value="" onchange="checkpage('${salaryPro[salaryProSize-1].countPage}','${salaryPro[salaryProSize-1].indexPage}')" type=text class=input1 size=1> 页&nbsp;&nbsp;
				<input type=image src="<%=basePath%>images/go.bmp" width=18 height=18 border=0>
		</form>

	</body>
</html>