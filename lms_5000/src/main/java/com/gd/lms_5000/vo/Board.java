package com.gd.lms_5000.vo;

import lombok.Data;

@Data
public class Board {
	private int boardNo;
	private String boardName;
	private String boardType;
	private String createDate;
	private int lectureNo;
}
