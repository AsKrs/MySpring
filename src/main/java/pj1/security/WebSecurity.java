package pj1.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import pj1.service.MemberService;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

// 의존 객체를 생성자를 통해서 주입 
	private MemberService memberService;
	private BCryptPasswordEncoder passwordEncoder;
	private Environment env;
	private JwtTokenUtil jwtTokenUtil;
	private JwtRequestFilter jwtRequestFilter;

	public WebSecurity(MemberService memberService, BCryptPasswordEncoder passwordEncoder, Environment env,JwtTokenUtil jwtTokenUtil, JwtRequestFilter jwtRequestFilter) {
		this.memberService = memberService;
		this.passwordEncoder = passwordEncoder;
		this.env = env;
		this.jwtTokenUtil = jwtTokenUtil;
		this.jwtRequestFilter = jwtRequestFilter;
		
	}

//	   @Override
//	   protected void configure(HttpSecurity http) throws Exception { 
//	      http.formLogin();
//	      http.authorizeHttpRequests()
//	         .anyRequest().authenticated();
//	   }

// 접근 권한과 관련한 설정
	@Override
	   protected void configure(HttpSecurity http) throws Exception {
	      http.csrf().disable();
	      http.authorizeRequests()
	      //.antMatchers("/**").permitAll()
	      //.access("hasRole('ADMIN')")
	      .antMatchers("/item/**").permitAll()
	      .antMatchers("/files/**").permitAll()
	         .antMatchers("/login").permitAll()
	         .antMatchers("/member/**").permitAll()
	         .antMatchers("/result/**").permitAll()
	         .antMatchers("/service/**").permitAll()
	         .antMatchers("/mypage/**").permitAll()
	         .antMatchers("/order/**").permitAll()
	         .antMatchers("/qna/**").permitAll()
	         .antMatchers("/notice/**").permitAll()
	         .antMatchers("/review/**").permitAll()
	         .antMatchers("/cart/**").permitAll()
	         .antMatchers("/admin/**").access("hasRole('ADMIN')")
	         .anyRequest().authenticated()
	         .and().addFilter(getAuthenticationFilter())
	         .addFilterBefore(jwtRequestFilter, AuthenticationFilter.class)
	         .cors();
	   }
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000","http://192.168.0.34:3000"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
		configuration.setAllowCredentials(true);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}


	private AuthenticationFilter getAuthenticationFilter() throws Exception {
		AuthenticationFilter authenticationFilter = new AuthenticationFilter(memberService, env, jwtTokenUtil);
		authenticationFilter.setAuthenticationManager(authenticationManager());
		return authenticationFilter;
	}

//인증 처리에 필요한 설정
	// 사용자 정보를 조회할 서비스와 패스워드 암호화에 사용할 방식을 지정
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(memberService).passwordEncoder(passwordEncoder);

	}
	

	
}
