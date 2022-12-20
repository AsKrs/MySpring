package pj1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj1.dto.QnaDto;
import pj1.mapper.QnaMapper;

@Service
public class QnaServiceImpl implements QnaService {
	@Autowired
	private QnaMapper qnaMapper;
	
	@Override
	public List<QnaDto> selectQnaList(int itemIdx) throws Exception {
		return qnaMapper.selectQnaList(itemIdx);
	}

	@Override
	public List<QnaDto> selectAllQnaList() throws Exception{
		return qnaMapper.selectAllQnaList();
	}
	
	@Override
	public QnaDto selectQnaDetail(int qnaIdx) throws Exception {
		return qnaMapper.selectQnaDetail(qnaIdx);
	}

	@Override
	public QnaDto selectQnaAnswer(int qnaIdx) throws Exception {
		
		return qnaMapper.selectQnaAnswer(qnaIdx);
	}
	@Override
	public void deleteQna(int qnaIdx) throws Exception {
		qnaMapper.deleteQna(qnaIdx);
	}
	@Override
	public void insertQna(QnaDto qnaDto) throws Exception {
		qnaMapper.insertQna(qnaDto);
	}
	
	@Override
	public void insertQnaComment(QnaDto qna) throws Exception {
		qnaMapper.insertQnaComment(qna);
	}
}
