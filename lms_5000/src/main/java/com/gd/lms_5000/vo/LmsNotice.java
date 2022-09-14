package com.gd.lms_5000.vo;

import lombok.Data;

@Data
public class LmsNotice {
	private int lmsNoticeNo;
	private String lmsNoticeTitle;
	private String lmsNoticContent;
	private String lmsNoticeCreatetime;
	private String lmsNoticeUpdatetime;
	private int count;
	
}
