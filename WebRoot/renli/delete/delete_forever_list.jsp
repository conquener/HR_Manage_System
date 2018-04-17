<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<script type="text/javascript">
function toCheck()
{
	$("#humanfileForm").attr("action","<%=basePath%>renli/renlimange!queryFileListDeleted?index=2");
	$("#humanfileForm").submit();
}

function onclickLink(fileId){
	if(!window.confirm("确定要删除吗?永久删除后无法恢复文挡!")){
		return;
	}
	var path = "<%=basePath%>";
	$("#humanfileForm").attr("action",path+"renli/renlimange!deleteForeverRenliFile?fileId="+fileId);
	$("#humanfileForm").submit();
}
function changeIndex(){
	var index = $("input[name='index']").val();
	if(!/^[0-9.-]*$/.test(index)){
		$("input[name='index']").val(${page.indexPage});
		alert('请输入数字!');
		return;
	}
	if(index<1){
		$("input[name='index']").val(${page.indexPage});
		alert('页码不能小于1')
		return;
	}
	if(index>${page.countPage}){
		$("input[name='index']").val(${page.indexPage});
		alert('页码不能大于最大页')
		return;
	}
	$("#indexPage").val(index);
}
 
</script>
	</head>

	<body>
		<form id="humanfileForm"  name="humanfileForm" method="post" action="<%=basePath%>renli/renlimange!queryFileList?index=1">
			<table width="100%">
				<tr>
					<td>
						<input type="hidden" name="queryFiles.fristorganization" value="${queryFiles.fristorganization}">
						<input type="hidden" name="queryFiles.threeorganization" value="${queryFiles.threeorganization}">
						<input type="hidden" name="queryFiles.twoorganization" value="${queryFiles.twoorganization}">
						<input type="hidden" name="queryFiles.startTime" value="${queryFiles.startTime}">
						<input type="hidden" name="queryFiles.endTime" value="${queryFiles.endTime}">
						<input type="hidden" id="indexPage" name="queryFiles.indexPage" value="${queryFiles.indexPage}">
						<font color="#0000CC">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案删除 </font>
					</td>
				</tr>
				<tr>
					<td>
						符合查询条件的人力资源档案总数：
						${page.countRows}
						例
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr class="TR_STYLE1">
					<td width="15%" class="TD_STYLE1">
						姓名
					</td>
					<td width="14%" class="TD_STYLE1">
						性别
					</td>
					<td width="16%" class="TD_STYLE1">
						I级机构
					</td>
					<td width="16%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="16%" class="TD_STYLE1">
						III级机构
					</td>
					<td width="16%" class="TD_STYLE1">
						职称
					</td>
					<td width="10%" class="TD_STYLE1">
						查询
					</td>
				</tr>
					<c:forEach items="${tfiles}" var="t">
						<tr>
							<td class="TD_STYLE2">
								${t.FILESUSERNAME}
							</td>
							<td class="TD_STYLE2">
								${t.FILESSEX}
							</td>
							<td class="TD_STYLE2">
								${t.NAME1}
							</td>
							<td class="TD_STYLE2">
								${t.NAME2}
							</td>
							<td class="TD_STYLE2">
								${t.NAME3 }
							</td>
							<td class="TD_STYLE2">
								${t.NAME4}
							</td>
							<td class="TD_STYLE2">
								<a href="javascript:onclickLink(${t.FILESFILESID})">删除</a>
							</td>
						</tr>
					</c:forEach>
			</table>
		</form>
			<p>&nbsp;&nbsp;总数：${page.countRows}例 &nbsp;&nbsp;&nbsp;
			当前第 ${page.indexPage} 页  &nbsp;&nbsp;&nbsp;
			共 ${page.countPage} 页  &nbsp;&nbsp;&nbsp;
			跳到第 <input onchange="changeIndex()" name="index" value="${page.indexPage}" type=text class=input1 size=1> 页&nbsp;&nbsp;
			<input type="image" src="<%=basePath %>images/go.bmp" onclick="toCheck()" width=18 height=18 border=0>
	</body>
</html>
