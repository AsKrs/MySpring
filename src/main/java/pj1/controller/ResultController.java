package pj1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import pj1.dto.ResultDto;
import pj1.service.ResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Slf4j
@Controller
public class ResultController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ResultService resultService;

	@RequestMapping("/result/openResultList.do")
	public ModelAndView openResultList() throws Exception {
		
		log.trace("TRACE openResultList() is called");
		log.debug("DEBUG openResultList() is called");
		log.info("INFO openResultList() is called");
		log.warn("WARN openResultList() is called");
		log.error("ERROR openResultList() is called");

		ModelAndView mv = new ModelAndView("/result/resultList");

		List<ResultDto> list = resultService.selectResultList();
		mv.addObject("list", list);

		return mv;
	}

	@RequestMapping("/result/openResultWrite.do")
	public String openResultWrite() throws Exception {
		return "/result/resultWrite";
	}

	@RequestMapping("/result/insertResult.do")
	public String insertResult(ResultDto result) throws Exception {
		resultService.insertResult(result);
		return "redirect:/result/openResultList.do";
	}

	@RequestMapping("/result/openResultDetail.do")
	public ModelAndView openResultDetail(@RequestParam int resultIdx) throws Exception {
		ModelAndView mv = new ModelAndView("/result/resultDetail");

		ResultDto resultDto = resultService.selectResultDetail(resultIdx);
		mv.addObject("result", resultDto);

		return mv;
	}
	@RequestMapping("/result/deleteResult.do")
	public String deleteResult(@RequestParam int resultIdx) throws Exception {
		resultService.deleteResult(resultIdx);
		return "redirect:/result/openResultList.do";
	}

}
