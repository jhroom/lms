package com.gd.lms.vo;

import lombok.Data;

@Data
public class Paging {
	
	private String userId;
	
	private int nowPage = 1;
	
	private int rowPerPage = 5;
	
	private int beginRow;
	
	private int total;
	
	private int lastPage;
	
	private int startPage;
	
	private int endPage;
	
	private int cntPage;

}
