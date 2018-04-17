<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="<%=basePath %>table.css" type="text/css">
		<script type="text/javascript">
			function Delete(id)
			{
				if(confirm("确定要删除吗？")) {
					location.href = "positionTDelete!deletePositionType?positiontypeId=" + id;
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
		<form method="post" action="positionT!loadPositionType">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--职位分类设置
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="添加"  onclick="window.location.href='major_kind_add.jsp'"   class="BUTTON_STYLE1"
							onclick="javascript:toAdd()">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding='0' cellspacing='1'
				bordercolorlight='#848284' bordercolordark='#eeeeee'
				class="TABLE_STYLE1">
				<tr>
					<td width="80%" class="TD_STYLE1">
						职位分类名称
					</td>
					<td width="20%" class="TD_STYLE1">
						删除
						<input name="indexPage" id="index" type="hidden" value="1" />
					</td>
				</tr>
						<c:choose>
							<c:when test="${positionTypeSize>1}">
								<c:forEach items="${positionType}" var="tpt" end="${positionTypeSize-2}">
									<tr>
										<td class="TD_STYLE2">
											${tpt.positiontypeName}
										</td>
										<td class="TD_STYLE2">
											 <a href="javascript:Delete(${tpt.positiontypeId});">删除</a>
										</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<td colspan="6">当前没有职位分类信息，请先增加！</td>
							</c:otherwise>
						</c:choose>
				
			</table>
			<p>&nbsp;&nbsp;总数：${positionType[positionTypeSize-1].countRows}例 &nbsp;&nbsp;&nbsp;
			当前第 ${positionType[positionTypeSize-1].indexPage} 页  &nbsp;&nbsp;&nbsp;
			共 ${positionType[positionTypeSize-1].countPage} 页  &nbsp;&nbsp;&nbsp;
			跳到第 <input id="goload" name="" value="" onchange="checkpage('${positionType[positionTypeSize-1].countPage}','${positionType[positionTypeSize-1].indexPage}')" type=text class=input1 size=1> 页&nbsp;&nbsp;
			<input type=image src="<%=basePath%>images/go.bmp" width='18' height='18' border='0'>		
			</form>
	</body>
</html>
