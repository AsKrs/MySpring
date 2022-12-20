package pj1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import pj1.dto.ItemDto;
import pj1.dto.ReviewDto;
import pj1.service.ReviewService;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@ApiOperation(value = "목록 조회", notes = "등록된 아이템 목록을 조회")
	@RequestMapping(value = "/review/list/{itemNum}", method = RequestMethod.GET)
	public List<ReviewDto> openReviewList(
			@Parameter(description = "상품 번호", required = true, example = "1") @PathVariable("itemNum") int itemNum) throws Exception {
		return reviewService.selectReviewList(itemNum);
	}
	
	@ApiOperation(value = "리뷰 상세 조회", notes = "리뷰 상세 조회")
	@RequestMapping(value = "/review/{reviewIdx}", method = RequestMethod.GET)
	public ResponseEntity<ReviewDto> openItemDetail(
			@Parameter(description = "리뷰 번호", required = true, example = "1") @PathVariable("reviewIdx") int reviewIdx) throws Exception {
		ReviewDto reviewDto = reviewService.selectReviewDetail(reviewIdx);
		if (reviewDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.ok(reviewDto);
		}
	}
}
