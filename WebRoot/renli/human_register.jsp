<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<style type="text/css">
			.selectcss{
				border: solid 2px #gray;
				border-radius:2px 2px 2px 2px;
				height:25px;
				width: 100%;
			}			
		</style>
		<link rel="stylesheet" href="<%=basePath %>table.css" type="text/css">
		<link rel="stylesheet" type="text/css" media="all"
			href="<%=basePath %>javascript/calendar/calendar-win2k-cold-1.css">
		<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="<%=basePath %>javascript/calendar/cal.js"></script>
		<script type="text/javascript" src="<%=basePath %>javascript/comm/comm.js"></script>
		<script type="text/javascript" src="<%=basePath %>javascript/comm/select.js"></script>
		<script language="javascript" type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
		<script language="javascript" type="text/javascript" src="<%=basePath%>My97DatePicker/calendar.js"></script>
		<link href="<%=basePath%>My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css">
		<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
		<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
		<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
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
						s+="<option value='"+data[i].oraganId+"'>"+data[i].oraganName+"</option>";
					}
						$("#select1").html(s);
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
						s+="<option value='"+data[i].positiontypeId+"'>"+data[i].positiontypeName+"</option>";
					}
						$("#select4").html(s);
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
						s+="<option value='"+data[i].professionalId+"'>"+data[i].professionalName+"</option>";
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
					console.log(data)
					var s = "<option value='-1'>--请选择--</option>";
					for(var i=0,length=data.length;i<length;i++){
						s+="<option value='"+data[i].salarystanderdId+"'>"+data[i].salarystanderdName+"</option>";
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
						s+="<option value='"+data[i].positionId+"'>"+data[i].positionName+"</option>";
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
						s+="<option value='"+data[i].oraganId+"'>"+data[i].oraganName+"</option>";
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
						s+="<option value='"+data[i].oraganId+"'>"+data[i].oraganName+"</option>";
					}
						$("#select3").html(s);
				}
			});
		}
			
			
		
		$().ready(function() {
			$("#humanfileForm").validate({
				rules:{
					fileEmail:{
						required: true,
				        email: true
					}
				},
				messages:{
					fileEmail:"请输入一个正确的邮箱"
				}
			});
		})
		</script>
	</head>

	<body onload="getFristOrginzation()">
		<form name="humanfileForm" id="humanfileForm" method="post" action="<%=basePath%>renli/renlimange!humanfile">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案登记 </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="submit" value="提交" class="BUTTON_STYLE1"/>
						<input type="reset" value="清除" class="BUTTON_STYLE1">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight='#848284' bordercolordark='#eeeeee'
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1" width="11%">
						I级机构
					</td>
					<td width="14%" class="TD_STYLE2">
						<select id="select1" required  name="file.filesFirstOrganization"  onchange="getSecondOrginzation()" class="SELECT_STYLEFILE">
							<option value='-1'>&nbsp;</option>
						</select>
						<font color="red">*</font>
					</td>
					<td width="11%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="14%" class="TD_STYLE2">
						<select id="select2" required  name="file.filesSecondOrganization" onchange="getThirdOrginzation()" class="SELECT_STYLEFILE">
						<option value='-1'>--请先选择一级机构--</option>
						</select>
						<font color="red">*</font>				
					</td>
					<td width="11%" class="TD_STYLE1">
						III级机构
					</td>
					<td class="TD_STYLE2" colspan="2">
						<select id="select3" required  name="file.filesThirdOrganization" class="SELECT_STYLEFILE">	
							<option value='-1'>--请先选择二级机构--</option>
						</select>
						<font color="red">*</font>
					</td>
					<td rowspan="5">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						职位分类
					</td>
					<td class="TD_STYLE2">
						<select name="file.filesPositionClassify" required id="select4" onchange="getPosition()" class="SELECT_STYLEFILE">
						</select>
						<font color="red">*</font>
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td class="TD_STYLE2">
						<select id="select5" required name="file.filesPositionName" class="SELECT_STYLEFILE">
							<option value='-1'>--请先选择职位类型--</option>
						</select>
						<font color="red">*</font>
					</td>
					<td class="TD_STYLE1">
						职称
					</td>
					<td colspan="2" class="TD_STYLE2">
						<select name="file.filesProfessionalTitle" required id="select6" class="SELECT_STYLEFILE">
						</select>
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						姓名
					</td>
					<td class="TD_STYLE2">
						<input type="text" required name="file.filesUserName" value="" class="INPUT_STYLEFILE">
						<font color="red">*</font>
					</td>
					<td class="TD_STYLE1">
						性别
					</td>
					<td class="TD_STYLE2">
						<select name="file.filesSex" required class="SELECT_STYLEFILE">
							<option value="男">男</option>
							<option value="女">女</option>
						</select>
						<font color="red">*</font>
					</td>
					<td class="TD_STYLE1">
						EMAIL
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="file.filesEmail" id="fileEmail" value="" class="INPUT_STYLEFILE">
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						电话
					</td>
					<td class="TD_STYLE2">
						<input type="text" required name="file.filesPhone" value="" class="INPUT_STYLEFILE">
					</td>
					<td class="TD_STYLE1">
						QQ
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="file.filesQq" value="" class="INPUT_STYLEFILE">
					</td>
					<td class="TD_STYLE1">
						手机
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" required name="file.filesTelphone" value="" class="INPUT_STYLEFILE">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						住址
					</td>
					<td colspan="3" class="TD_STYLE2">
						<input type="text" required name="file.filesAddress" value="" class="INPUT_STYLEFILE">
					</td>
					<td class="TD_STYLE1">
						邮编
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" required name="file.filesPostcode" value="" class="INPUT_STYLEFILE">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						国籍
					</td>
					<td class="TD_STYLE2">
						<select required name="file.filesNationality" class="SELECT_STYLEFILE">
							<option value="中国">中国</option>
							<option value="美国">美国</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						出生地
					</td>
					<td class="TD_STYLE2">
						<input type="text" required name="file.filesBirthplace" value="" class="INPUT_STYLEFILE">
					</td>
					<td class="TD_STYLE1">
						生日
					</td>
					<td width="13%" class="TD_STYLE2">
						<input class="INPUT_STYLEFILE" type="text" readonly name="file.filesBirthday"  onclick="WdatePicker();" />
					</td>
					<td width="11%" class="TD_STYLE1">
						民族
					</td>
					<td class="TD_STYLE2" width="14%">
						<select name="file.filesNation" required class="SELECT_STYLEFILE">
								<option value="汉族">汉族</option>
								<option value="满族">满族</option>
								<option value="蒙古族">蒙古族</option>
								<option value="回族">回族</option>
								<option value="藏族">藏族</option>
								<option value="其他">其他</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						宗教信仰
					</td>
					<td class="TD_STYLE2">
						<select name="file.filesFaith" class="SELECT_STYLEFILE">
								<option value="无">无</option>
								<option value="佛教">佛教</option>
								<option value="道教">道教</option>
								<option value="基督教">基督教</option>
								<option value="伊斯兰教">伊斯兰教</option>
								<option value="神龙教">神龙教</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						政治面貌
					</td>
					<td class="TD_STYLE2">
						<select required name="file.filesPoliticsStatus" class="SELECT_STYLEFILE">
								<option value="党员">党员</option>
								<option value="群众">群众</option>
								<option value="群众">共青团员</option>
								<option value="少先队员">少先队员</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						身份证号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" required name="file.filesIdcard" value="" class="INPUT_STYLEFILE">
					</td>
					<td class="TD_STYLE1">
						社会保障号码
					</td>
					<td class="TD_STYLE2">
						<input type="text"  name="file.filesSocialInsurancePhone" value="" class="INPUT_STYLEFILE">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td class="TD_STYLE2">
						<input type="text" required name="file.filesAge" value="" class="INPUT_STYLEFILE">
					</td>
					<td class="TD_STYLE1">
						学历
					</td>
					<td class="TD_STYLE2">
						<select required name="file.filesEducation" class="SELECT_STYLEFILE">
								<option value="博士">博士</option>
								<option value="硕士">硕士</option>
								<option value="本科">本科</option>
								<option value="大专">大专</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						教育年限
					</td>
					<td class="TD_STYLE2">
						<select name="file.filesEducationAge" class="selectcss">
								<option value="15">15</option>
								<option value="16">16</option>
								<option value="18">16年以上</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td class="TD_STYLE2">
						<input type="text" required name="file.filesEducationMajor" class="INPUT_STYLEFILE"  />
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						薪酬标准
					</td>
					<td class="TD_STYLE2">
						<select id="select7" required name="file.salarystanderdId" class="SELECT_STYLEFILE">
							
						</select><font color="red">*</font>
					</td>
					<td class="TD_STYLE1">
						开户行
					</td>
					<td class="TD_STYLE2">
						<input type="text" required name="file.filesOpeningBank" value="" class="INPUT_STYLEFILE">
						<font color="red">*</font>
					</td>
					<td class="TD_STYLE1">
						帐号
					</td>
					<td class="TD_STYLE2">
						<input type="text" required name="file.filesAccountNumber" value="" class="INPUT_STYLEFILE">
						<font color="red">*</font>
					</td>
					<td class="TD_STYLE1">
						登记人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="file.filesRegisterPeople" value="${user.userName}" readonly="readonly" class="INPUT_STYLEFILE">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						建档时间
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="file.filesFilingTime" value="<fmt:formatDate value='<%=new java.util.Date() %>' pattern='YYYY-MM-dd'/>" readonly="readonly" class="INPUT_STYLEFILE">
					</td>
					<td class="TD_STYLE1">
						特长
					</td>
					<td class="TD_STYLE2">
						<select name="file.filesAptitude" required class="SELECT_STYLEFILE">
								<option value="数据库">数据库</option>
								<option value="java">java</option>
								<option value="c++">c++</option>
								<option value="c语言">c语言</option>
								<option value=".net">.net</option>
								<option value="php">php</option>
								<option value="javascript">javascript</option>
						</select>
						<font color="red">*</font>
					</td>
					<td class="TD_STYLE1">
						爱好
					</td>
					<td class="TD_STYLE2">
						<select name="file.filesHobby" class="SELECT_STYLEFILE">
								<option value="篮球">篮球</option>
								<option value="书法">书法</option>
								<option value="足球">足球</option>
								<option value="摄影">摄影</option>
								<option value="网球">网球</option>
								<option value="乒乓球">乒乓球</option>
								<option value="舞蹈">舞蹈</option>
								<option value="羽毛球">羽毛球</option>
								<option value="唱歌">唱歌</option>
								<option value="台球">台球</option>
								<option value="图画">图画</option>
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
					<td colspan="7" class="TD_STYLE2">
						<textarea name="file.filesResume" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						家庭关系信息
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="file.filesFamilyTies" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="file.remark" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

