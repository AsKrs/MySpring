package pj1.dto;

import lombok.Data;

@Data
public class FaqDto {

	private int faqIdx;
	private String memEmail;
	private String faqClass;
	private String faqTitle;
	private String faqContents;
	private String faqCreatedAt;
	private String faqUpdatedAt;
	private String faqDeletedYn;
	
}



