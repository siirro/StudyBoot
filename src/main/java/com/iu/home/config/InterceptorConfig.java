package com.iu.home.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.iu.home.interceptors.StudyInterceptor;
import com.iu.home.interceptors.TestInterceptor;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class InterceptorConfig implements WebMvcConfigurer{
	
	@Autowired
	private TestInterceptor testInterceptor;
	@Autowired
	private StudyInterceptor studyInterceptor;
	@Autowired
	private LocaleChangeInterceptor localeChangeInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//method chaining
		//적용할 Interceptor 등록
		registry.addInterceptor(testInterceptor)
		//Interceptor를 적용할 URL 등록
				.addPathPatterns("/qna/**")
		//제외할 URL 등록
				.excludePathPatterns("/qna/detail")
				.excludePathPatterns("/qna/list");
		
		//추가 Interseptor 등록
		registry.addInterceptor(studyInterceptor)
				.addPathPatterns("/qna/**");
		
		//message Interseptor 등록
		registry.addInterceptor(localeChangeInterceptor)
				.addPathPatterns("/**");
		
		//인터셉터 순서 : 같은 URL로 여러개의 인터셉터가 있는 경우 config class에 등록된 순서대로 적용
//		WebMvcConfigurer.super.addInterceptors(registry);
	}

}
