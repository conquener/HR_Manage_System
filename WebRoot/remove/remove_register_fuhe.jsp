<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="<%=basePath %>table.css" type="text/css">
	</head>
	<body>
	<form action="humanfile.do" method="post">
		<table width="100%">
			<tr>
				<td>
					<font color="#0000CC">您正在做的业务是：人力资源--调动管理--调动复核 </font>
				</td>
			</tr>
			<tr>
				<td>
					符合条件的人力资源档案总数：${requestScope.transpersonpage.countRows}例
				</td>
			</tr>
		</table>
		<table width="100%" border="1" cellpadding=0 cellspacing=1
			bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
			<tr class="TR_STYLE1">
				<td width="13%" class="TD_STYLE1">
					用户编号
				</td>
				<td width="11%" class="TD_STYLE1">
					姓名
				</td>
				<td width="6%" class="TD_STYLE1">
					性别
				</td>
				<td width="12%" class="TD_STYLE1">
					I级机构编号
				</td>
				<td width="12%" class="TD_STYLE1">
					II级机构编号
				</td>
				<td width="12%" class="TD_STYLE1">
					III级机构编号
				</td>
				<td width="12%" class="TD_STYLE1">
					职位分类编号
				</td>
				<td width="7%" class="TD_STYLE1">
					职位名称
				</td>
				<td width="8%" class="TD_STYLE1">
					复核
				</td>
			</tr>
			<c:choose>
				<c:when test="${requestScope.transpersonpage.countRows>=1}">
				<c:forEach items="${requestScope.transpersonList}" var="f">
					<tr class="TR_STYLE1">
						<td width="13%" class="TD_STYLE1">
							${f.filesuserid}
						</td>
						<td width="11%" class="TD_STYLE1">
							${f.filesuserName }
						</td>
						<td width="6%" class="TD_STYLE1">
							未知的性别
						</td>
						<td width="12%" class="TD_STYLE1">
							${f.ilesFirstOrganization }
						</td>
						<td width="12%" class="TD_STYLE1">
							${f.filesSecondOrganization }
						</td>
						<td width="12%" class="TD_STYLE1">
							${f.filesThirdOrganization }
						</td>
						<td width="12%" class="TD_STYLE1">
							${f.filesPositionClassify}
						</td>
						<td width="7%" class="TD_STYLE1">
							${f.fielsPositionName }
						</td>
						<td width="8%" class="TD_STYLE1">
							<a href="tranmamage!removecheckregister2?staffUserid=${f.filesuserid}">复核</a>
						</td>
					</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr><td colspan="9">
					所有的数据已经复核完毕!
					</td></tr>
				</c:otherwise>
			</c:choose>
			
		</table>
		<p>&nbsp;&nbsp;总数：${requestScope.transpersonpage.countRows}例 &nbsp;&nbsp;&nbsp;当前第 ${requestScope.fuhequeryIndexPage} 页  &nbsp;&nbsp;&nbsp;共 ${requestScopetranspersonpage.countPage} 页  &nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1> 页&nbsp;&nbsp;<input type=image src="../images/go.bmp" width=18 height=18 border=0>
	</form>
	</body>
</html>
