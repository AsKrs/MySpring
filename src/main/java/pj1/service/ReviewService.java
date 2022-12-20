package pj1.service;

import java.util.List;

import pj1.dto.ReviewDto;

public interface ReviewService {
	
	public List<ReviewDto> selectReviewList(int itemNum) throws Exception;
	
	public ReviewDto selectReviewDetail(int reviewIdx) throws Exception;

}
