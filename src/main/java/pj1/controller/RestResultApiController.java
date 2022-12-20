package pj1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pj1.dto.ResultDto;
import pj1.service.ResultService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class RestResultApiController {

	@Autowired
	private ResultService resultService;
	
	@CrossOrigin(origins="*", allowedHeaders="*")
	@ApiOperation(value = "목록 조회", notes = "등록된 게시물 목록을 조회")
	@RequestMapping(value = "mypage/myresearch", method = RequestMethod.GET)
	public List<ResultDto> openResultList() throws Exception {
		return resultService.selectResultList();
	}

	@ApiOperation(value = "게시물 등록", notes = "게시물 제목과 내용을 저장")
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public void insertResult(
			@Parameter(description = "게시물 정보", required = true, example = "{ title: 제목, contents: 내용 }") @RequestBody ResultDto result)
			throws Exception {
		resultService.insertResult(result);
	}

	@ApiOperation(value = "게시물 상세 조회", notes = "등록된 게시물 상세 정보를 조회")
	@RequestMapping(value = "/mypage/result/{resultIdx}", method = RequestMethod.GET)
	public ResponseEntity<ResultDto> openResultDetail(
			@Parameter(description = "게시물 번호", required = true, example = "1") @PathVariable("resultIdx") int resultIdx)
			throws Exception {
		ResultDto resultDto = resultService.selectResultDetail(resultIdx);
		if (resultDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			// return ResponseEntity.status(HttpStatus.OK).body(resultDto);
			return ResponseEntity.ok(resultDto);
		}
	}

	@RequestMapping(value = "mypage/result/{resultIdx}", method = RequestMethod.DELETE)
	public void deleteResult(@PathVariable("resultIdx") int resultIdx) throws Exception {
		resultService.deleteResult(resultIdx);
	}
}
