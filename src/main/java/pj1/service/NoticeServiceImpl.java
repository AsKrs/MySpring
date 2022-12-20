package pj1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj1.dto.NoticeDto;
import pj1.mapper.NoticeMapper;


@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Override
	public List<NoticeDto> selectNoticeList() throws Exception {
		
		return noticeMapper.selectNoticeList();

	}

	@Override
	public NoticeDto selectNoticeDetail(int noticeIdx) throws Exception {
		return noticeMapper.selectNoticeDetail(noticeIdx);
	}
	
	
	
	

}
