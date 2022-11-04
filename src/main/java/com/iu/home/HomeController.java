package com.iu.home;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.qna.QnaMapper;
import com.iu.home.board.qna.QnaVO;
import com.iu.home.member.MemberVO;
import com.iu.home.util.Pager;

@Controller
public class HomeController {
	
//	@Value("${my.message.hi}")
	private String message;
	@Value("${my.default}")
	private String app;
	
	//로거-클래스 가져오는 방법 2개!
//	private final Logger log = LoggerFactory.getLogger(HomeController.class);
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/admin")
	@ResponseBody
	public String admin() {
		return "Admin Role";
	}
	
	@GetMapping("/manager")
	@ResponseBody
	public String manager() {
		return "Manager Role";
	}
	
	@GetMapping("/user")
	@ResponseBody
	public String member() {
		return "Member Role";
	}
	
	@Autowired
	private QnaMapper qnaMapper;
	
	@GetMapping("/")
	
	public ModelAndView home(HttpSession session) throws Exception {
		log.info("==========================");
		Enumeration<String> en = session.getAttributeNames();
		
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			log.info("Key => {} ", key);
		}
		
		SecurityContextImpl context = (SecurityContextImpl)session.getAttribute("SPRING_SECURITY_CONTEXT");
		if(context != null) {
	//		log.info("SecurityContext => {} ", ((MemberVO)context.getAuthentication().getPrincipal()).getId());
			log.info("SecurityContext => {} ", context);
		}
		log.info("Message : {}", message);
		log.info("default : {}", app);
		log.info("==========================");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
}
