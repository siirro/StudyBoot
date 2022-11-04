package com.iu.home.member.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginSuccess implements AuthenticationSuccessHandler{
	
	//on : ~~했을 때
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		log.info("============== 로그인 성공 ==============");
		log.info("Auth => {}",authentication);
		log.info("ID : {}", request.getParameter("id"));
		
		String check = request.getParameter("rememberId");
		log.info("Check => {}", check);
		
		

		
		//왜 check=="on"은 불안한가? 체크를 하지않으면 널이 뜨기때문에 equals("on")을 판단할때 널포인트가뜬다.
		if(check!=null) {
			Cookie cookie = new Cookie("userId", request.getParameter("id"));
			cookie.setHttpOnly(true);
			cookie.setMaxAge(600);//60초 후 쿠키 사라짐 ..
			cookie.setPath("/"); //같은 도메인 내에서 어느 url에 사용 가능 하느냐? /를 쓰면 모든 도메인에서 쓸수있다는뜻.
			response.addCookie(cookie);
		} else {
			Cookie [] cookies = request.getCookies();
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("userId")) {
					cookie.setMaxAge(0);
					cookie.setPath("/"); //쿠키 삭제시 쿠키를 만들 때의 path와 동일해야 함
					response.addCookie(cookie);
				}
			}
		}
		
		response.sendRedirect("/");
	}
	
	

}
