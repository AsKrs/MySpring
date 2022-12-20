package pj1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pj1.dto.ResultDto;

@Mapper
public interface ResultMapper {
	List<ResultDto> selectResultList() throws Exception;

	void insertResult(ResultDto result) throws Exception;

	ResultDto selectResultDetail(int resutlIdx) throws Exception;
	
	void deleteResult(int resultIdx) throws Exception;
}
