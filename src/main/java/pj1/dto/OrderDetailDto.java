package pj1.dto;

import lombok.Data;

@Data
public class OrderDetailDto {
	private int orderDateilNum;
	private int orderNum;
	private String itemNum;
	private int itemAmount;
	private int itemPrice;
	private String orderDetailStatus;
}
