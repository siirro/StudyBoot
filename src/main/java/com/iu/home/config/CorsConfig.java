package com.iu.home.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig implements WebMvcConfigurer{
	
	//Spring Security를 사용하지 않을때(SecurityConfig가 없을때) 는 따로 config클래스를 생성해서 따로 작성한다.
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("http://example.com")
				.allowedMethods("*")
				.allowCredentials(false)
				.maxAge(300);
		
		
	}

}
