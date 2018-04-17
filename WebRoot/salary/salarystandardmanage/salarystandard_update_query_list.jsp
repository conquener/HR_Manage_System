<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="<%=basePath %>table.css" type="text/css" />
		<title>无标题文档</title>
		<style type="text/css">
<!--
.style3 {color: #0000CC}
-->
</style>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	function pagesubmit(){
		var index = $("#selectPage").val();
		$("#form1").attr("action","<%=basePath%>salaryStandManage!salarystandardchangresult?indexPage="+index);
		$("#form1").submit();
	}

	function checkPage(){
		var index =$("#selectPage").val();
		if(!/^[0-9.-]*$/.test(index)){
			$("#selectPage").val('${querypage.indexPage}');
			alert('请输入数字!');
		}else if(Number(index)<1){
			$("#selectPage").val('${querypage.indexPage}');
			alert('页码必须大于1!');
		}else if(Number(index)>${querypage.countPage}){
			$("#selectPage").val('${querypage.indexPage}');
			alert('页码必须小于最大页码!');
		}
	}
</script>
</head>
	<body>
		<form method="post" action="" id="form1">
			<table width="100%">
				<tr>
					<td>
						<input type="hidden" name="startTime" value="${requestScope.startTime}"/>
						<input type="hidden" name="endTime" value="${requestScope.endTime}"/>
						<input type="hidden" name="standName" value="${requestScope.standName}"/>
						<font color="#0000CC">您正在做的业务是:人力资源管理--薪酬标准管理--薪酬标准变更</font>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						当前薪酬标准总数:
						${requestScope.querypage.countRows}
						例
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="10%" class="TD_STYLE1">
						<span>薪酬标准编号</span>
					</td>
					<td width="10%" class="TD_STYLE1">
						<span>薪酬标准名称</span>
					</td>
					<td width="16%" class="TD_STYLE1">
		  					    薪酬总额
					</td>
                    <td width="12%" class="TD_STYLE1">
						<span>制定人</span>
					</td>
					<td width="14%" class="TD_STYLE1">
						<span>登记人</span>
					</td>
                    <td width="16%" class="TD_STYLE1">
						登记时间
					</td>
					<td width="12%" class="TD_STYLE1">
						操作
					</td>
					</tr>
					<c:forEach items="${requestScope.salarystandlst}" var="s">
					<tr class="TD_STYLE2">
						<td>
							${s.salarystanderdId}
						</td>
						<td>
							${s.salarystanderdName}
						</td>
						<td>
							${s.salarySummoney}
						</td>
						<td>
							${s.maker}
                        </td>
						<td>
							${s.register}
						</td>
						<td>
							${s.registertime}
						</td>
                   		 <td>
							<a href="<%=basePath%>salaryStandManage!salarystandupdate?salarystandcheckId=${s.salarystanderdId}">更改</a>
                		</td>
					</tr>
					</c:forEach>
			</table>
			<p>&nbsp;&nbsp;总数：${querypage.countRows}例 &nbsp;&nbsp;&nbsp;
			当前第 ${querypage.indexPage}页  &nbsp;&nbsp;&nbsp;
			共 ${querypage.countPage}页  &nbsp;&nbsp;&nbsp;
			跳到第 <input name="standcheckindexpage" type="text" class="input1" id="selectPage" onblur="checkPage()" size="1" value="${querypage.indexPage}" /> 页&nbsp;&nbsp;
			<input type="image" src="<%=basePath%>images/go.bmp" width="18" height="18" border="0" onclick="pagesubmit();">
		</form>
	</body>
</html>
