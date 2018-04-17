package com.zking.hr.pojo;

import java.sql.Date;

/**
 * TFiles entity. @author MyEclipse Persistence Tools
 */

public class TFiles implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = -6304168667396868627L;
	private Integer filesFilesid;
	private Integer filesUserid;
	private String filesUserName;
	public String getFilesUserName() {
		return filesUserName;
	}

	public void setFilesUserName(String filesUserName) {
		this.filesUserName = filesUserName;
	}
	/**一级机构*/
	private Integer filesFirstOrganization;
	/**二级机构*/
	private Integer filesSecondOrganization;
	/**三级机构*/
	private Integer filesThirdOrganization;
	/**职位分类*/
	private Integer filesPositionClassify;
	/**职位名称*/
	private Integer filesPositionName;
	/**职称名*/
	private Integer filesProfessionalTitle;
	/**性别*/
	private String filesSex;
	/**邮箱*/
	private String filesEmail;
	/**电话号码*/
	private String filesPhone;
	/**QQ*/
	private String filesQq;
	/**座机号码*/
	private String filesTelphone;
	/**居住地址*/
	private String filesAddress;
	/**邮编*/
	private String filesPostcode;
	/**国籍*/
	private String filesNationality;
	/**出生地址*/
	private String filesBirthplace;
	/**出生年月日*/
	private String filesBirthday;
	/**民族*/
	private String filesNation;
	/**信仰宗教*/
	private String filesFaith;
	/**政治面貌*/
	private String filesPoliticsStatus;
	/**身份证*/
	private String filesIdcard;
	/**社会保障号码*/
	private String filesSocialInsurancePhone;
	/**年龄*/
	private String filesAge;
	/**学历*/
	private String filesEducation;
	/**教育年限*/
	private String filesEducationAge;
	/**学位*/
	private String filesEducationMajor;
	/**薪酬标准*/
	private Integer salarystanderdId;
	private String filesRemunerationStandard;
	/**薪酬发放状态*/
	private Integer filesSalaryStatus;
	/**薪酬发放时间*/
	private Date filesSalaryTime;
	/**开户银行*/
	private String filesOpeningBank;
	/**银行帐号*/
	private String filesAccountNumber;
	/**登记人*/
	private String filesRegisterPeople;
	/**建档时间*/
	private String filesFilingTime;
	private String filesAptitude;
	private String filesHobby;
	private String filesResume;
	private String filesFamilyTies;
	/**核对状态*/
	private Integer filesCheckStatu;
	/**删除状态*/
	private Integer filesDeleteStatu;
	private String imagename;
	private String imageurl;
	private String remark;
	// Constructors
	/** default constructor */
	public TFiles() {
	}
	/** minimal constructor */
	public TFiles(Integer filesFilesid) {
		this.filesFilesid = filesFilesid;
	}

	/** full constructor */
	
	// Property accessors

	public Integer getFilesFilesid() {
		return this.filesFilesid;
	}

	public TFiles(Integer filesFilesid, Integer filesUserid,
			String filesUserName, Integer filesFirstOrganization,
			Integer filesSecondOrganization, Integer filesThirdOrganization,
			Integer filesPositionClassify, Integer filesPositionName,
			Integer filesProfessionalTitle, String filesSex, String filesEmail,
			String filesPhone, String filesQq, String filesTelphone,
			String filesAddress, String filesPostcode, String filesNationality,
			String filesBirthplace, String filesBirthday, String filesNation,
			String filesFaith, String filesPoliticsStatus, String filesIdcard,
			String filesSocialInsurancePhone, String filesAge,
			String filesEducation, String filesEducationAge,
			String filesEducationMajor, Integer salarystanderdId,
			String filesRemunerationStandard, Integer filesSalaryStatus,
			Date filesSalaryTime, String filesOpeningBank,
			String filesAccountNumber, String filesRegisterPeople,
			String filesFilingTime, String filesAptitude, String filesHobby,
			String filesResume, String filesFamilyTies,
			Integer filesCheckStatu, Integer filesDeleteStatu,
			String imagename, String imageurl, String remark) {
		super();
		this.filesFilesid = filesFilesid;
		this.filesUserid = filesUserid;
		this.filesUserName = filesUserName;
		this.filesFirstOrganization = filesFirstOrganization;
		this.filesSecondOrganization = filesSecondOrganization;
		this.filesThirdOrganization = filesThirdOrganization;
		this.filesPositionClassify = filesPositionClassify;
		this.filesPositionName = filesPositionName;
		this.filesProfessionalTitle = filesProfessionalTitle;
		this.filesSex = filesSex;
		this.filesEmail = filesEmail;
		this.filesPhone = filesPhone;
		this.filesQq = filesQq;
		this.filesTelphone = filesTelphone;
		this.filesAddress = filesAddress;
		this.filesPostcode = filesPostcode;
		this.filesNationality = filesNationality;
		this.filesBirthplace = filesBirthplace;
		this.filesBirthday = filesBirthday;
		this.filesNation = filesNation;
		this.filesFaith = filesFaith;
		this.filesPoliticsStatus = filesPoliticsStatus;
		this.filesIdcard = filesIdcard;
		this.filesSocialInsurancePhone = filesSocialInsurancePhone;
		this.filesAge = filesAge;
		this.filesEducation = filesEducation;
		this.filesEducationAge = filesEducationAge;
		this.filesEducationMajor = filesEducationMajor;
		this.salarystanderdId = salarystanderdId;
		this.filesRemunerationStandard = filesRemunerationStandard;
		this.filesSalaryStatus = filesSalaryStatus;
		this.filesSalaryTime = filesSalaryTime;
		this.filesOpeningBank = filesOpeningBank;
		this.filesAccountNumber = filesAccountNumber;
		this.filesRegisterPeople = filesRegisterPeople;
		this.filesFilingTime = filesFilingTime;
		this.filesAptitude = filesAptitude;
		this.filesHobby = filesHobby;
		this.filesResume = filesResume;
		this.filesFamilyTies = filesFamilyTies;
		this.filesCheckStatu = filesCheckStatu;
		this.filesDeleteStatu = filesDeleteStatu;
		this.imagename = imagename;
		this.imageurl = imageurl;
		this.remark = remark;
	}

	public void setFilesFilesid(Integer filesFilesid) {
		this.filesFilesid = filesFilesid;
	}

	public Integer getFilesUserid() {
		return this.filesUserid;
	}

	public void setFilesUserid(Integer filesUserid) {
		this.filesUserid = filesUserid;
	}

	public Integer getFilesFirstOrganization() {
		
		return filesFirstOrganization;
	}

	public void setFilesFirstOrganization(Integer filesFirstOrganization) {
		if(filesFirstOrganization!=null&&filesFirstOrganization>-1){
			this.filesFirstOrganization = filesFirstOrganization;
		}
	}

	public Integer getFilesSecondOrganization() {
		return filesSecondOrganization;
	}

	public void setFilesSecondOrganization(Integer filesSecondOrganization) {
		if(filesSecondOrganization!=null&&filesSecondOrganization>-1){
			this.filesSecondOrganization = filesSecondOrganization;
		}
	}

	public Integer getFilesThirdOrganization() {
		return filesThirdOrganization;
	}

	public void setFilesThirdOrganization(Integer filesThirdOrganization) {
		if(filesThirdOrganization!=null&&filesThirdOrganization>-1){
			this.filesThirdOrganization = filesThirdOrganization;
		}
	}

	public Integer getFilesPositionClassify() {
		return filesPositionClassify;
	}

	public void setFilesPositionClassify(Integer filesPositionClassify) {
		if(filesPositionClassify!=null&&filesPositionClassify>-1){
			this.filesPositionClassify = filesPositionClassify;
		}
	}

	public Integer getFilesPositionName() {
		return filesPositionName;
	}

	public void setFilesPositionName(Integer filesPositionName) {
		if(filesPositionName!=null&&filesPositionName>-1){
			this.filesPositionName = filesPositionName;
		}
	}

	public Integer getFilesProfessionalTitle() {
		return filesProfessionalTitle;
	}

	public void setFilesProfessionalTitle(Integer filesProfessionalTitle) {
		if(filesProfessionalTitle!=null&&filesProfessionalTitle>-1){
			this.filesProfessionalTitle = filesProfessionalTitle;
		}
	}

	public String getFilesSex() {
		return this.filesSex;
	}

	public void setFilesSex(String filesSex) {
		this.filesSex = filesSex;
	}

	public String getFilesEmail() {
		return this.filesEmail;
	}

	public void setFilesEmail(String filesEmail) {
		this.filesEmail = filesEmail;
	}

	public String getFilesPhone() {
		return this.filesPhone;
	}

	public void setFilesPhone(String filesPhone) {
		this.filesPhone = filesPhone;
	}

	public String getFilesQq() {
		return this.filesQq;
	}

	public void setFilesQq(String filesQq) {
		this.filesQq = filesQq;
	}

	public String getFilesTelphone() {
		return this.filesTelphone;
	}

	public void setFilesTelphone(String filesTelphone) {
		this.filesTelphone = filesTelphone;
	}

	public String getFilesAddress() {
		return this.filesAddress;
	}

	public void setFilesAddress(String filesAddress) {
		this.filesAddress = filesAddress;
	}

	public String getFilesPostcode() {
		return this.filesPostcode;
	}

	public void setFilesPostcode(String filesPostcode) {
		this.filesPostcode = filesPostcode;
	}

	public String getFilesNationality() {
		return this.filesNationality;
	}

	public void setFilesNationality(String filesNationality) {
		this.filesNationality = filesNationality;
	}

	public String getFilesBirthplace() {
		return this.filesBirthplace;
	}

	public void setFilesBirthplace(String filesBirthplace) {
		this.filesBirthplace = filesBirthplace;
	}

	public String getFilesBirthday() {
		return this.filesBirthday;
	}

	public void setFilesBirthday(String filesBirthday) {
		this.filesBirthday = filesBirthday;
	}

	public String getFilesNation() {
		return this.filesNation;
	}

	public void setFilesNation(String filesNation) {
		this.filesNation = filesNation;
	}

	public String getFilesFaith() {
		return this.filesFaith;
	}

	public void setFilesFaith(String filesFaith) {
		this.filesFaith = filesFaith;
	}

	public String getFilesPoliticsStatus() {
		return this.filesPoliticsStatus;
	}

	public void setFilesPoliticsStatus(String filesPoliticsStatus) {
		this.filesPoliticsStatus = filesPoliticsStatus;
	}

	public String getFilesIdcard() {
		return this.filesIdcard;
	}

	public void setFilesIdcard(String filesIdcard) {
		this.filesIdcard = filesIdcard;
	}

	public String getFilesSocialInsurancePhone() {
		return this.filesSocialInsurancePhone;
	}

	public void setFilesSocialInsurancePhone(String filesSocialInsurancePhone) {
		this.filesSocialInsurancePhone = filesSocialInsurancePhone;
	}

	public String getFilesAge() {
		return this.filesAge;
	}

	public void setFilesAge(String filesAge) {
		this.filesAge = filesAge;
	}

	public String getFilesEducation() {
		return this.filesEducation;
	}

	public void setFilesEducation(String filesEducation) {
		this.filesEducation = filesEducation;
	}

	public String getFilesEducationAge() {
		return this.filesEducationAge;
	}

	public void setFilesEducationAge(String filesEducationAge) {
		this.filesEducationAge = filesEducationAge;
	}

	public String getFilesEducationMajor() {
		return this.filesEducationMajor;
	}

	public void setFilesEducationMajor(String filesEducationMajor) {
		this.filesEducationMajor = filesEducationMajor;
	}

	public Integer getSalarystanderdId() {
		return this.salarystanderdId;
	}

	public void setSalarystanderdId(Integer salarystanderdId) {
		this.salarystanderdId = salarystanderdId;
	}

	public String getFilesRemunerationStandard() {
		return this.filesRemunerationStandard;
	}

	public void setFilesRemunerationStandard(String filesRemunerationStandard) {
		this.filesRemunerationStandard = filesRemunerationStandard;
	}

	public Integer getFilesSalaryStatus() {
		return this.filesSalaryStatus;
	}

	public void setFilesSalaryStatus(Integer filesSalaryStatus) {
		this.filesSalaryStatus = filesSalaryStatus;
	}

	public Date getFilesSalaryTime() {
		return this.filesSalaryTime;
	}

	public void setFilesSalaryTime(Date filesSalaryTime) {
		this.filesSalaryTime = filesSalaryTime;
	}

	public String getFilesOpeningBank() {
		return this.filesOpeningBank;
	}

	public void setFilesOpeningBank(String filesOpeningBank) {
		this.filesOpeningBank = filesOpeningBank;
	}

	public String getFilesAccountNumber() {
		return this.filesAccountNumber;
	}

	public void setFilesAccountNumber(String filesAccountNumber) {
		this.filesAccountNumber = filesAccountNumber;
	}

	public String getFilesRegisterPeople() {
		return this.filesRegisterPeople;
	}

	public void setFilesRegisterPeople(String filesRegisterPeople) {
		this.filesRegisterPeople = filesRegisterPeople;
	}

	public String getFilesFilingTime() {
		return this.filesFilingTime;
	}

	public void setFilesFilingTime(String filesFilingTime) {
		this.filesFilingTime = filesFilingTime;
	}

	public String getFilesAptitude() {
		return this.filesAptitude;
	}

	public void setFilesAptitude(String filesAptitude) {
		this.filesAptitude = filesAptitude;
	}

	public String getFilesHobby() {
		return this.filesHobby;
	}

	public void setFilesHobby(String filesHobby) {
		this.filesHobby = filesHobby;
	}

	public String getFilesResume() {
		return this.filesResume;
	}

	public void setFilesResume(String filesResume) {
		this.filesResume = filesResume;
	}

	public String getFilesFamilyTies() {
		return this.filesFamilyTies;
	}

	public void setFilesFamilyTies(String filesFamilyTies) {
		this.filesFamilyTies = filesFamilyTies;
	}

	public Integer getFilesCheckStatu() {
		return this.filesCheckStatu;
	}

	public void setFilesCheckStatu(Integer filesCheckStatu) {
		this.filesCheckStatu = filesCheckStatu;
	}

	public String getImagename() {
		return this.imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	public String getImageurl() {
		return this.imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getFilesDeleteStatu() {
		return filesDeleteStatu;
	}

	public void setFilesDeleteStatu(Integer filesDeleteStatu) {
		this.filesDeleteStatu = filesDeleteStatu;
	}
}