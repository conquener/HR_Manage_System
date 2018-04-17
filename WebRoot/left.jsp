<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>无标题文档</title>
		<link rel="stylesheet" href="<%=basePath%>table.css" type="text/css">
		<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.7.2.min.js"></script>
		<style>
a{ CURSOR: hand}
.TreePoint {
	BACKGROUND-POSITION: left 0%; BACKGROUND-IMAGE: url('img/point.gif'); WIDTH: 22px; BACKGROUND-REPEAT: repeat-y
}
.TreeBgColor {
	BACKGROUND-COLOR: #f1f1f1
}
.TreeSign {
	CURSOR: hand
}
.ExplainON {
	FONT-SIZE: 9pt; MARGIN: 10%; CURSOR: hand; COLOR: #000000; FONT-FAMILY: Arial; WHITE-SPACE: nowrap; BACKGROUND-COLOR: #ffffff; TEXT-DECORATION: none
}
.ExplainOFF {
	FONT-SIZE: 9pt; MARGIN: 10%; CURSOR: hand; COLOR: #000000; FONT-FAMILY: Arial; WHITE-SPACE: nowrap; TEXT-DECORATION: none
}
.style1 {
	FONT-SIZE: 12px
}
</style>
	</head>
<script language="javascript">
	function noneORblock1(span_name){
		$("#"+span_name).css("display",(($("#"+span_name).css("display")=='block')?'none':'block'));
	}
	function plusORminus1(span_name,pic_name)
	{	
		$("#"+span_name).css("display")=='block'?($("#"+pic_name).attr("src","<%=basePath%>images/plus22.gif")):($("#"+pic_name).attr("src","<%=basePath%>images/minus33.gif"));
	}
	function plusORminus(span_name,pic_name)
	{
		$("#"+span_name).css("display")=='block'?($("#"+pic_name).attr("src","<%=basePath%>images/plus22.gif")):($("#"+pic_name).attr("src","<%=basePath%>images/minus33.gif"));
	}
	function noneORblock(span_name)
	{
		$("#"+span_name).css("display",(($("#"+span_name).css("display")=='block')?'none':'block'));
	}
	
	
</script>
	<body>
		<table width="100%" border="0">
			<tr>
				<th colspan="2" bgcolor="#1A98F1">
					<font size="+1" color="white">人力资源</font>
				</th>
			</tr>
			<c:forEach items="${sessionScope.permissionUser}" var="plst">	
				<c:if test="${plst.permissionId==1}">
								<!-- 客户化设置 -->
			<tr>
				<td width="2%">
					<a onClick="noneORblock('config')"><img src="images/plus22.gif"
							onClick="plusORminus('config','config_pic')" id="config_pic">
					</a>
				</td>
				<td>
					客户化设置
				</td>
			</tr>
			<tr>
				<td width="2%"></td>
				<td width="98%">
					<div style="DISPLAY:none;" id="config">
						<table width="100%" border="0">
							<tr>
								<td width="2%">
									<a onClick="noneORblock('config_file')"><img
											src="images/plus22.gif"
											onClick="plusORminus('config_file','config_file_pic')"
											id="config_file_pic">
									</a>
								</td>
								<td width="98%">
									人力资源档案管理设置
								</td>
							</tr>
							<tr>
								<td width="2%"></td>
								<td width="98%">
									<div style="DISPLAY:none;" id="config_file">
										<table width="100%" border="0">
											<tr>
												<td width="2%">
													<img src="images/jt0.gif">
												</td>
												<td width="98%">
													<a href="clineset-orginzation/manpower!loadOragan1?level=1"
														target="mainFrame">I级机构设置</a>
												</td>
											</tr>
											<tr>
												<td>
													<img src="images/jt0.gif">
												</td>
												<td>
													<a href="clineset-orginzation/manpower!loadOragan1?level=2"
														target="mainFrame">II级机构设置</a>
												</td>
											</tr>
											<tr>
												<td>
													<img src="images/jt0.gif">
												</td>
												<td>
													<a href="clineset-orginzation/manpower!loadOragan1?level=3" target="mainFrame">III级机构设置</a>
												</td>
											</tr>
											<tr>
												<td>
													<img src="images/jt0.gif">
												</td>
												<td>
													<a href="clineset-profession/profession!loadProfession" target="mainFrame">职称设置</a>
												</td>
											</tr>
											<tr>
												<td>
													<img src="images/jt0.gif">
												</td>
												<td>
													<a href="clineset-profession/positionT!loadPositionType"
														target="mainFrame">职位分类设置</a>
												</td>
											</tr>
											<tr>
												<td>
													<img src="images/jt0.gif">
												</td>
												<td>
													<a href="clineset-profession/position!loadPosition"
														target="mainFrame">职位设置</a>
												</td>
											</tr>
