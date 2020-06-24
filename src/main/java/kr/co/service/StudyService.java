package kr.co.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.vo.BoardVO;
import kr.co.vo.StudyVO;

public interface StudyService {	

	// 스터디 개설
	public void create(StudyVO studyVO) throws Exception;

}
