package com.zking.hr.view.pojo.level;

public class Level implements java.io.Serializable{
	private int level;
	private int endPage;
	private int beginPage;
	
	public Level(int level, int endPage, int beginPage) {
		super();
		this.level = level;
		this.endPage = endPage;
		this.beginPage = beginPage;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public Level() {
		super();
	}
	
	
}
