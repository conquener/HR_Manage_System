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
		<link rel="stylesheet" href="<%=basePath %>table.css" type="text/css">
		<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
		function pagesubmit(){
			var index = $("#selectPage").val();
			$("#form1").attr("action","<%=basePath%>tranmamage!stafftranquery?indexPage="+index);
			$("#form1").submit();
		}
	
		function checkPage(){
			var index =$("#selectPage").val();
			if(!/^[0-9.-]*$/.test(index)){
				$("#selectPage").val('${tranquerylistpage.indexPage}');
				alert('请输入数字!');
			}else if(Number(index)<1){
				$("#selectPage").val('${tranquerylistpage.indexPage}');
				alert('页码必须大于1!');
			}else if(Number(index)>${tranquerylistpage.countPage}){
				$("#selectPage").val('${tranquerylistpage.indexPage}');
				alert('页码必须小于最大页码!');
			}
		}
	</script>
	</head>

	<body>
		<form name="humanfileForm" method="post" action="">
			<table width="100%">
				<tr>
					<td>
					<input type="hidden" value="begintrantime" name="begintrantime">
					<input type="hidden" value="endtrantime" name="endtrantime">
					<input type="hidden" value="tranPerosonName" name="tranPerosonName"> 
						<font color="#0000CC">您正在做的业务是：人力资源--调动管理--调动管理查询 </font>
					</td>
				</tr>
				<tr>
					<td>
						当前查出来的调动人员总数：
						${tranquerylistpage.countRows}
						个
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr class="TR_STYLE1">
					<td width="13%" class="TD_STYLE1">
						调动编号
					</td>
					<td width="13%" class="TD_STYLE1">
						姓名
					</td>
					<td width="11%" class="TD_STYLE1">
						性别
					</td>
					<td width="14%" class="TD_STYLE1">
						调动时间
					</td>
					<td width="14%" class="TD_STYLE1">
						调动性质
					</td>
					<td width="14%" class="TD_STYLE1">
						调动状态
					</td>
					<td width="14%" class="TD_STYLE1">
						调动详情
					</td>
					
				</tr>
					<c:forEach items="${requestScope.tranquerylist}" var="s">
					<tr>
						<td class="TD_STYLE2">
							${s.transferid}
						</td>
						<td class="TD_STYLE2">
							${s.filesUserName}
						</td>
						<td class="TD_STYLE2">
							未知
						</td>
						<td class="TD_STYLE2">
							${s.Transferdate}
						</td>
						<td class="TD_STYLE2">
							${s.transactionnature}
						</td>
						<td class="TD_STYLE2">
							${s.Viewsstatus}/已调动
						</td>
						<td class="TD_STYLE2">
							<a href="tranmamage!removequerydetails?stafftransId=${s.transferid}">详情</a>
						</td>
					</tr>
					</c:forEach>
				
			</table>
			<p>&nbsp;&nbsp;总数：${tranquerylistpage.countRows}例 &nbsp;&nbsp;&nbsp;当前第 ${tranquerylistpage.indexPage} 页  &nbsp;&nbsp;&nbsp;共 ${tranquerylistpage.countPage } 页  &nbsp;&nbsp;&nbsp;跳到第 <input onchange="checkPage()" name="queryindexPage" value="${tranquerylistpage.indexPage }" id="selectPage" type=text class=input1 size=1> 页&nbsp;&nbsp;<input onclick="pagesubmit()" type=image src="<%=basePath%>images/go.bmp" width=18 height=18 border=0>
		</form>
	</body>
</html>
