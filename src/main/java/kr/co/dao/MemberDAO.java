package kr.co.dao;

import java.util.List;

import kr.co.vo.MemberVO;

public interface MemberDAO {
	// 회원가입
	public void register(MemberVO vo) throws Exception;
	// 로그인
	public MemberVO login(MemberVO vo) throws Exception;
	// 회원정보 수정
	public void memberUpdate(MemberVO vo) throws Exception;
	// 회원 탈퇴
	public void memberDelete(MemberVO vo)throws Exception;
	
	// 회원 조회
	public List<MemberVO> memberList() throws Exception;
	
	public int passChk(MemberVO vo) throws Exception;
	
	// 아이디 중복체크
	public int idChk(MemberVO vo) throws Exception;
}
