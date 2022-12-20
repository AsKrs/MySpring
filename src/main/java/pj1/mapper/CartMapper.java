package pj1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.http.ResponseEntity;

import pj1.dto.CartDto;
import pj1.dto.CartListDto;

@Mapper
public interface CartMapper {
	int insertCart(CartDto cartDto) throws Exception;
	List<CartListDto> selectCartList(String memEmail) throws Exception;
	
	int deleteCartList(List<Integer> cartListDto) throws Exception;
	
	int updateCartList(int itemAmount, int cartIdx) throws Exception;
}
