package pj1.security;

import java.io.IOException;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import pj1.dto.MemberDto;
import pj1.service.MemberService;
import pj1.vo.RequestVo;

@Slf4j
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private MemberService memberService;
	private Environment env;
	private JwtTokenUtil jwtTokenUtil;
	

	public AuthenticationFilter(MemberService memberService, Environment env, JwtTokenUtil jwtTokenUtil) {
		this.memberService = memberService;
		this.env = env;
		this.jwtTokenUtil = jwtTokenUtil;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			RequestVo creds = new ObjectMapper().readValue(request.getInputStream(), RequestVo.class);

			return getAuthenticationManager().authenticate(
					new UsernamePasswordAuthenticationToken(creds.getMemEmail(), creds.getMemPw(), new ArrayList<>()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		String username = ((User) authResult.getPrincipal()).getUsername();
		
		MemberDto memberDto = memberService.getMemberDetailByEmail(username);
		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>");
		log.debug(memberDto.toString());
		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>");

		
//		String secret = env.getProperty("token.secret");
//		Key hmacKey = new SecretKeySpec(
//				Base64.getDecoder().decode(secret), SignatureAlgorithm.HS256.getJcaName()
//		);
//
//
//		
//		Instant now = Instant.now();
//		Long expirationTime = Long.parseLong(env.getProperty("token.expiration-time"));
//		String jwtToken = Jwts.builder().claim("name", memberDto.getMemName())
//				.claim("email", memberDto.getMemEmail()).setSubject(String.valueOf(memberDto.getMemIdx()))
//				.setId(UUID.randomUUID().toString()).setIssuedAt(Date.from(now))
//				.setExpiration(Date.from(now.plus(expirationTime, ChronoUnit.MILLIS))).signWith(hmacKey).compact();
//		log.debug(jwtToken);
		
		String jwtToken = jwtTokenUtil.generateToken(memberDto);
		
		response.setHeader("token",jwtToken);
		response.getWriter().write(jwtToken);
//		response.getWriter().write(memberDto.getMemEmail());
	}

}
