package pj1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pj1.dto.AdminDto;
import pj1.dto.ItemDto;
import pj1.dto.MemberDto;
import pj1.service.AdminService;
import pj1.service.MemberService;
import pj1.service.OrderlistService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	private MemberService memberService;
	private BCryptPasswordEncoder passwordEncoder;
	
	public AdminController(MemberService memberService, BCryptPasswordEncoder passwordEncoder, AdminService adminService) {
		this.memberService = memberService;
		this.passwordEncoder = passwordEncoder;
		this.adminService = adminService;
	}

	@RequestMapping(value = "/admin/comparepw/{memIdx}", method = RequestMethod.POST)
	public ResponseEntity<Integer> compareAdminPw(@PathVariable("memIdx") int memIdx, @ModelAttribute("memPw") String memPw)throws Exception {
		String adminPass = memberService.selectMemberDetail(memIdx).getMemPw();
		if (passwordEncoder.matches(memPw, adminPass)) {
			System.out.println("입력값(memPw) : " + memPw);
			System.out.println("유저 비밀번호(adminPass) : " + adminPass);
			return ResponseEntity.status(HttpStatus.OK).body(memIdx);
		} else {
			System.out.println("입력값(memPw) else: " + memPw);
			System.out.println("유저 비밀번호(adminPass) else : " + adminPass);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	
	@RequestMapping(value = "/admin/review", method = RequestMethod.GET)
	public List<AdminDto> selectAllReview() throws Exception { 
		return adminService.selectAllReview();
	}
	
	@RequestMapping(value = "/admin/review/remove/{reviewIdx}", method = RequestMethod.DELETE)
	public void deleteReview(@PathVariable("reviewIdx") int reviewIdx) throws Exception{
		adminService.deleteReview(reviewIdx);
	}
	
	@RequestMapping(value = "/admin/review/show/{reviewIdx}", method = RequestMethod.DELETE)
	public void showReview(@PathVariable("reviewIdx") int reviewIdx) throws Exception{
		adminService.showReview(reviewIdx);
	}
	
	
	@RequestMapping(value = "/admin/refund", method = RequestMethod.GET)
	public List<AdminDto> selectAllRefund() throws Exception { 
		return adminService.selectAllRefund();
	}
	
	@RequestMapping(value = "/admin/refund/{refundIdx}", method = RequestMethod.PUT)
	public void updateStatus(@PathVariable("refundIdx") int refundIdx) throws Exception {
		adminService.updateStatus(refundIdx);
	}
	
	@RequestMapping(value ="/admin/item", method = RequestMethod.GET)
	public List<ItemDto> adminItemList() throws Exception {
		return adminService.selectAdminItemList();
	}
	
	@RequestMapping(value ="/admin/item/delete{itemNum}", method = RequestMethod.POST)
	public void itemDelete(@PathVariable("itemNum") String itemNum) throws Exception {
		System.out.println(itemNum);
		 adminService.deleteItem(itemNum);
	}
	
	@RequestMapping(value = "/admin/member/updateinfo/{memIdx}", method = RequestMethod.PUT)
	public void adminUpdateMemberInfo(@PathVariable("memIdx") int memIdx, @RequestBody MemberDto memberDto) throws Exception{
		
		adminService.adminUpdateMemberPW(memberDto);
	}
	
	
}
