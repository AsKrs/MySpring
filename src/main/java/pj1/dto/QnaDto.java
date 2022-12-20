package pj1.dto;

import lombok.Data;

@Data
public class QnaDto {
	
	
	private int qnaIdx;
	private String itemNum;
	private String memEmail;
	private String qnaTitle;
	private String qnaContents;
	private String qnaWriteDate;
	private String qnaSave;
	private String qnaCommentContent;
	private String qnaCommentWriteDate;
	private String qnaAns;
}
