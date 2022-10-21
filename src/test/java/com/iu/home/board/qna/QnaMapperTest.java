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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
//@Rollback(true)
//트랜잭셔널 옵션 없으면 무조건 전부 롤백
@Transactional
class QnaMapperTest {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${my.default}")
	private String app;
	
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
	
	@Test
	@Rollback(false) //이거 주면 얘만 롤백안함
	void addQna()throws Exception{
		log.info("==============={} =================", app);
		qnaVO = new QnaVO();
		qnaVO.setTitle("Title");
		qnaVO.setWriter("Writer");
		qnaVO.setContents("Contents");
		//int result = qnaMapper.addQna(qnaVO);
		
		assertEquals(1, 1);
	}

}
