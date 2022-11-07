package com.iu.home.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.home.member.MemberVO;
import com.iu.home.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private QnaService qnaService;
	
	@PostMapping("hack")
	@ResponseBody
	public int hack(QnaVO qnaVO)throws Exception {
		qnaService.addQna(qnaVO);
		return 1;
	}
	
	@PostMapping("fileDelete")
	@ResponseBody
	public int setDeleteFile(QnaFileVO qnaFileVO)throws Exception{
		int result = qnaService.setDeleteFile(qnaFileVO);
		return result;
	}
	
	@GetMapping("update")
	public ModelAndView setUpdate(ModelAndView mv, QnaVO qnaVO)throws Exception{
		qnaVO = qnaService.getDetail(qnaVO);
		mv.addObject("vo", qnaVO);
		mv.setViewName("board/update");
		return mv;
	}
	
	@PostMapping("update")
	public String setUpdate(QnaVO qnaVO)throws Exception{
		int result = qnaService.setUpdate(qnaVO);
		return "redirect:./detail?num="+qnaVO.getNum();
	}
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<QnaVO> ar = qnaService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView getDetail(QnaVO qnaVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		qnaVO = qnaService.getDetail(qnaVO);
		mv.addObject("detail", qnaVO);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@GetMapping("add")
	public String addQna(@ModelAttribute QnaVO qnaVO)throws Exception{

		return "board/write";
	}
	
	@PostMapping("add")
	public ModelAndView addQna(@Valid QnaVO qnaVO, BindingResult bindingResult, RedirectAttributes redirectAttributes)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			mv.setViewName("board/write");
			return mv;
		}
		int result = qnaService.addQna(qnaVO);
		redirectAttributes.addAttribute("result", result);
		
		log.info("result는 {}", result);
		mv.setViewName("redirect:./list");
		return mv;
	}

}
