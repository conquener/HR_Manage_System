package com.zking.hr.view.contorl.action.renli;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.json.JSONUtil;
import org.apache.struts2.json.annotations.JSON;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.zking.hr.biz.interfaces.renli.IRenliBiz;
import com.zking.hr.pojo.TFiles;
import com.zking.hr.pojo.TOrganization;
import com.zking.hr.pojo.TPosition;
import com.zking.hr.pojo.TPositiontype;
import com.zking.hr.pojo.TProfessional;
import com.zking.hr.pojo.TSalarystanderd;
import com.zking.hr.utils.upload.BitImage;
import com.zking.hr.view.pojo.file.QueryFiles;

public class RenliMangeAction  extends ActionSupport implements RequestAware{
	private static final long serialVersionUID = 1L;
	private Map<String, Object> request;
	private IRenliBiz renliBiz;
	private int parentOrginzation;
	private List<TOrganization> lst;
	private TFiles file;
	private List<TPositiontype> postType;
	private List<TPosition> post;
	private int positionTypeId;
	private List<TProfessional> prof;
	private List<TSalarystanderd> ts;
	private File prcture;
	private Integer fileId;
	private QueryFiles queryFiles;
	private List<Map<String,Object>> tfiles;
	private Map<String,Object> fileDetails;
	private Integer index;
	
	/**
	 * 获取机构
	 * @return
	 */
	public String getOrainzation(){
		setLst(renliBiz.getOrainzation(parentOrginzation));
		return "success1";
	}
	/**
	 * 获取职位类型	
	 * @return
	 */
	public String getPositionType(){
		setPostType(renliBiz.getPositionType());
		return "success2";
	}
	/**
	 * 获取职位信息
	 * @return
	 */
	public String getPosition(){
		setPost(renliBiz.getPosition(positionTypeId));
		return "success3";
	}
	/**
	 * 获取职称信息
	 * @return
	 */
	public String getProfessional(){
		setProf(renliBiz.getProfessional());
		return "success4";
	}
	/**
	 * 获取薪酬标准
	 * @return
	 */
	public String getSalarystander(){
		List<TSalarystanderd> lst =renliBiz.getSalarystander();
		setTs(lst);
		return "success5";
	}
	/**
	 * 登记档案
	 * @return
	 */
	public String humanfile(){
		fileId= renliBiz.registerFiles(file,request);
		
		return "success6";
	}
	/**
	 * 上传照片
	 * @return
	 * @throws FileNotFoundException 
	 */
	public String humanPicture() throws FileNotFoundException{
		String BOUNDARY = UUID.randomUUID().toString();
		String outImgPath = ServletActionContext.getServletContext().getRealPath("/");
		outImgPath+="upload//"+BOUNDARY+".jpg";
		if(prcture!=null){
			InputStream in =new FileInputStream(prcture);
			BitImage.compressImageByStream(in, outImgPath, 100, 100);
		}
		renliBiz.humanPicture(fileId,outImgPath);
		
		return "success7";
	}
	/**
	 * 人力资源档案查询  
	 * @return
	 */
	public String queryFileList(){
		setTfiles(renliBiz.queryFileList(queryFiles,request));
		if(index==1){
			return "success8";
		}else if(index==2){
			return "success9";
		}else{
			return "success13";
		}
	}
	
	public String queryFilesDetails(){
		setFileDetails(renliBiz.queryFilesDetails(fileId));
		if(index==1){
			return "success10";
		}else{
			return "success11";
		}
	}
	
	
	public String renliFileUpdate(){
		renliBiz.renliFileUpdate(file);
		return "success12";
	};
	/**
	 * 初步删除
	 * @return
	 */
	public String deleteRenliFile1(){
		renliBiz.deleteRenliFile1(fileId);
		return "success14";
	}
	/**
	 * 查询已删除的
	 * @return
	 */
	public String queryFileListDeleted(){
		setTfiles(renliBiz.queryFileListDeleted(queryFiles,request));
		if(index==1){
			return "success15";
		}else{
			return "success17";
		}
		
	}
	
	
	/**
	 * 人力资源档案恢复
	 */
	public String recoveryRenliFile(){
		renliBiz.recoveryRenliFile(fileId);
		return "success16";
	}
	/**
	 * 人力资源永久删除
	 * @return
	 */
	public String deleteForeverRenliFile(){
		renliBiz.deleteForeverRenliFile(fileId);
		return "success18";
	}
	
	/**----------------*/
	
	public void setRequest(Map<String, Object> request) {
		this.request = request;	
	}
	public int getParentOrginzation() {
		return parentOrginzation;
	}

	public void setParentOrginzation(int parentOrginzation) {
		this.parentOrginzation = parentOrginzation;
	}

	public IRenliBiz getRenliBiz() {
		return renliBiz;
	}

	public void setRenliBiz(IRenliBiz renliBiz) {
		this.renliBiz = renliBiz;
	}

	public List<TOrganization> getLst() {
		return lst;
	}

	public void setLst(List<TOrganization> lst) {
		this.lst = lst;
	}

	public TFiles getFile() {
		return file;
	}

	public void setFile(TFiles file) {
		this.file = file;
	}

	public List<TPositiontype> getPostType() {
		return postType;
	}

	public void setPostType(List<TPositiontype> postType) {
		this.postType = postType;
	}

	public List<TPosition> getPost() {
		return post;
	}

	public void setPost(List<TPosition> post) {
		this.post = post;
	}

	public int getPositionTypeId() {
		return positionTypeId;
	}

	public void setPositionTypeId(int positionTypeId) {
		this.positionTypeId = positionTypeId;
	}

	public List<TProfessional> getProf() {
		return prof;
	}

	public void setProf(List<TProfessional> prof) {
		this.prof = prof;
	}

	public List<TSalarystanderd> getTs() {
		return ts;
	}

	public void setTs(List<TSalarystanderd> ts) {
		this.ts = ts;
	}
	public File getPrcture() {
		return prcture;
	}
	public void setPrcture(File prcture) {
		this.prcture = prcture;
	}
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public QueryFiles getQueryFiles() {
		return queryFiles;
	}
	public void setQueryFiles(QueryFiles queryFiles) {
		this.queryFiles = queryFiles;
	}
	public List<Map<String,Object>> getTfiles() {
		return tfiles;
	}
	public void setTfiles(List<Map<String,Object>> tfiles) {
		this.tfiles = tfiles;
	}
	public Map<String,Object> getFileDetails() {
		return fileDetails;
	}
	public void setFileDetails(Map<String,Object> fileDetails) {
		this.fileDetails = fileDetails;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	
}
