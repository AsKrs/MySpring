package pj1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import pj1.dto.ResultDto;
import pj1.service.ResultService;



@Controller
public class RestResultController {

	@Autowired
	private ResultService resultService;

	// @GetMapping("/result")
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public ModelAndView openResultList() throws Exception {
		ModelAndView mv = new ModelAndView("/result/restResultList");

		List<ResultDto> list = resultService.selectResultList();
		mv.addObject("list", list);

		return mv;
	}

	@RequestMapping(value = "/result/write", method = RequestMethod.GET)
	public String openResultWrite() throws Exception {
		return "/result/restResultWrite";
	}

	@RequestMapping(value = "/result/write", method = RequestMethod.POST)
	public String insertResult(ResultDto result) throws Exception {
		resultService.insertResult(result);
		return "redirect:/result";
	}

	@RequestMapping(value = "/result/{resultIdx}", method = RequestMethod.GET)
	public ModelAndView openResultDetail(@PathVariable("resultIdx") int resultIdx) throws Exception {
		ModelAndView mv = new ModelAndView("/result/restResultDetail");
		ResultDto resultDto = resultService.selectResultDetail(resultIdx);
		mv.addObject("result", resultDto);

		return mv;
	}

	@RequestMapping(value = "/result/{resultIdx}", method = RequestMethod.DELETE)
	public String deleteResult(@PathVariable("resultIdx") int resultIdx) throws Exception {
		resultService.deleteResult(resultIdx);
		return "redirect:/result";
	}
}
