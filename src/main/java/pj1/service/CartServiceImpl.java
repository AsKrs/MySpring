package pj1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pj1.dto.CartDto;
import pj1.dto.CartListDto;
import pj1.mapper.CartMapper;
import pj1.mapper.ItemMapper;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartMapper cartMapper;
	@Override
	public int insertCart(CartDto cartDto) throws Exception {
		
		return cartMapper.insertCart(cartDto);
	}

	@Override
	public List<CartListDto> selectCartList(String memEmail) throws Exception {
		return cartMapper.selectCartList(memEmail);
	}

	@Override
	public int deleteCartList(List<Integer> cartListDto) throws Exception {
		System.out.println(cartListDto);
		return cartMapper.deleteCartList(cartListDto);
	}

	@Override
	public int updateCartList(int itemAmount, int cartIdx) throws Exception {
		return cartMapper.updateCartList(itemAmount, cartIdx);
	}

}
