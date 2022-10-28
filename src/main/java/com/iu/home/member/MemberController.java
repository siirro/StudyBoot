package com.iu.home.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.MvcNamespaceHandler;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
@Slf4j
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("test")
	@ResponseBody
	public MemberVO setTest(MemberVO memberVO)throws Exception{
		// , String [] ar 매개변수 잠깐뺌
		log.info("===================");
		log.info("ID : {}", memberVO.getId());
		log.info("Name : {}", memberVO.getName());
		
//		for(String s : ar) {
//			log.info("ar : {}", s);
//		}
		
		return memberVO;
		
		
	}
	
	@GetMapping("idCheck")
	@ResponseBody
	public int getIdCheck(MemberVO memberVO)throws Exception{
		
		int result = memberService.getIdCheck(memberVO);
		
//		if(result == 0) {
//			throw new Exception("테스트 익셉션이야");
//		}
		
		return result;
		
//		if(memberVO!=null) {
//			result = 1;
//		}else {
//			result = 0;
//		}
//		return result;
	}
	
	@GetMapping("logout")
	public String getLogout(HttpSession session)throws Exception{
		session.invalidate();
		
		return "redirect:../";
	}
	
	@GetMapping("login")
	public String getLogin()throws Exception{
		return "member/login";
	}
	
	@PostMapping("login")
	public ModelAndView getLogin(MemberVO memberVO, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		memberVO = memberService.getLogin(memberVO);
		
		
		int result = 0;
		String message = "로그인 실패";
		
		if(memberVO!=null) {
			session.setAttribute("member", memberVO);
			result = 1;
			message = "로그인 성공";
		}
		
		
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@GetMapping("add")
	public String setJoin(@ModelAttribute MemberVO memberVO)throws Exception{
//		MemberVO memberVO = new MemberVO();
//		model.addAttribute("vo", memberVO);
		return "member/join";
	}
	
	@PostMapping("add")
	public ModelAndView setJoin(ModelAndView mv, @Valid MemberVO memberVO, BindingResult bindingResult)throws Exception{
		
		if(bindingResult.hasErrors()) {
			//검증에 실패하면 회원가입하는 jsp로 foward
			log.info("======= 검증 에러 발생 ========");
			mv.setViewName("member/join");
			return mv;
		}
		
//		int result = memberService.setJoin(memberVO);
		mv.setViewName("redirect:../");
		return mv;
	}

}
