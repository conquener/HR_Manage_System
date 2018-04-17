package com.zking.hr.utils.pageUtils;
/**
 * 分页工具
 * @author huangpeng
 *@date 2015-6-15
 *@version v1.0
 */
public class PageUtils {
	/**
	 * 当前页码
	 */
	private int indexPage;
	/**
	 * 总纪录数
	 */
	private int countRows;
	/**
	 * 总页数
	 */
	private int countPage;
	
	/**
	 * 每页大小
	 */
	
	private int pageSize=5;
	
	/**
	 * 开始纪录行
	 */
	private int beginRow;
	
	/**
	 * 结束纪录行
	 */
	private int endRow;
	
	/**
	 * 构造，创建是必须需要一个总记录数
	 * @param countrows 总纪录数
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
	 * 总页数获得，两种情况，
	 * 1.刚好整除
	 * 2.不能整除 ＋1
 	 * @return int 总的页数
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
