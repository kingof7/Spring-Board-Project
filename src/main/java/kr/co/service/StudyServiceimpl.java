package kr.co.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.dao.StudyDAO;
import kr.co.vo.StudyVO;

@Service
public class StudyServiceimpl implements StudyService{

	@Inject
	private StudyDAO dao;
	
	
	// 스터디 개설
	@Override
	public void create(StudyVO studyVO) throws Exception {
		dao.create(studyVO);
		
	}


}
