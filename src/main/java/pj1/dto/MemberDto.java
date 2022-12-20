package pj1.dto;

import lombok.Data;

@Data
public class MemberDto {
	
	private int memIdx;
	private String role;
	private String memEmail;
	private String memPw;
	private String memName;
	private String memBirth;
	private String memGender;
	private String memPhone;
	private String memPostNum;
	private String memAddr1;
	private String memAddr2;
	private String memRegDate;
	private String memUpdateDate;
	private String memDeletedYn;
	
}
