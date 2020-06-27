package kr.co.dao;

import java.util.List;

import kr.co.vo.StudyMemberVO;
import kr.co.vo.StudyVO;

public interface StudyDAO {

	//스터디 개설
	public void create(StudyVO studyVO) throws Exception;
	
	// 스터디장 멤버로 추가
	public void insert(StudyMemberVO vo) throws Exception;
	
	// 스터디 목록 조회
	public List<StudyVO> list() throws Exception;
}
