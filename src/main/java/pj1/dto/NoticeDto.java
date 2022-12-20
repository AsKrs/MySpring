package pj1.dto;

import lombok.Data;

@Data
public class NoticeDto {
	private int noticeIdx;
	private String noticeTitle;
	private String noticeContents;
	private String noticeWriteDate;
}
