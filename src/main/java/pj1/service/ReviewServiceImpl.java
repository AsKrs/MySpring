package pj1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj1.dto.ReviewDto;
import pj1.mapper.ReviewMapper;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewMapper reviewMapper;
	
	
	@Override
	public List<ReviewDto> selectReviewList(int itemNum) throws Exception {
		return reviewMapper.selectReviewList(itemNum);
	}


	@Override
	public ReviewDto selectReviewDetail(int reviewIdx) throws Exception {
		return reviewMapper.selectReviewDetail(reviewIdx);
	}
	

	
}
