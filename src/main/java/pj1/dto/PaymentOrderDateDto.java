package pj1.dto;

import lombok.Data;

@Data
public class PaymentOrderDateDto {
	private int buyIdx;
	private int orderNum;
	private String paymentType;
	private String paymentDate;
	private int paymentPrice;
	private int depositPrice;
	private String depositName;
	private String depositBank;
	
}
