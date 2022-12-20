package pj1.dto;

import lombok.Data;

@Data
public class AdminDto {
	
	//orderDto
	private String orderNum;
	private String orderStatus;
	private String orderDate;
	private int itemNum;
	private int itemAmount;
	private String itemName;
	private int itemPrice;
	private int memIdx;
	private String memEmail;

	//refundDto
	private int refundIdx;
	private String refundReason;
	private String refundDate;
	private String refundStatus;
	
	//reviewDto
	private int reviewIdx;
	private String reviewWriteYn;
	private String reviewContents;
	private String reviewWriteDate;
	private String reviewUpdateDate;
	private String reviewDeleteYn;
	
	
}
