package pj1.dto;

import lombok.Data;

@Data
public class ReviewDto {
	private int reviewIdx;
	private String memId;
	private String itemName;
	private String reviewTitle;
	private String reviewContents;
	private String reviewWriteDate;
	private String reviewUpdateDate;
	private int itemRate;
	private String reviewImg;
	private String reviewLike;
}
