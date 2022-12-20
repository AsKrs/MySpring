package pj1.service;

import java.util.List;

import pj1.dto.NoticeDto;

public interface NoticeService {

	public List<NoticeDto> selectNoticeList() throws Exception ;
	public NoticeDto selectNoticeDetail(int noticeIdx) throws Exception;
}
