package pj1.dto;


import java.util.List;

import lombok.Data;

@Data
public class OrderItemDto {
	
	private String memEmail;
	private String address1;
	private String address2;
	private String address3;
	private String memIdx;
	private String memPhone;
	private int itemPrice;
	private String orderNum;
	private String itemNum;
	private String itemName;
	private int itemAmount;
	private String orderStatus;
	private int cartIdx;
	private String itemThumb;
	private String recipient;
	private String recipientPhone;
	
}
