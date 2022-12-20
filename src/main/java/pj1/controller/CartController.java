package pj1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import pj1.dto.CartDto;
import pj1.dto.CartListDto;
import pj1.service.CartService;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartController {

	@Autowired
	private CartService cartService;

	@ApiOperation(value = "장바구니 등록", notes = "장바구니 등록")
	@RequestMapping(value = "/cart/insert", method = RequestMethod.POST)
	public ResponseEntity<Object> insertCart(@RequestBody CartDto cartDto) throws Exception {

		int success = cartService.insertCart(cartDto);

		if (success > 0) {
			return ResponseEntity.status(HttpStatus.OK).body("등록성공");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("등록실패");
		}

	}

	@ApiOperation(value = "나의 장바구니 리스트 조회", notes = "나의 장바구니 리스트 조회")
	@RequestMapping(value = "/cart/{memEmail}", method = RequestMethod.GET)
	public List<CartListDto> openCartList(
			@Parameter(description = "회원 이메일", required = true, example = "이메일") @PathVariable("memEmail") String memEmail)
			throws Exception {
		return cartService.selectCartList(memEmail);
	}

	@ApiOperation(value = "장바구니 삭제", notes = "장바구니 삭제")
	@RequestMapping(value = "/cart/delete", method = RequestMethod.POST)
	// (value="arr[]" String[] arr)
	public List<CartListDto> deletedCart(@RequestBody List<CartListDto> cartListDto) throws Exception {

		List<Integer> cartIdx = new ArrayList<Integer>();

		System.out.println(">>>>>>>>>>>>>>>>>>>>>");

		System.out.println(cartListDto);
		for (int i = 0; i < cartListDto.size(); i++) {
			cartIdx.add(cartListDto.get(i).getCartIdx());
		}
		
		System.out.println(cartIdx);

		int success = cartService.deleteCartList(cartIdx);
		return cartService.selectCartList(cartListDto.get(0).getMemEmail());
	}
	
	@ApiOperation(value = "장바구니 수량 수정", notes = "장바구니 수량 수정")
	@RequestMapping(value = "/cart/update", method = RequestMethod.POST)
	public List<CartListDto> updateCart(@RequestBody CartListDto cartListDto) throws Exception {
		
		cartService.updateCartList(cartListDto.getItemAmount(), cartListDto.getCartIdx());
		
		return cartService.selectCartList(cartListDto.getMemEmail());
		
	}
	
	


}
