package pj1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pj1.dto.NoticeDto;
import pj1.service.NoticeService;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value= "/notice", method= RequestMethod.GET)
	public List<NoticeDto> selectNoticeList() throws Exception {
		return noticeService.selectNoticeList();
	}
	
	@RequestMapping(value="/notice/{noticeIdx}", method= RequestMethod.GET)
	public NoticeDto selectNoticeDetail(@PathVariable int noticeIdx) throws Exception {
		return noticeService.selectNoticeDetail(noticeIdx);
	}

}
