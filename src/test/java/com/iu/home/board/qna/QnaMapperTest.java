package com.iu.home.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QnaMapperTest {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private QnaMapper qnaMapper;
	
	private QnaVO qnaVO;
	
//	@BeforeAll
//	static void befoAll() {
//		System.out.println(" 전체 Test 실행 전 !!!!");
//	}
//	
//	@AfterAll
//	static void afterAll() {
//		System.out.println(" 전체 Test 실행 후 !!!!");
//	}
//	
//	@BeforeEach
//	void beforeEach() {
//		System.out.println("Test 메서드 실행 전");
//		qnaVO = new QnaVO();
//		qnaVO.setNum(1L);
//		qnaVO.setContents("contents");
//	}
//	
//	@AfterEach
//	void afterEach() {
//		System.out.println("Test 메서드 실행 후");
//	}
//	
//	@Test
//	void test2() {
//		log.info("Test2 Case");
//	}
//
//	@Test
//	void test()throws Exception {
//		List<QnaVO> ar = qnaMapper.getList();
//		log.info("Lddist : {} ", ar);
//		assertNotEquals(0, ar.size());
//	}
//	
//	@Test
//	void addQna()throws Exception{
//		for(int i=0;i<100;i++) {
//		qnaMapper.addQna();
//		}
//		//assertEquals(1, result);
//	}

}
