package pj1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pj1.dto.FaqDto;

@Mapper
public interface FaqMapper {
	
	List<FaqDto> selectFaqList() throws Exception;
	void insertFaq(FaqDto faq) throws Exception;
	void deleteFaq(int faqIdx) throws Exception;
	void updateFaq(FaqDto faqDto) throws Exception;
	

}