<%--											<tr>--%>
<%--												<td>--%>
<%--													<img src="images/jt0.gif">--%>
<%--												</td>--%>
<%--												<td>--%>
<%--													<a href="clineset-profession/publicPro!loadPublicProperty"--%>
<%--														target="mainFrame">公共属性设置</a>--%>
<%--												</td>--%>
<%--											</tr>--%>
												</table> 
													</div>
											</td>
										
										
							</tr>
							<tr>
								<td>
									<a onClick="noneORblock('config_salary')"><img
											src="images/plus22.gif"
											onClick="plusORminus('config_salary','config_salary_pic')"
											id="config_salary_pic">
									</a>
								</td>
								<td>
									薪酬管理设置
								</td>
							</tr>
							<tr>
								<td width="2%"></td>
								<td width="98%">
									<div style="DISPLAY:none;" id="config_salary">
										<table width="100%" border="0">
											<tr>
												<td width="2%">
													<img src="images/jt0.gif">
												</td>
												<td width="98%">
												<a href="clineset-salary/salaryPro!loadSalaryPro"
														target="mainFrame">
													薪酬项目设置</a>
												</td>
											</tr>
											<tr>
												<td>
													<img src="images/jt0.gif">
												</td>
												<td>
												<a href="clineset-salary/salaryPay!loadSalaryPay"
														target="mainFrame">
													薪酬发放方式设置</a>
												</td>
											</tr>
										</table> </div>
								</td>
							</tr>
						</table> </div>
					</td>
			</tr>
			</c:if>
		<c:if test="${plst.permissionId==2}">
			<!-- 人力资源档案管理设置 -->
			<tr>
				<td>
					<a onClick="noneORblock('human_file')"><img
							src="images/plus22.gif"
							onClick="plusORminus('human_file','human_file_pic')"
							id="human_file_pic">
					</a>
				</td>
				<td>
					人力资源档案管理设置
				</td>
			</tr>
			<tr>
				<td width="2%"></td>
				<td width="98%">
					<div style="DISPLAY:none;" id="human_file">
						<table width="100%" border="0">
							<tr>
								<td width="2%">
									<img src="images/jt0.gif">
								</td>
								<td width="98%">
									<a href="<%=basePath%>renli/human_register.jsp" target="mainFrame">人力资源档案登记</a>
								</td>
							</tr>
							<%--<tr>
								<td>
									<img src="images/jt0.gif">
								</td>
								<td>
									<a href="<%=basePath%>renli/renlimange!checkFileList" target="mainFrame">人力资源档案登记复核</a>
								</td>
							</tr>
							--%><tr>
								<td>
									<img src="images/jt0.gif">
								</td>
								<td>
									<a href="<%=basePath%>renli/query_locate.jsp" target="mainFrame">人力资源档案查询</a>
								</td>
							</tr>
							<tr>
								<td>
									<img src="images/jt0.gif">
								</td>
								<td>
									<a href="<%=basePath%>renli/update_locate.jsp" target="mainFrame">人力资源档案变更</a>
								</td>
							</tr>
							<tr>
								<td>
									<a onClick="noneORblock('human_file_delete')"><img
											src="images/plus22.gif"
											onClick="plusORminus('human_file_delete','human_file_delete_pic')"
											id="human_file_delete_pic">
									</a>
								</td>
								<td>
									人力资源档案删除管理
								</td>
							</tr>
							<tr>
								<td width="2%"></td>
								<td width="98%">
									<div style="DISPLAY:none;" id="human_file_delete">
										<table width="100%" border="0">
											<tr>
												<td width="2%">
													<img src="images/jt0.gif">
												</td>
												<td width="98%">
													<a href="<%=basePath%>renli/delete/delete_locate.jsp" target="mainFrame">人力资源档案删除</a>
												</td>
											</tr>
											<tr>
												<td width="2%">
													<img src="images/jt0.gif">
												</td>
												<td width="98%">
													<a href="<%=basePath%>renli/delete/recovery_locate.jsp" target="mainFrame">档案删除恢复</a>
												</td>
											</tr>
											<tr>
												<td width="2%">
													<img src="images/jt0.gif">
												</td>
												<td width="98%">
													<a href="<%=basePath%>renli/delete/delete_forever_locate.jsp" target="mainFrame">人力资源档案永久删除</a>
												</td>
											</tr>
										</table> </div>
								</td>
							</tr>
						</table> </div>
				</td>
			</tr>
			</c:if>
