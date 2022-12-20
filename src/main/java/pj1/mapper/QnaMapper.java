package pj1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pj1.dto.QnaDto;

@Mapper
public interface QnaMapper {
	List<QnaDto> selectQnaList(int itemIdx) throws Exception;

	public List<QnaDto> selectAllQnaList() throws Exception;

	QnaDto selectQnaDetail(int qnaIdx) throws Exception;

	QnaDto selectQnaAnswer(int qnaIdx) throws Exception;

	void insertQna(QnaDto qnaDto) throws Exception;

	void insertQnaComment(QnaDto qna) throws Exception;

	void deleteQna(int qnaIdx) throws Exception;
}
