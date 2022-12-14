package com.iu.home.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.util.FileManager;
import com.iu.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class QnaService {
	
	@Autowired
	private QnaMapper qnaMapper;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.upload.qna}")
	private String path;
	
	public int setDeleteFile(QnaFileVO qnaFileVO)throws Exception{
		qnaFileVO = qnaMapper.getFileDetail(qnaFileVO);
		int result = qnaMapper.setDeleteFile(qnaFileVO);
		
		if(result>0) {
			File file = new File(path, qnaFileVO.getFileName());
			file.delete();
		}
		
		return result;
	}
	
	public int setUpdate(QnaVO qnaVO)throws Exception{
		return qnaMapper.setUpdate(qnaVO);
	}
	
	public QnaFileVO getFileDetail(QnaFileVO qnaFileVO)throws Exception{
		return qnaMapper.getFileDetail(qnaFileVO);
	}
	
	public List<QnaVO> getList(Pager pager)throws Exception{
		pager.getPerPage();
		pager.makeRow();
		return qnaMapper.getList(pager);
	}
	
	public QnaVO getDetail(QnaVO qnaVO)throws Exception{
		return qnaMapper.getDetail(qnaVO);
	}
	
	public int addQna(QnaVO qnaVO)throws Exception{
		int result = qnaMapper.addQna(qnaVO);
		File file = new File(path);
		
		if(!file.exists()) {
			boolean check = file.mkdirs();
		}
		
		if(qnaVO.getFiles() != null) {
			for(MultipartFile f : qnaVO.getFiles()) {
				if(!f.isEmpty()) {
					log.info("FileName은 {} ",f.getOriginalFilename());
					String fileName = fileManager.saveFile(f, path);
					QnaFileVO qnaFileVO = new QnaFileVO();
					qnaFileVO.setNum(qnaVO.getNum());
					qnaFileVO.setOriName(f.getOriginalFilename());
					qnaFileVO.setFileName(fileName);
					qnaMapper.addQnaFile(qnaFileVO);
				}
			}
		}
		return result;
	}

}
