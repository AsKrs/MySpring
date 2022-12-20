package pj1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Parameter;
import pj1.dto.OrderItemDto;
import pj1.service.CartService;
import pj1.service.OrderService;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private CartService cartService;
	
	
	@RequestMapping(value="/order/insert", method = RequestMethod.POST)
	public int insertOrderInfo(@RequestBody List<OrderItemDto> orderInfo) throws Exception {
		
		OrderItemDto order = orderInfo.get(0);
	
		orderService.insertOrder(order);
		System.out.println(order);
		
		System.out.println(orderInfo);
		orderService.insertOrderDetail(orderInfo);
		
		List<Integer> cartIdx = new ArrayList<Integer>();

		System.out.println(">>>>>>>>>>>>>>>>>>>>>");

		for (int i = 0; i < orderInfo.size(); i++) {
			cartIdx.add(orderInfo.get(i).getCartIdx());
		}
		
		System.out.println(cartIdx);

		int success = cartService.deleteCartList(cartIdx);
	 
		 return 1;
		 
	}
		
		
	

}
