package kr.co.service;

import kr.co.vo.StudyMemberVO;
import kr.co.vo.StudyVO;

public interface StudyService {	

	// 스터디 개설, 스터디장 멤버 추가
	public void create(StudyVO studyVO, StudyMemberVO vo) throws Exception;	


}