<c:if test="${plst.permissionId==3}">
			<!-- 薪酬标准管理 -->
			<tr>
				<td class="td_style">
					<a onClick="noneORblock('salary_standard')"><img
							src="images/plus22.gif"
							onClick="plusORminus('salary_standard','salary_standard_pic')"
							id="salary_standard_pic">
					</a>
				</td>
				<td class="td_style">
					薪酬标准管理
				</td>
			</tr>
			<tr>
				<td width="2%"></td>
				<td width="98%">
					<div style="DISPLAY:none;" id="salary_standard">
						<table width="100%" border="0">
							<tr>
								<td width="2%">
									<img src="images/jt0.gif">
								</td>
								<td width="98%">
									<a href="<%=basePath%>salaryStandManage!salarystandardregister" target="mainFrame">薪酬标准登记</a>
								</td>
							</tr>
<%--							<tr>--%>
<%--								<td>--%>
<%--									<img src="images/jt0.gif">--%>
<%--								</td>--%>
<%--								<td>--%>
<%--									<a href="salaryStandManage!salarystandardchecklist" target="mainFrame">薪酬标准登记复核</a>--%>
<%--								</td>--%>
<%--							</tr>--%>
							<tr>
								<td>
									<img src="images/jt0.gif">
								</td>
								<td>
									<a href="salary/salarystandardmanage/salarystandard_query_locate.jsp" target="mainFrame">薪酬标准查询</a>
								</td>
							</tr>
							<tr>
								<td>
									<img src="images/jt0.gif">
								</td>
								<td>
									<a href="salary/salarystandardmanage/salarystandard_change_locate.jsp" target="mainFrame">薪酬标准变更</a>
								</td>
							</tr>
						</table> </div>
				</td>
			</tr>
</c:if>
<c:if test="${plst.permissionId==4}">
			<!-- 薪酬发放管理 -->
			<tr>
				<td class="td_style">
					<a onClick="noneORblock1('salary')"><img src="images/plus22.gif"
							onClick="plusORminus1('salary','salary_pic')" id="salary_pic">
					</a>
				</td>
				<td class="td_style">
					薪酬发放管理
				</td>
			</tr>
			<tr>
				<td width="2%"></td>
				<td width="98%">
					<div style="DISPLAY:none;" id="salary">
						<table width="100%" border="0">
							<tr>
								<td width="2%">
									<img src="images/jt0.gif">
								</td>
								<td width="98%">
									<a href="<%=basePath%>salIssueMan!clicksalarysend" target="mainFrame">薪酬发放登记</a>
								</td>
							</tr>
<%--							<tr>--%>
<%--								<td>--%>
<%--									<img src="images/jt0.gif">--%>
<%--								</td>--%>
<%--								<td>--%>
<%--									<a href="salIssueMan!salarysendcheck" target="mainFrame">薪酬发放登记复核</a>--%>
<%--								</td>--%>
<%--							</tr>--%>
							<tr>
								<td>
									<img src="images/jt0.gif">
								</td>
								<td>
									<a href="salary/salarysendmanage/salarysend_query.jsp" target="mainFrame">薪酬发放查询</a>
								</td>
							</tr>
						</table> </div>
				</td>
			</tr>
</c:if>
<c:if test="${plst.permissionId==5}">
			<!-- 调动管理 -->
			<tr>
				<td class="td_style">
					<a onClick="noneORblock('major_change')"><img
							src="images/plus22.gif"
							onClick="plusORminus('major_change','major_change_pic')"
							id="major_change_pic">
					</a>
				</td>
				<td class="td_style">
					调动管理
				</td>
			</tr>
			<tr>
				<td width="2%"></td>
				<td width="98%">
					<div style="DISPLAY:none;" id="major_change">
						<table width="100%" border="0">
							<tr>
								<td width="2%">
									<img src="images/jt0.gif">
								</td>
								<td width="98%">
								<a href="remove/remove_register.jsp" target="mainFrame">调动登记</a>
								</td>
							</tr>
<%--							<tr>--%>
<%--								<td>--%>
<%--									<img src="images/jt0.gif">--%>
<%--								</td>--%>
<%--								<td>--%>
<%--									<a href="tranmamage!removeregisterfuhequery" target="mainFrame">调动复核</a>--%>
<%--								</td>--%>
<%--							</tr>--%>
							<tr>
								<td>
									<img src="images/jt0.gif">
								</td>
								<td>
									<a href="remove/remove_query.jsp" target="mainFrame">调动查询</a>
								</td>
							</tr>
						</table> </div>
				</td>
			</tr>
