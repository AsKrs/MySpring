package pj1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pj1.dto.OrderItemDto;

@Mapper
public interface OrderMapper {
	
	int insertOrder(OrderItemDto orderInfo) throws Exception;
	int insertOrderDetail(List<OrderItemDto> orderInfo) throws Exception;

}
