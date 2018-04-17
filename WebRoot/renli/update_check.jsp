<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="<%=basePath %>table.css" type="text/css">
		<link rel="stylesheet" type="text/css" media="all"
			href="<%=basePath %>javascript/calendar/calendar-win2k-cold-1.css">
		<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="<%=basePath %>javascript/calendar/cal.js"></script>
		<script type="text/javascript" src="<%=basePath %>javascript/comm/comm.js"></script>
		<script language="javascript" src="<%=basePath %>javascript/winopen/winopenm.js"></script>
		<script language="javascript" type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
		<script language="javascript" type="text/javascript" src="<%=basePath%>My97DatePicker/calendar.js"></script>
		<link href="<%=basePath%>My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css">
		<script type="text/javascript">
		function getFristOrginzation(){
			$.ajax({
				url:'<%=basePath%>renli/renlimange!getOrainzation',
				dataType:'json',
				data:{parentOrginzation:0},
				type:'post',
				success:function(data){
					var s = "<option value='-1'>--请选择--</option>";
					for(var i=0,length=data.length;i<length;i++){
						if('${fileDetails.NAME1}'==data[i].oraganName){
							s+="<option selected='selected' value='"+data[i].oraganId+"'>"+data[i].oraganName+"</option>";
						}else{
							s+="<option value='"+data[i].oraganId+"'>"+data[i].oraganName+"</option>";
						}
					}
					debugger
						$("#select1").html(s);
						getSecondOrginzation();
						setTimeout("getThirdOrginzation();",500);
						
				}
			});
			$.ajax({
				url:'<%=basePath%>renli/renlimange!getPositionType',
				dataType:'json',
				data:{},
				type:'post',
				success:function(data){
					var s = "<option value='-1'>--请选择--</option>";
					for(var i=0,length=data.length;i<length;i++){
						if('${fileDetails.POSITIONTYPENAME}'==data[i].positiontypeName){
							s+="<option selected='selected' value='"+data[i].positiontypeId+"'>"+data[i].positiontypeName+"</option>";
						}else{
							s+="<option value='"+data[i].positiontypeId+"'>"+data[i].positiontypeName+"</option>";
						}
					}
						$("#select4").html(s);
						getPosition();
				}
			});
			$.ajax({
				url:'<%=basePath%>renli/renlimange!getProfessional',
				dataType:'json',
				data:{},
				type:'post',
				success:function(data){
					var s = "<option value='-1'>--请选择--</option>";
					for(var i=0,length=data.length;i<length;i++){
						if('${fileDetails.NAME4}'==data[i].professionalName){
							s+="<option selected='selected' value='"+data[i].professionalId+"'>"+data[i].professionalName+"</option>";
						}else{
							s+="<option value='"+data[i].professionalId+"'>"+data[i].professionalName+"</option>";
						}
					}
						$("#select6").html(s);
				}
			});
			$.ajax({
				url:'<%=basePath%>renli/renlimange!getSalarystander',
				dataType:'json',
				data:{},
				type:'post',
				success:function(data){
					var s = "<option value='-1'>--请选择--</option>";
					for(var i=0,length=data.length;i<length;i++){
						if(${fileDetails.SALARYSTANDERDID}==data[i].salarystanderdId){
							s+="<option selected='selected' value='"+data[i].salarystanderdId+"'>"+data[i].salarystanderdName+"</option>";
						}else{
							s+="<option value='"+data[i].salarystanderdId+"'>"+data[i].salarystanderdName+"</option>";
						}
					}
						$("#select7").html(s);
				}
			});
			
		}
		
		function getPosition(){
			var positionTypeId = $("#select4").val();
			if(positionTypeId==-1){
				return;
			}
			$.ajax({
				url:'<%=basePath%>renli/renlimange!getPosition',
				dataType:'json',
				data:{positionTypeId:positionTypeId},
				type:'post',
				success:function(data){
					var s = "<option value='-1'>--请选择--</option>";
					for(var i=0,length=data.length;i<length;i++){
						if('${fileDetails.POSITIONNAME}'==data[i].positionName){
							s+="<option selected='selected' value='"+data[i].positionId+"'>"+data[i].positionName+"</option>";
						}else{
							s+="<option value='"+data[i].positionId+"'>"+data[i].positionName+"</option>";
						}
					}
					$("#select5").html(s);
				}
			});
		}
		
		
		function getSecondOrginzation(){
			var parentId = $("#select1").val();
			if(parentId==-1){
				return;
			}
			$.ajax({
				url:'<%=basePath%>renli/renlimange!getOrainzation',
				dataType:'json',
				data:{parentOrginzation:parentId},
				type:'post',
				success:function(data){
					var s = "<option value='-1'>--请选择--</option>";
					for(var i=0,length=data.length;i<length;i++){
						if(${fileDetails.FILESSECONDORGANIZATION}==data[i].oraganId){
							s+="<option selected='selected' value='"+data[i].oraganId+"'>"+data[i].oraganName+"</option>";
						}else{
							s+="<option value='"+data[i].oraganId+"'>"+data[i].oraganName+"</option>";
						}
					}
						$("#select2").html(s);
				}
			});
		}
		function getThirdOrginzation(){
			var parentId = $("#select2").val();
			if(parentId==-1){
				return;
			}
			$.ajax({
				url:'<%=basePath%>renli/renlimange!getOrainzation',
				dataType:'json',
				data:{parentOrginzation:parentId},
				type:'post',
				success:function(data){
					var s = "<option value='-1'>--请选择--</option>";
					for(var i=0,length=data.length;i<length;i++){
						if(${fileDetails.FILESTHIRDORGANIZATION}==data[i].oraganId){
							s+="<option selected='selected' value='"+data[i].oraganId+"'>"+data[i].oraganName+"</option>";
						}else{
							s+="<option value='"+data[i].oraganId+"'>"+data[i].oraganName+"</option>";
						}
					}
						$("#select3").html(s);
				}
			});
		}
		
		</script>
	</head>

	<body onload="getFristOrginzation()">
	
		<form name="humanfileForm" method="post" action="<%=basePath%>renli/renlimange!renliFileUpdate">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案变更 </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="变更" class="BUTTON_STYLE1" onclick="toUpLoadPhoto2('check');">
						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick="history.back()">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1" width="10%">
						档案编号
					</td>
					<td colspan="6" class="TD_STYLE2">
						<input type="hidden" name="file.filesFilesid" value="${fileDetails.FILESFILESID}">
						${fileDetails.FILESFILESID}
					</td>
					<td rowspan="6" width="13%">
						<img src="">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1" width="10%">
						I级机构
					</td>
					<td width="13%" class="TD_STYLE2">
						<select id="select1" onchange="getSecondOrginzation()" name="file.filesFirstOrganization" class="SELECT_STYLE1">
						</select>
					</td>
					<td width="10%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="13%" class="TD_STYLE2">
						<select id="select2" onchange="getThirdOrginzation()" name="file.filesSecondOrganization" class="SELECT_STYLE1">
							<option value='-1'>--请选择一级机构--</option>
						</select>
					</td>
					<td width="10%" class="TD_STYLE1">
						III级机构
					</td>
					<td class="TD_STYLE2" colspan="2" width="2%" >
						<select id="select3"  name="file.filesThirdOrganization" class="SELECT_STYLE1">
							<option value='-1'>--请选择二级机构--</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						职位分类
					</td>
					<td class="TD_STYLE2">
						<select id="select4" onchange="getPosition()" name="file.filesPositionClassify" class="SELECT_STYLE1">
						</select>
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td class="TD_STYLE2">
						<select id="select5" name="file.filesPositionName" class="SELECT_STYLE1">
							<option value='-1'>--请选择职位分类--</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						职称
					</td>
					<td colspan="2" class="TD_STYLE2">
						<select id="select6" name="file.filesProfessionalTitle" class="SELECT_STYLE1">
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						姓名
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="file.filesUserName" value="${fileDetails.FILESUSERNAME}" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						性别
					</td>
					<td class="TD_STYLE2">
						<select name="file.filesSex" class="SELECT_STYLE1">
							<option value="女" <c:if  test="${fileDetails.FILESSEX=='女'}">selected='selected'</c:if>>女</option>
							<option value="男" <c:if  test="${fileDetails.FILESSEX=='男'}">selected='selected'</c:if>>男</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						EMAIL
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="file.filesEmail" value="${fileDetails.FILESEMAIL}" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						电话
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="file.filesPhone" value="${fileDetails.FILESPHONE}" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						QQ
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="file.filesQq" value="${fileDetails.FILESQQ}" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						手机
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="file.filesTelphone" value="${fileDetails.FILESTELPHONE}" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						住址
					</td>
					<td colspan="3" class="TD_STYLE2">
						<input type="text" name="file.filesAddress" value="${fileDetails.FILESADDRESS}" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						邮编
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="file.filesPostcode" value="${fileDetails.FILESPOSTCODE}" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						国籍
					</td>
					<td class="TD_STYLE2">
						<select name="file.filesNationality" class="SELECT_STYLE1">
							<option value="中国" <c:if  test="${fileDetails.FILESNATIONALITY=='中国'}">selected='selected'</c:if>>中国</option>
							<option value="美国" <c:if  test="${fileDetails.FILESNATIONALITY=='美国'}">selected='selected'</c:if>>美国</option>		
						</select>
					</td>
					<td class="TD_STYLE1">
						出生地
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="file.filesBirthplace" value="${fileDetails.FILESBIRTHPLACE}" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						生日
					</td>
					<td width="13%" class="TD_STYLE2">
						<input type="text" name="file.filesBirthday" onclick="WdatePicker();" value="${fileDetails.FILESBIRTHDAY}" class="INPUT_STYLE2" id="date_start">
					</td>
					<td width="10%" class="TD_STYLE1">
						民族
					</td>
					<td class="TD_STYLE2">
						<select name="file.filesNation" class="SELECT_STYLE1">
								<option value="汉族" <c:if  test="${fileDetails.FILESNATION=='汉族'}">selected='selected'</c:if>>汉族</option>
								<option value="满族" <c:if  test="${fileDetails.FILESNATION=='满族'}">selected='selected'</c:if>>满族</option>
								<option value="蒙古族" <c:if  test="${fileDetails.FILESNATION=='蒙古族'}">selected='selected'</c:if>>蒙古族</option>
								<option value="回族" <c:if  test="${fileDetails.FILESNATION=='回族'}">selected='selected'</c:if>>回族</option>
								<option value="藏族" <c:if  test="${fileDetails.FILESNATION=='藏族'}">selected='selected'</c:if>>藏族</option>
								<option value="其他" <c:if  test="${fileDetails.FILESNATION=='其他'}">selected='selected'</c:if>>其他</option>		
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						宗教信仰
					</td>
					<td class="TD_STYLE2">
						<select name="file.filesFaith" class="SELECT_STYLE1">
							<option value="无" <c:if  test="${fileDetails.FILESFAITH=='无'}">selected='selected'</c:if>>无</option>
							<option value="佛教" <c:if  test="${fileDetails.FILESFAITH=='佛教'}">selected='selected'</c:if>>佛教</option>
							<option value="道教" <c:if  test="${fileDetails.FILESFAITH=='道教'}">selected='selected'</c:if>>道教</option>
							<option value="基督教" <c:if  test="${fileDetails.FILESFAITH=='基督教'}">selected='selected'</c:if>>基督教</option>
							<option value="伊斯兰教" <c:if  test="${fileDetails.FILESFAITH=='伊斯兰教'}">selected='selected'</c:if>>伊斯兰教</option>
							<option value="神龙教" <c:if  test="${fileDetails.FILESFAITH=='神龙教'}">selected='selected'</c:if>>神龙教</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						政治面貌
					</td>
					<td class="TD_STYLE2">
						<select name="file.filesPoliticsStatus" class="SELECT_STYLE1">
							<option value="党员" <c:if  test="${fileDetails.FILESPOLITICSSTATUS=='党员'}">selected='selected'</c:if>>党员</option>
							<option value="群众" <c:if  test="${fileDetails.FILESPOLITICSSTATUS=='群众'}">selected='selected'</c:if>>群众</option>
							<option value="群众" <c:if  test="${fileDetails.FILESPOLITICSSTATUS=='共青团员'}">selected='selected'</c:if>>共青团员</option>
							<option value="少先队员" <c:if  test="${fileDetails.FILESPOLITICSSTATUS=='少先队员'}">selected='selected'</c:if>>少先队员</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						身份证号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="file.filesIdcard" value="${fileDetails.FILESIDCARD}" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						社会保障号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="file.filesSocialInsurancePhone" value="${fileDetails.FILESSOCIALINSURANCEPHONE}" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="file.filesAge" value="${fileDetails.FILESAGE}" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						学历
					</td>
					<td class="TD_STYLE2">
						<select name="file.filesEducation" class="SELECT_STYLE1">
							<option value="本科" <c:if  test="${fileDetails.FILESEDUCATION=='本科'}">selected='selected'</c:if>>本科</option>
							<option value="硕士" <c:if  test="${fileDetails.FILESEDUCATION=='硕士'}">selected='selected'</c:if>>硕士</option>
							<option value="大专" <c:if  test="${fileDetails.FILESEDUCATION=='大专'}">selected='selected'</c:if>>大专</option>
							<option value="博士" <c:if  test="${fileDetails.FILESEDUCATION=='博士'}">selected='selected'</c:if>>博士</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						教育年限
					</td>
					<td class="TD_STYLE2">
						<select name="file.filesEducationAge" class="SELECT_STYLE1">
							<option value="16" <c:if  test="${fileDetails.FILESEDUCATIONAGE=='16'}">selected='selected'</c:if>>16</option>
							<option value="15" <c:if  test="${fileDetails.FILESEDUCATIONAGE=='15'}">selected='selected'</c:if>>15</option>
							<option value="18" <c:if  test="${fileDetails.FILESEDUCATIONAGE=='18'}">selected='selected'</c:if>>16年以上</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td class="TD_STYLE2">
						<input name="file.filesEducationMajor"  value="${fileDetails.FILESEDUCATIONMAJOR}" type="text" /> 
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						薪酬标准
					</td>
					<td class="TD_STYLE2">
						<select  id="select7" name="file.salarystanderdId" class="SELECT_STYLE1"><option value="0/未定义">0/未定义</option></select>
					</td>
					<td class="TD_STYLE1">
						开户行
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="file.filesOpeningBank" value="${fileDetails.FILESOPENINGBANK}" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						帐号
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="file.filesAccountNumber" value="${fileDetails.FILESACCOUNTNUMBER}" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						复核人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="file.filesRegisterPeople" value="${fileDetails.FILESREGISTERPEOPLE}" readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						复核时间
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="file.filesFilingTime" value="${fileDetails.FILESPHONE}" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						特长
					</td>
					<td class="TD_STYLE2">
						<select name="file.filesAptitude" class="SELECT_STYLE1">
								<option value="java" <c:if  test="${fileDetails.FILESAPTITUDE=='java'}">selected='selected'</c:if>>java</option>
								<option value="数据库" <c:if  test="${fileDetails.FILESAPTITUDE=='数据库'}">selected='selected'</c:if>>数据库</option>
								<option value="c++" <c:if  test="${fileDetails.FILESAPTITUDE=='c++'}">selected='selected'</c:if>>c++</option>
								<option value="c语言" <c:if  test="${fileDetails.FILESAPTITUDE=='c语言'}">selected='selected'</c:if>>c语言</option>
								<option value=".net" <c:if  test="${fileDetails.FILESAPTITUDE=='.net'}">selected='selected'</c:if>>.net</option>
								<option value="php" <c:if  test="${fileDetails.FILESAPTITUDE=='php'}">selected='selected'</c:if>>php</option>
								<option value="javascript" <c:if  test="${fileDetails.FILESAPTITUDE=='javascript'}">selected='selected'</c:if>>javascript</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						爱好
					</td>
					<td class="TD_STYLE2">
						<select name="file.filesHobby" class="SELECT_STYLE1">
							<option value="篮球" <c:if  test="${fileDetails.FILESHOBBY=='篮球'}">selected='selected'</c:if>>篮球</option>
							<option value="书法" <c:if  test="${fileDetails.FILESHOBBY=='书法'}">selected='selected'</c:if>>书法</option>
							<option value="足球" <c:if  test="${fileDetails.FILESHOBBY=='足球'}">selected='selected'</c:if>>足球</option>
							<option value="摄影"<c:if  test="${fileDetails.FILESHOBBY=='摄影'}">selected='selected'</c:if>>摄影</option>
							<option value="网球" <c:if  test="${fileDetails.FILESHOBBY=='网球'}">selected='selected'</c:if>>网球</option>
							<option value="乒乓球" <c:if  test="${fileDetails.FILESHOBBY=='乒乓球'}">selected='selected'</c:if>>乒乓球</option>
							<option value="舞蹈" <c:if  test="${fileDetails.FILESHOBBY=='舞蹈'}">selected='selected'</c:if>>舞蹈</option>
							<option value="羽毛球" <c:if  test="${fileDetails.FILESHOBBY=='羽毛球'}">selected='selected'</c:if>>羽毛球</option>
							<option value="唱歌" <c:if  test="${fileDetails.FILESHOBBY=='唱歌'}">selected='selected'</c:if>>唱歌</option>
							<option value="台球" <c:if  test="${fileDetails.FILESHOBBY=='台球'}">selected='selected'</c:if>>台球</option>
							<option value="图画" <c:if  test="${fileDetails.FILESHOBBY=='图画'}">selected='selected'</c:if>>图画</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						&nbsp;
					</td>
					<td class="TD_STYLE2">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						个人履历
					</td>
					<td colspan="7"  class="TD_STYLE2">
						<textarea name="file.filesResume" rows="4" class="TEXTAREA_STYLE1">${fileDetails.FILESRESUME}</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						家庭关系信息
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="file.filesFamilyTies" rows="4" class="TEXTAREA_STYLE1">${fileDetails.FILESFAMILYTIES}</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="file.remark" rows="4" class="TEXTAREA_STYLE1">${fileDetails.REMARK}</textarea>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
