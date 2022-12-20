package pj1.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown =true) 
public class ItemDto {
	private String itemNum;
	private String itemName;
	private int itemPrice;
	private int itemCount;
	private String itemThumb;
	private String itemDetailImg;
	private String itemMaker;
	private String itemHow;
	private String itemExpDate;
	private String itemMaterials;
	private String itemOrgans;
	private int itemScore;
	private String itemDeletedYn;
	private String itemCreatedAt;
	private String itemUpdatedAt;
	private String itemThumbName;
	private String itemDetailImgName;
	private String itemSubImg;
	private String itemSubImgName;
	private String categoryName;
	
}
