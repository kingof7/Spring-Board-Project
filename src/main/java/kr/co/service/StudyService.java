package kr.co.service;

import java.util.List;

import kr.co.vo.StudyMemberVO;
import kr.co.vo.StudyVO;

public interface StudyService {	

	// 스터디 개설, 스터디장 멤버 추가
	public void create(StudyVO studyVO, StudyMemberVO vo) throws Exception;
	
	// 스터디 조회
	public List<StudyVO> list() throws Exception;


}
