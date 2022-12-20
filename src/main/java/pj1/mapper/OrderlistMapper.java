package pj1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pj1.dto.OrderItemDto;
import pj1.dto.OrderlistDto;

@Mapper
public interface OrderlistMapper {

	List<OrderlistDto> selectOrderlist(int memIdx) throws Exception;
	List<OrderItemDto> selectAllOrderlist() throws Exception; //admin
	List<OrderlistDto> selectRefund(int memIdx) throws Exception;
	List<OrderlistDto> selectAbleReview(int memIdx) throws Exception;
	int insertReview(OrderlistDto orderlistDto) throws Exception;
	List<OrderlistDto> selectDidReview(int memIdx) throws Exception;
	OrderlistDto selectReviewDetail(int reviewIdx) throws Exception;
	int updateReview(OrderlistDto orderlistDto) throws Exception;
	int orderCancelNow(int orderlistIdx) throws Exception;
	int orderCancelPlz(int orderlistIdx) throws Exception;
	int itemPurchase(int orderlistIdx) throws Exception;
	int insertAbleReview(OrderlistDto orderlistDto) throws Exception;
	int orderListDelete(String orderNum) throws Exception;
	
	int updateRefund(int orderlistIdx) throws Exception;
	int insertMyRefund(OrderlistDto orderlistDto) throws Exception;
	int updateRefundCancel(int orderlistIdx) throws Exception;
	int deleteRefund(int refundIdx) throws Exception;
	

	
	
	
	//admin
	int orderDelete(String orderNum) throws Exception;
	int orderState(int orderlistIdx) throws Exception;
	int orderStateDelivery(int orderlistIdx) throws Exception;
	int orderStateComple(int orderlistIdx) throws Exception;
	int orderStateCancle(int orderlistIdx) throws Exception;
	
	
}