</c:if>
<c:if test="${plst.permissionId==6}">
<!-- 系统管理 -->
			<tr>
				<td width="2%">
					<a onClick="noneORblock('sys')"><img src="images/plus22.gif"
							onClick="plusORminus('sys','sys_pic')" id="sys_pic">
					</a>
				</td>
				<td>
					系统管理
				</td>
			</tr>
			<tr>
				<td width="2%"></td>
				<td width="98%">
					<div style="DISPLAY:none;" id="sys">
						<table width="100%" border="0">
							<tr>
								<td width="2%">
									<a onClick="noneORblock('sys_file')"><img
											src="images/plus22.gif"
											onClick="plusORminus('sys_file','sys_file_pic')"
											id="sys_file_pic">
									</a>
								</td>
								<td width="98%">
									用户管理
								</td>
							</tr>
							<tr>
								<td width="2%"></td>
								<td width="98%">
									<div style="DISPLAY:none;" id="sys_file">
										<table width="100%" border="0">
											<tr>
												<td width="2%">
													<img src="images/jt0.gif">
												</td>
												<td width="98%">
													<a href="./system/user/register.jsp"
														target="mainFrame">添加用户</a>
												</td>
											</tr>
											<tr>
												<td>
													<img src="images/jt0.gif">
												</td>
												<td>
													<a href="<%=basePath%>systemManage!userquery"
														target="mainFrame">用户维护</a>
												</td>
											</tr>
											
											
										</table> </div>
								</td>
							</tr>
							
							<tr>
								<td>
									<a onClick="noneORblock('roleset_salary')"><img
											src="images/plus22.gif"
											onClick="plusORminus('roleset_salary','roleset_salary_pic')"
											id="roleset_salary_pic">
									</a>
								</td>
								<td>
									角色设置管理
								</td>
							</tr>
							<tr>
								<td width="2%"></td>
								<td width="98%">
									<div style="DISPLAY:none;" id="roleset_salary">
										<table width="100%" border="0">
											<tr>
												<td width="2%">
													<img src="images/jt0.gif">
												</td>
												<td width="98%">
													<a href="./system/roleset/roleset_add.jsp" target="mainFrame">添加角色设置</a>
												</td>
											</tr>
											<tr>
												<td>
													<img src="images/jt0.gif">
												</td>
												<td>
													<a href="systemManage!rolesetselect" target="mainFrame">角色设置维护</a>
												</td>
											</tr>
							
										</table> </div>
								</td>
							</tr>
							<tr>
								<td>
									<a onClick="noneORblock('role_salary')"><img
											src="images/plus22.gif"
											onClick="plusORminus('role_salary','role_salary_pic')"
											id="role_salary_pic">
									</a>
								</td>
								<td>
									角色管理
								</td>
							</tr>
							<tr>
								<td width="2%"></td>
								<td width="98%">
									<div style="DISPLAY:none;" id="role_salary">
										<table width="100%" border="0">
											<tr>
												<td width="2%">
													<img src="images/jt0.gif">
												</td>
												<td width="98%">
													<a href="./system/role/role_add.jsp" target="mainFrame">添加角色</a>
												</td>
											</tr>
											<tr>
												<td>
													<img src="images/jt0.gif">
												</td>
												<td>
													<a href="<%=basePath %>systemManage!rolesafeguardquery" target="mainFrame">角色维护</a>
												</td>
											</tr>
											
											
										</table> </div>
								</td>
							</tr>



							<tr>
								<td>
									<a onClick="noneORblock('powerset_salary')"><img
											src="images/plus22.gif"
											onClick="plusORminus('powerset_salary','powerset_salary_pic')"
											id="powerset_salary_pic">
									</a>
								</td>
								<td>
									权限设置管理
								</td>
							</tr>
							<tr>
								<td width="2%"></td>
								<td width="98%">
									<div style="DISPLAY:none;" id="powerset_salary">
										<table width="100%" border="0">
											<tr>
												<td width="2%">
													<img src="images/jt0.gif">
												</td>
												<td width="98%">
													<a href="systemManage!newauthodesignadd" target="mainFrame">添加权限设置</a>
												</td>
											</tr>
											<tr>
												<td>
													<img src="images/jt0.gif">
												</td>
												<td>
													<a href="systemManage!newauthdesignquery" target="mainFrame">权限设置维护</a>
												</td>
											</tr>
											
										
											
										</table> </div>
								</td>
							</tr>
							<tr>
								<td>
									<a onClick="noneORblock('password_salary')"><img
											src="images/plus22.gif"
											onClick="plusORminus('password_salary','password_salary_pic')"
											id="password_salary_pic">
									</a>
								</td>
								<td>
									修改密码
								</td>
							</tr>
							<tr>
								<td width="2%"></td>
								<td width="98%">
									<div style="DISPLAY:none;" id="password_salary">
										<table width="100%" border="0">
											<tr>
												<td width="2%">
													<img src="images/jt0.gif">
												</td>
												<td width="98%">
													<a href="<%=basePath %>system/change_password/change_password.jsp" target="mainFrame">修改密码</a>
												</td>
											</tr>	
										</table> 
									</div>
								</td>
							</tr>
						</table> </div>
				</td>
			</tr>
			</c:if>
			</c:forEach>
		</table>
	</body>
</html>
