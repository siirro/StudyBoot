package com.iu.home.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	
	public Integer getIdCheck(MemberVO memberVO)throws Exception;
	
	public MemberVO getLogin(MemberVO memberVO)throws Exception;
	
	public int setJoin(MemberVO memberVO)throws Exception;
	
	public int setJoin2(MemberVO memberVO)throws Exception;
}
