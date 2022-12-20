package pj1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pj1.dto.MemberDto;
import pj1.mapper.MemberMapper;
import pj1.vo.RequestVo;
import pj1.vo.ResponseVo;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	private BCryptPasswordEncoder passwordEncoder;
	
	
	public MemberServiceImpl(MemberMapper memberMapper, BCryptPasswordEncoder passwordEncoder) {
		this.memberMapper = memberMapper;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public MemberDto selectMemberDetail(int memIdx) throws Exception {
		
		return memberMapper.selectMemberDetail(memIdx);
	}

	@Override
	public void updateMemberInfo(MemberDto memberDto) throws Exception {
		memberDto.setMemPw(passwordEncoder.encode(memberDto.getMemPw()));
		int count = memberMapper.updateMemberInfo(memberDto);
		System.out.println("xxxxxxxxxxxxxxxxx" + count);
	}

	@Override
	public void deleteMemberInfo(int memIdx) throws Exception {
		int count = memberMapper.deleteMemberInfo(memIdx);
		System.out.println("xxxxxxxxxxxxxxxxx" + count);
	}

	@Override
	public List<MemberDto> selectMemberList() throws Exception {
		return memberMapper.selectMemberList();
	}
	
	@Override
	public int insertMember(MemberDto member) throws Exception {
		System.out.println("암호화전:" +member.getMemPw());
		member.setMemPw(passwordEncoder.encode(member.getMemPw()));
		System.out.println("암호화후:" +member.getMemPw());
		memberMapper.insertMember(member);
		return member.getMemIdx();
	}
	
	@Override
	public ResponseVo login(RequestVo requestVo) throws Exception {
		// 아이디(=이메일)와 일치하는 사용자 정보를 조회
		
		// 정보가 없는 경우, null을 반환
		
		// 정보가 있는 경우, passwordEncoder.matches() 메서드를 통해서 패스워드를 검증
		
		//     검증 결과가 false 이면, null을 반환
		
		//     검증 결과가 true 이면, 회원 정보를 설정해서 반환
		
		MemberDto memberDto = new MemberDto();
		memberDto.setMemEmail(requestVo.getMemEmail());
		 memberDto.setMemPw(requestVo.getMemPw());
		 
		

		MemberDto resultDto = memberMapper.login(memberDto);
		if (resultDto == null) 
			return null;

		ResponseVo responseVo = new ResponseVo();
		if (passwordEncoder.matches(requestVo.getMemPw(), resultDto.getMemPw())) {
			responseVo.setMemEmail(resultDto.getMemEmail());
			responseVo.setMemIdx(resultDto.getMemIdx());
			responseVo.setMemName(resultDto.getMemName());
		}else {
			return null;
		}
		return responseVo;
	}

	@Override
	public MemberDto selectDetailMember(String memEmail) throws Exception {
		
		return memberMapper.selectDetailMember(memEmail);
	}


	@Override
	public void ydeleteMember(int memIdx) throws Exception {
		memberMapper.ydeleteMember(memIdx);
		
	}

	@Override
	public void adminmemupdate(MemberDto memberDto) throws Exception {
		memberMapper.adminmemupdate(memberDto);
		
	}
	
	@Override
	public MemberDto validateMemberEmail(String memEmail) throws Exception {
		return memberMapper.validateMemberEmail(memEmail);
	}

	@Override
	public MemberDto findEmail(String memName,String memPhone) throws Exception {
		return memberMapper.findEmail(memName, memPhone);
	}
	@Override
	public MemberDto findPassword(MemberDto memberDto) throws Exception {
		return memberMapper.findPassword(memberDto);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberDto memberDto = memberMapper.findByMemberEmail(username);
		if (memberDto ==null) {
			throw new UsernameNotFoundException(username);
		}
		
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(memberDto.getRole()));
		
		// String username, String password, boolean enabled, boolean accountNonExpired,
		// boolean credentialsNonExpired, boolean accountNonLocked,
		// Collection<? extends GrantedAuthority> authorities
		return new User(memberDto.getMemEmail(), memberDto.getMemPw(),
				true,true,true,true,authorities);
	}
	
	@Override
	public void updateMemberPW(MemberDto memberDto) throws Exception {
		memberDto.setMemPw(passwordEncoder.encode(memberDto.getMemPw()));
		memberMapper.updateMemberPW(memberDto);
	}
	
	@Override
	public MemberDto getMemberDetailByEmail(String username) {
		MemberDto memberDto = memberMapper.findByMemberEmail(username);
		if (memberDto == null) {
			throw new UsernameNotFoundException(username);
		}
		return memberDto;
	}


	
}
