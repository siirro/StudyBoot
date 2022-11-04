package com.iu.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	public Integer getIdCheck(MemberVO memberVO)throws Exception{
		return memberMapper.getIdCheck(memberVO);
	}
	
	//사용자 정의 검증 메서드
	public boolean getMemberError(MemberVO memberVO, BindingResult bindingResult)throws Exception {
		boolean check = false;
		//check=false : 검증성공(error 없음)
		//check=true  : 검증실패(error 있음)
		
		//1. annotation 검증
		check = bindingResult.hasErrors();
		
		//2. password가 일치하는지 검증
		if(!memberVO.getPw().equals(memberVO.getPwCheck())) {
			check=true;
			//에러메세지
			//bindingResult.rejectValue("멤버변수명(path)", "properties의key(코드)");
			bindingResult.rejectValue("pwCheck", "member.password.notEqual");
		}
		
		//3. if가 중복 인지 검증
		if(memberMapper.getIdCheck(memberVO)>0) {
			check=true;
			bindingResult.rejectValue("id", "member.id.unique");
		}
		
		return check;
		
	}
	
	//로그인 처리는 Security에서 할거니까 기존서비스에선 주석처리
//	public MemberVO getLogin(MemberVO memberVO)throws Exception{
//		return memberMapper.getLogin(memberVO);
//	}
	
	
	public int setJoin(MemberVO memberVO)throws Exception{
		int result = memberMapper.setJoin(memberVO);
		
		if(result<1) {
			throw new Exception();
		}
		
		result = memberMapper.setJoin2(memberVO);
		
		if(result<1) {
			throw new Exception();
		}
		
		return result;
	}

}
