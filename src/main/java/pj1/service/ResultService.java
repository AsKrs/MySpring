package pj1.service;

import java.util.List;

import pj1.dto.ResultDto;

public interface ResultService {
	public List<ResultDto> selectResultList() throws Exception;
	public void insertResult(ResultDto result) throws Exception;
	public ResultDto selectResultDetail(int resultIdx) throws Exception;
	public void deleteResult(int resultIdx) throws Exception;
}
