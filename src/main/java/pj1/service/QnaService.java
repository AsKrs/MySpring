package pj1.service;

import java.util.List;

import pj1.dto.QnaDto;

public interface QnaService {

	public List<QnaDto> selectQnaList(int itemIdx) throws Exception;

	public List<QnaDto> selectAllQnaList() throws Exception;
	
	public QnaDto selectQnaDetail(int qnaIdx) throws Exception;

	public QnaDto selectQnaAnswer(int qnaIdx) throws Exception;

	public void insertQna(QnaDto qnaDto) throws Exception;

	public void deleteQna(int qnaIdx) throws Exception;
	
	public void insertQnaComment(QnaDto qna) throws Exception;
	
}
