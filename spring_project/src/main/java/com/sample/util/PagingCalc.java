package com.sample.util;

public class PagingCalc {
	
	int totalCount;  // 총 게시글 수 
	
	int countList; // 한 페이지당 보여질 , 게시글 수 
	
	int totalpage; // 총 페이지 수 
	
	int countPage; // 보여질 페이지 번호수(5개 또는 10개)
	
	int curPage; // 현재페이지
	
	int startPage; // 페이지 시작 인덱스
	
	int endPage; // 페이지 끝 인덱스
	
	
	public PagingCalc(int totalCount, int countList, int countPage) {
		this.totalCount = totalCount;
		this.countList = countList;
		this.countPage = countPage;
		
		this.totalpage = totalCount / countList;
		if(totalCount % countList > 0 ) {
			totalpage++;
		}
	}
	
	public void calcPageIndex(int curPage) {
		this.curPage = curPage;
		
		this.startPage = ((this.curPage - 1)/10) * 10 + 1;
		this.endPage = this.startPage + this.countPage - 1;
		
		if(endPage > totalpage) {
			endPage = totalpage;
		}
	}

	
	
	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCountList() {
		return countList;
	}

	public void setCountList(int countList) {
		this.countList = countList;
	}

	public int getTotalpage() {
		return totalpage;
	}
	
	
	
}
