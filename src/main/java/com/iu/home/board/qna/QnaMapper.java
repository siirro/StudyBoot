package com.iu.home.board.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.iu.home.util.Pager;

//@Repository 이제 생략 가능..
@Mapper
public interface QnaMapper {
	
	public List<QnaVO> getList(Pager pager)throws Exception;
	
	public QnaVO getDetail(QnaVO qnaVO)throws Exception;
	
	public int addQna(QnaVO qnaVO)throws Exception;
	
	public int addQnaFile(QnaFileVO qnaFileVO)throws Exception;

}
