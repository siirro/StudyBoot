package com.iu.home.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.qna.QnaFileVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileManageController {
	
	@GetMapping("/fileDown/{path}") //RestFul, RestAPI
	public ModelAndView fileDown(@PathVariable String path, QnaFileVO qnaFileVO)throws Exception{
		log.info("Path : {}", path);
		ModelAndView mv = new ModelAndView();
		
		//DB에서 정보 조회
		if(path.equals("qna")) {
			
		} else if(path.equals("notice")) {
			
		}
		qnaFileVO.setFileName("3c9f8f5f-7e44-4049-930e-3cc7d0ad7881_title3.jpg");
		qnaFileVO.setOriName("title3.jpg");
		
		mv.addObject("fileVO", qnaFileVO);
		mv.addObject("path", path);
		mv.setViewName("fileManager");
		
		return mv;
	}
	


}
