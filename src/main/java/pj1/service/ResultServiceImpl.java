package pj1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pj1.dto.ResultDto;
import pj1.mapper.ResultMapper;

@Service
@Transactional
public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultMapper resultMapper;
	
	@Override
	public List<ResultDto> selectResultList() throws Exception {
		return resultMapper.selectResultList();
	}

	@Override
	public void insertResult(ResultDto result) throws Exception {
		resultMapper.insertResult(result);
	}

	@Override
	public ResultDto selectResultDetail(int resultIdx) throws Exception {		
		return resultMapper.selectResultDetail(resultIdx);
	}
	@Override
	public void deleteResult(int resultIdx) throws Exception {
		resultMapper.deleteResult(resultIdx);
	}

}
