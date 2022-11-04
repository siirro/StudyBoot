package com.iu.home.member;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("mypage")
	public String getMyPage()throws Exception{
		return "member/mypage";
	}
	
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
		log.info("==== 내가만든 logout 메서드 ====");
		session.invalidate();
		
		return "redirect:../";
	}
	
	@GetMapping("login")
	public void getLogin(@RequestParam(defaultValue="false", required=false) boolean error, String message, Model model)throws Exception{
		if(error) {
			model.addAttribute("msg", "ID 또는 PW를 확인하세요");
		}
		//Controller에서 받아서 jsp로 다시 보내도 됨
//		return "member/login";
	}
	
	//securityconfig에서 대체
	@PostMapping("login")
	public String getLogin(MemberVO memberVO, HttpSession session)throws Exception{
//		ModelAndView mv = new ModelAndView();
//		memberVO = memberService.getLogin(memberVO);
//		
//		int result = 0;
//		String message = "로그인 실패";
//		
//		if(memberVO!=null) {
//			session.setAttribute("member", memberVO);
//			result = 1;
//			message = "로그인 성공";
//		}
//		
//		mv.setViewName("redirect:../");
//		return mv;
		log.info("======== Login Controller ===== ");
		return "member/login";
	}
	
	@GetMapping("add")
	public String setJoin(@ModelAttribute MemberVO memberVO)throws Exception{
//		MemberVO memberVO = new MemberVO();
//		model.addAttribute("vo", memberVO);
		return "member/join";
	}
	
	@PostMapping("add")
	public ModelAndView setJoin(ModelAndView mv, @Valid MemberVO memberVO, BindingResult bindingResult)throws Exception{
		
//		if(bindingResult.hasErrors()) {
//			//검증에 실패하면 회원가입하는 jsp로 foward
//			log.info("======= 검증 에러 발생 ========");
//			mv.setViewName("member/join");
//			return mv;
//		}
		
		boolean check = memberService.getMemberError(memberVO, bindingResult);
		if(check) {
			log.info("======= 검증 에러 발생 ========");
			mv.setViewName("member/join");
			//====================================
			List<FieldError> errors = bindingResult.getFieldErrors();
			
			for(FieldError fieldError:errors) {
				log.info("FieldError => {} ", fieldError);
				log.info("Field = {} ", fieldError.getField());
				log.info("Message => {}", fieldError.getRejectedValue());
				log.info("Default => {}", fieldError.getDefaultMessage());
				log.info("Code => {}", fieldError.getCode());
				log.info("=======================================");
				mv.addObject(fieldError.getField(), fieldError.getDefaultMessage());
			}
			
			return mv;
		}
		
//		int result = memberService.setJoin(memberVO);
		mv.setViewName("redirect:../");
		return mv;
	}

}
