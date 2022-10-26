package com.iu.home.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.MvcNamespaceHandler;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("idCheck")
	@ResponseBody
	public int getIdCheck(MemberVO memberVO)throws Exception{
		memberVO = memberService.getIdCheck(memberVO);
		int result = 0;
		
		if(memberVO!=null) {
			result = 1;
		}else {
			result = 0;
		}
		return result;
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
	public String setJoin()throws Exception{
		return "member/join";
	}
	
	@PostMapping("add")
	public String setJoin(MemberVO memberVO)throws Exception{
		int result = memberService.setJoin(memberVO);
		return "redirect:../";
	}

}
