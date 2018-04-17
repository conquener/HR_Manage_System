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
		<script type="text/javascript">
			function Delete(id)
			{
				if(confirm("确定要删除吗？")) {
					location.href = "deleteOrgan3!deleteOrgan2?oraganId=" + id;
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
		<form method="post" action="manpower!loadOragan1?level=2">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--III级机构设置
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="添加" class="BUTTON_STYLE1"
							onclick="window.location.href='updateLoad2!querySecondOra'" />
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="18%" class="TD_STYLE1">
						II级机构编号
					</td>
					<td width="18%" class="TD_STYLE1">
						II级机构名称
					</td>
					<td width="18%" class="TD_STYLE1">
						上级机构名称
					</td>
					<td width="18%" class="TD_STYLE1">
						薪酬发放责任人编号
					</td>
					<td width="18%" class="TD_STYLE1">
						销售责任人编号
					</td>
					<td width="5%" class="TD_STYLE1">
						<input name="indexPage" id="index" type="hidden" value="1" />
						变更
					</td>
					<td width="5%" class="TD_STYLE1">
						删除
					</td>
				</tr>
						<c:choose>
							<c:when test="${OrganizationSize>1}">
								<c:forEach items="${Organization}" var="o" end="${OrganizationSize-2}">
									<tr>
										<td class="TD_STYLE2">
											${o.oraganId}
										</td>
										<td class="TD_STYLE2">
											${o.oraganName}
										</td>
										<td class="TD_STYLE2">
											${o.parentId}
										</td>
										<td class="TD_STYLE2">
											${o.salarypaypersonId}
										</td>
										<td class="TD_STYLE2">
											${o.salepersonId}
										</td>
										<td class="TD_STYLE2">
											<a href="changeLoad3!queryOraganById3?oraganId=${o.oraganId}">变更</a>
										</td>
										<td class="TD_STYLE2">
											<a href="javascript:Delete(${o.oraganId});">删除</a>
										</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<td colspan="6">当前没有机构，请先增加机构！</td>
							</c:otherwise>
						</c:choose>
			</table>
			<p>&nbsp;&nbsp;总数：${Organization[OrganizationSize-1].countRows}例 &nbsp;&nbsp;&nbsp;
			当前第 ${Organization[OrganizationSize-1].indexPage} 页  &nbsp;&nbsp;&nbsp;
			共 ${Organization[OrganizationSize-1].countPage} 页  &nbsp;&nbsp;&nbsp;
			跳到第 <input id="goload" name="" value="" onchange="checkpage('${Organization[OrganizationSize-1].countPage}','${Organization[OrganizationSize-1].indexPage}')" type=text class=input1 size=1> 页&nbsp;&nbsp;
			<input type=image src="<%=basePath%>images/go.bmp" width=18 height=18 border=0>		</form>
	</body>
</html>
