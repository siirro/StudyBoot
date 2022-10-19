package com.iu.home.util;

import lombok.Data;

@Data
public class Pager {
	
	private Long page;
	private Long startNum;
	private Long lastNum;
	private Long startRow;

	private Long perPage=10L;
	
	private String search;
	private String kind;
	

	
	
	
	
	public Long getPage() {
		if(this.page==null||this.page<1) {
			this.page=1L;
		}
		return page;
	}
	public Long getPerPage() {
		if(this.perPage==null) {
			this.perPage=10L;
		}
		return perPage;
	}
	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return search;
	}
	
	public void makeRow() {
		this.startRow = (this.getPage()-1)*perPage;
	}

}
