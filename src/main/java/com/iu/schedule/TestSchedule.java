package com.iu.schedule;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.iu.home.member.MemberMapper;
import com.iu.home.member.MemberVO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class TestSchedule {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Scheduled(cron = "* * * * * *")
	public void cron()throws Exception {
		log.info("Cron 매초 실행");
		log.info(Calendar.getInstance().getTime().toString());
		MemberVO memberVO = new MemberVO();
		memberVO.setId("AutoId"+Calendar.getInstance().getTimeInMillis());
		memberVO.setPw("1234");
		memberVO.setName("name");
		memberVO.setEmail("email");
		
		log.info("Result {}", memberMapper.setJoin(memberVO));
	}
	
	@Scheduled(fixedRate = 3000, initialDelayString = "1000")
	public void ts1() {
		log.info("Schedule 실행");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
