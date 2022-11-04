package com.iu.home.member.security;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginFail implements AuthenticationFailureHandler{
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.info("============= 로그인 실패 ============");
		log.info("ClassName => {}", exception.getClass().toString());
		log.info("LocalMessage => {}", exception.getLocalizedMessage());
		log.info("Cause => {}", exception.getCause());
		log.info("Message => {}", exception.getMessage());
//		String name = exception.getClass().toString();
//		name = name.substring(name.lastIndexOf("."));
//		if(name.equals(".BadCredentialsException")) {
//			name = "비번 틀림";
//		}
//		name = URLEncoder.encode(name, "UTF-8");
		String result = null;
		// 참조변수명 instanceof 클래스명
		if(exception instanceof BadCredentialsException) {
			result = "비번 틀림";
		}else if(exception instanceof InternalAuthenticationServiceException){
			result = "없는 아이디다";
		}else {
			result = "로그인 실패";
		}
		
		// 1. 리다이렉트로 바로 로그인하기 (간편)
		//result = URLEncoder.encode(result, "UTF-8");
		//response.sendRedirect("/member/login?error=true&message="+result);
		
		// 2. JSP를 바로 찾아감
//		request.setAttribute("msg", result);
//		request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
		
		// 3-1. POST 방식으로 Controller의 메서드를 요청함. 컨트롤러 만들어야함 (굳이...)
		request.getRequestDispatcher("/member/login?message="+result).forward(request, response);
				
		// 3-2. 주소창 꺠끗하게..
//		request.setAttribute("msg", result);
//		request.getRequestDispatcher("/member/login").forward(request, response);
		
		
	}

}
