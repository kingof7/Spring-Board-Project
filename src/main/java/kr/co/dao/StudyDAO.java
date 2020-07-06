package kr.co.dao;

import java.util.List;
import java.util.Map;

import kr.co.vo.MemberVO;
import kr.co.vo.StudyMemberVO;
import kr.co.vo.StudyVO;

public interface StudyDAO {

	//스터디 개설
	public void create(StudyVO studyVO) throws Exception;
	
	// 스터디장 멤버로 추가
	public void insert(StudyMemberVO vo) throws Exception;
	
	// 스터디 목록 조회
	public List<StudyVO> list() throws Exception;
	
	// 스터디 가입
	public void join(MemberVO vo) throws Exception;
	
	// 스터디멤버 중복조회
	public int idChk(StudyMemberVO vo) throws Exception;
	
	// 나의 스터디 조회
	public List<Map<String,Object>> myStudy(String id) throws Exception;
	
	// 스터디 탈퇴
	public void withdraw(StudyMemberVO vo) throws Exception;
}
