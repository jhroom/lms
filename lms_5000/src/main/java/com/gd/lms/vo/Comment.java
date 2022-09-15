package com.gd.lms.vo;

import lombok.Data;

@Data
public class Comment {
	private int commentNo;
	private String commentContent;
	private String commentCreatedate;
	private String commentUpdatedate;
	private int boardPostNo;
}
