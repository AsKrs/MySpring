package pj1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pj1.dto.NoticeDto;

@Mapper
public interface NoticeMapper {
	
	
	List<NoticeDto> selectNoticeList() throws Exception;
	NoticeDto selectNoticeDetail(int noticeIdx) throws Exception;
	
}
