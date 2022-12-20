package pj1.service;

import java.util.List;

import pj1.dto.FaqDto;

public interface FaqService {
	
	public List<FaqDto> selectFaqList() throws Exception;
	public void insertFaq(FaqDto faq) throws Exception;
	public void deleteFaq(int faqIdx) throws Exception;
	public void updateFaq(FaqDto faqDto) throws Exception;
	

}
