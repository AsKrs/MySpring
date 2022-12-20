package pj1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj1.dto.FaqDto;
import pj1.mapper.FaqMapper;

@Service
public class FaqServiceImpl implements FaqService {

	@Autowired
	private FaqMapper faqMapper;
	
	@Override
	public List<FaqDto> selectFaqList() throws Exception {
		return faqMapper.selectFaqList();
	}

	@Override
	public void insertFaq(FaqDto faq) throws Exception {
		faqMapper.insertFaq(faq);
	}

	@Override
	public void deleteFaq(int faqIdx) throws Exception {
		faqMapper.deleteFaq(faqIdx);
		
	}

	@Override
	public void updateFaq(FaqDto faqDto) throws Exception {
		faqMapper.updateFaq(faqDto);
		
	}

}
