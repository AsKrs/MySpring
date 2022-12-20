package pj1.dto;

import lombok.Data;

@Data
public class CartDto {
	
	private String memEmail;
	private String itemNum;
	private int itemAmount;
	private int itemPrice;
}
