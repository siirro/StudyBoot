package com.iu.home;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Autowired
	private QnaMapper qnaMapper;
	
	@GetMapping("/")
	
	public ModelAndView home(Pager pager, HttpSession session) throws Exception {
		log.info("==========================");
		log.info("Message : {}", message);
		log.info("default : {}", app);
		
		ModelAndView mv = new ModelAndView();
//		MemberVO memberVO = new MemberVO();
//		memberVO = (MemberVO)session.getAttribute("member");
//		mv.addObject("member", memberVO);
		mv.setViewName("index");
		return mv;
	}
}
