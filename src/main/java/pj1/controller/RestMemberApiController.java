package pj1.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import pj1.dto.MemberDto;
import pj1.service.MemberService;
import pj1.vo.RequestVo;
import pj1.vo.ResponseVo;

@Slf4j
@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class RestMemberApiController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private MemberService memberService;
	
	public RestMemberApiController(MemberService memberService, BCryptPasswordEncoder passwordEncoder) {
		this.memberService = memberService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public List<MemberDto> openMemberList() throws Exception {
		return memberService.selectMemberList();
	}
	
	
	@RequestMapping(value="/member/{memEmail}", method = RequestMethod.GET)
	public MemberDto openDetailMember(
			@Parameter(description = "회원 이메일", required = true, example = "이메일") @PathVariable("memEmail") String memEmail) throws Exception {
		return memberService.selectDetailMember(memEmail);
	}
	
	@RequestMapping(value="/changeAddr", method = RequestMethod.POST)
	public ResponseEntity<String> changeAddr(@RequestBody MemberDto member) throws Exception {
		System.out.println(member);
		return null;
	}
	
	
	@RequestMapping(value="/member/join", method = RequestMethod.POST)
	public ResponseEntity<String> insertMember(@RequestBody MemberDto member) throws Exception {
		
		
		System.out.println(member);

		int memIdx = memberService.insertMember(member);
		if (memIdx>0) {
			return ResponseEntity.status(HttpStatus.OK).body("등록성공");
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("등록실패");
		}
		
	}
	
	
	@RequestMapping(value = "/member/findpw", method = RequestMethod.POST)
	public ResponseEntity<MemberDto> findPassword(@RequestBody MemberDto member) throws Exception {
		
		System.out.println(">>>>>>>>>>>>호출");
		MemberDto memberDto = memberService.findPassword(member);
		if (memberDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(memberDto);
		}
	}
	
	@RequestMapping(value="/member/{memName}/{memPhone}",method = RequestMethod.GET)
	public ResponseEntity<MemberDto> findEmail(@PathVariable("memName") String memName,@PathVariable("memPhone") String memPhone ) throws Exception {
		System.out.println(memName);
		System.out.println(memPhone);
		
		MemberDto memberDto = memberService.findEmail(memName,memPhone);
		if (memberDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}else {
			return ResponseEntity.ok(memberDto);
		}
	}
	
	@RequestMapping(value = "member/checkemail/{memEmail}",method = RequestMethod.GET)
	public ResponseEntity<MemberDto> validateMemberEmail(@PathVariable("memEmail") String memEmail) throws Exception {
		
		System.out.println(memEmail);
		
		MemberDto memberDto = memberService.validateMemberEmail(memEmail);
		if (memberDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	   } else {
		   return ResponseEntity.ok(memberDto);
	   }
		
	}
	
	@RequestMapping(value = "/admin/mem/{memIdx}", method=RequestMethod.GET)
	public ResponseEntity<MemberDto> selectMemberDetail(@PathVariable("memIdx")int memIdx) throws Exception{
		MemberDto memberDto = memberService.selectMemberDetail(memIdx);
		if(memberDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}else {
			return ResponseEntity.ok(memberDto);
		}
	}
	
	@RequestMapping(value = "/member/comparepw/{memIdx}", method = RequestMethod.POST)
	public ResponseEntity<Integer> comparePw(@PathVariable("memIdx") int memIdx, @ModelAttribute("memPw") String memPw)throws Exception {
		String memberPass = memberService.selectMemberDetail(memIdx).getMemPw();
		if (passwordEncoder.matches(memPw, memberPass)) {
			System.out.println("입력값(memPw) : " + memPw);
			System.out.println("유저 비밀번호(memberPass) : " + memberPass);
			return ResponseEntity.status(HttpStatus.OK).body(memIdx);
		} else {
			System.out.println("입력값(memPw) 틀림: " + memPw);
			System.out.println("유저 비밀번호(memberPass) 틀림 : " + memberPass);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@RequestMapping(value = "/admin/mem/{memIdx}", method=RequestMethod.PUT)
	public void adminmemupdate(@PathVariable("memIdx") int memIdx, @RequestBody MemberDto memberDto) throws Exception{
		memberDto.setMemIdx(memIdx);
		memberService.adminmemupdate(memberDto);
	}
	
	@RequestMapping(value = "/admin/mem/{memIdx}", method=RequestMethod.DELETE)
	public void ydeleteMember(@PathVariable("memIdx") int memIdx) throws Exception{
		memberService.ydeleteMember(memIdx); 
	}
	
	@RequestMapping(value = "/member/updatepw/{memIdx}", method = RequestMethod.PUT)
	public void updateMemberPW(@PathVariable("memIdx") int memIdx, @RequestBody MemberDto memberDto) throws Exception {
		memberService.updateMemberPW(memberDto);
		
	}
	
	
	@RequestMapping(value = "/member/myinfo/{memIdx}", method = RequestMethod.GET)
	public ResponseEntity<MemberDto> openMemberDetail(@PathVariable("memIdx") int memIdx) throws Exception {
		MemberDto memberDto = memberService.selectMemberDetail(memIdx);
		if (memberDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.ok(memberDto);
		}
	}
	

	@RequestMapping(value = "/member/updateinfo/{memIdx}", method = RequestMethod.PUT)
	public void updateMemberInfo(@PathVariable("memIdx") int memIdx, @RequestBody MemberDto memberDto) throws Exception{
		memberService.updateMemberInfo(memberDto);
	}
	
	
	@RequestMapping(value = "/admin/memberdelete/{memIdx}", method = RequestMethod.POST)
	public void deleteMemberInfo(@PathVariable("memIdx") int memIdx) throws Exception {
		memberService.deleteMemberInfo(memIdx);
	}
	
	
	@RequestMapping(value = "/admin/mem", method = RequestMethod.GET)
	public List<MemberDto> openAdminMemberList() throws Exception {
		return memberService.selectMemberList();
	}
	
	
	
	


}
