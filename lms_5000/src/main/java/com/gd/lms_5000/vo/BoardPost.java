package com.gd.lms_5000.vo;

import lombok.Data;

@Data
public class BoardPost {
	private int boardPostNo;
	private int boardNo;
	private String boardPostTitle;
	private String boardPostContent;
	private String boardPostWriter;
	private String boardPostCreatedate;
	private String boardPostUpdatedate;
	private int count;
}
