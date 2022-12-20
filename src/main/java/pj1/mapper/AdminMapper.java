package pj1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pj1.dto.AdminDto;
import pj1.dto.ItemDto;
import pj1.dto.MemberDto;


@Mapper
public interface AdminMapper {
	
	List<AdminDto> selectAllReview() throws Exception;
	int deleteReview(int reviewIdx) throws Exception;
	int showReview(int reviewIdx) throws Exception;
	List<AdminDto> selectAllRefund() throws Exception;
	void updateStatus(int refundIdx) throws Exception;
	List<ItemDto> selectAdminItemList() throws Exception;
	void deleteItem(String itemNum) throws Exception;
	
	int adminUpdateMemberPW(MemberDto memberDto) throws Exception;
	
}
