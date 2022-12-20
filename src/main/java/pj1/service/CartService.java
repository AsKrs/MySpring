package pj1.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import pj1.dto.CartDto;
import pj1.dto.CartListDto;

public interface CartService {
	public int insertCart(CartDto cartDto) throws Exception;
	public List<CartListDto> selectCartList(String memEmail) throws Exception;
	public int deleteCartList(List<Integer> cartListDto) throws Exception;
	public int updateCartList(int itemAmount, int cartIdx) throws Exception;
}
