package com.gd.lms.vo;

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
