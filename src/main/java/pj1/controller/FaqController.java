package pj1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import pj1.dto.FaqDto;
import pj1.service.FaqService;


@Slf4j
@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class FaqController {
	
	@Autowired
	private FaqService faqService;
	
	@ApiOperation(value = "자주묻는 질문 목록", notes = "자주 묻는 질문 조회")
	@RequestMapping(value= "/service", method= RequestMethod.GET)
	public List<FaqDto> selectFaqList() throws Exception{
		return faqService.selectFaqList();
		
	}

}
