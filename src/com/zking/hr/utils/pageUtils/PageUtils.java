package com.zking.hr.utils.pageUtils;
/**
 * ��ҳ����
 * @author huangpeng
 *@date 2015-6-15
 *@version v1.0
 */
public class PageUtils {
	/**
	 * ��ǰҳ��
	 */
	private int indexPage;
	/**
	 * �ܼ�¼��
	 */
	private int countRows;
	/**
	 * ��ҳ��
	 */
	private int countPage;
	
	/**
	 * ÿҳ��С
	 */
	
	private int pageSize=5;
	
	/**
	 * ��ʼ��¼��
	 */
	private int beginRow;
	
	/**
	 * ������¼��
	 */
	private int endRow;
	
	/**
	 * ���죬�����Ǳ�����Ҫһ���ܼ�¼��
	 * @param countrows �ܼ�¼��
	 */
	public PageUtils(int countrows) {
		this.countRows = countrows;
	}

	public int getIndexPage() {
		return indexPage;
	}

	public void setIndexPage(int indexPage) {
		this.indexPage = indexPage;
	}

	public int getCountRows() {
		return countRows;
	}

	/**
	 * ��ҳ����ã����������
	 * 1.�պ�����
	 * 2.�������� ��1
 	 * @return int �ܵ�ҳ��
	 */
	public int getCountPage() {
		if(countRows % pageSize == 0){
			countPage  = countRows / getPageSize();
		}else{
			countPage  = (countRows / getPageSize()) + 1;
		}
		return countPage;
	}


	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getBeginRow() {
		beginRow = (getIndexPage() - 1) * pageSize + 1;
		return beginRow;
	}


	public int getEndRow() {
		if(getIndexPage() == getCountPage()){
			endRow = countRows;
		}else{
			endRow  = getIndexPage() * getPageSize();
		}
		return endRow;
	}

}
