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

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import pj1.dto.QnaDto;
import pj1.dto.ReviewDto;
import pj1.service.QnaService;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ApiOperation(value = "목록 조회", notes = "등록된 Qna 목록을 조회")
	@RequestMapping(value = "/qna/{itemNum}", method = RequestMethod.GET)
	public List<QnaDto> openQnaList(
			@Parameter(description = "아이템 번호", required = true, example = "1001001") @PathVariable("itemNum") int itemIdx) 
					throws Exception {
		return qnaService.selectQnaList(itemIdx);
	}
	
	@ApiOperation(value = "Qna 상세 조회", notes = "Qna 상세 조회")
	@RequestMapping(value = "/qna/contents/{qnaIdx}", method = RequestMethod.GET)
	public ResponseEntity<QnaDto> openQnaDetail(
			@Parameter(description = "Qna 번호", required = true, example = "1") @PathVariable("qnaIdx") int qnaIdx) throws Exception {
		
		QnaDto qnaDto = qnaService.selectQnaDetail(qnaIdx);
		if (qnaDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.ok(qnaDto);
		}
	}
	
//	@ApiOperation(value = "Qna 답변 조회", notes = "Qna 답변 조회")
//	@RequestMapping(value = "/qnaAnswer/{qnaIdx}", method = RequestMethod.GET)
//	public ResponseEntity<QnaDto> openQnaAnswer(
//			@Parameter(description = "Qna 번호", required = true, example = "1") @PathVariable("qnaIdx") int qnaIdx) throws Exception {
//		QnaDto qnaDto = qnaService.selectQnaAnswer(qnaIdx);
//		if (qnaDto == null) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//		} else {
//			return ResponseEntity.ok(qnaDto);
//		}
//	}
//	
	@ApiOperation(value = "목록 조회", notes = "등록된 게시물 목록을 조회")
	@RequestMapping(value = "admin/qna", method = RequestMethod.GET)
	public List<QnaDto> openQnaAllList() throws Exception {
		return qnaService.selectAllQnaList();
	}
		
	@ApiOperation(value = "Qna 등록", notes = "Qna 제목과 내용을 저장")
	@RequestMapping(value = "/qna/write", method = RequestMethod.POST)
	public ResponseEntity<Object> insertQnaComment(@RequestBody QnaDto qnaDto) throws Exception {
//		System.out.println(qnaDto);
		qnaService.insertQna(qnaDto);
		return null;
	}
	
	@ApiOperation(value = "Qna 답변 등록", notes = "Qna 답변 내용을 저장")
	@RequestMapping(value = "/admin/qnaWrite", method = RequestMethod.POST)
	public void insertQna(
			@Parameter(description = "Qna 답변 등록", required = true, example = "{ contents: 내용 }") @RequestBody QnaDto qna)
			throws Exception {
		qnaService.insertQnaComment(qna);
	}

	@RequestMapping(value = "/admin/qna/{qnaIdx}", method = RequestMethod.POST)
	public void deleteQna(@PathVariable("qnaIdx") int qnaIdx) throws Exception {
		qnaService.deleteQna(qnaIdx);
	}

}
