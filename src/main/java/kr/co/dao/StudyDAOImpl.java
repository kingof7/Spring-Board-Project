package kr.co.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.vo.MemberVO;
import kr.co.vo.StudyMemberVO;
import kr.co.vo.StudyVO;

@Repository
public class StudyDAOImpl implements StudyDAO {

	@Inject
	private SqlSession sqlSession;

	// 스터디 개설
	@Override
	public void create(StudyVO studyVO) throws Exception {
		sqlSession.insert("studyMapper.create", studyVO);

	}

	// 스터디장 추가
	@Override
	public void insert(StudyMemberVO vo) throws Exception {
		sqlSession.insert("studyMapper.master", vo);

	}

	// 스터디 목록 조회
	@Override
	public List<StudyVO> list() throws Exception {

		return sqlSession.selectList("studyMapper.list");

	}

	// 스터디 가입
	@Override
	public void join(MemberVO vo) throws Exception {
		sqlSession.insert("studyMapper.master", vo);

	}

	// 스터디멤버 중복조회
	@Override
	public int idChk(StudyMemberVO vo) throws Exception {
		int result = sqlSession.selectOne("studyMapper.idChk", vo);
		return result;
	}
	
	// 나의 스터디 목록
	@Override
	public List<Map<String,Object>> myStudy(String id) throws Exception {
		
		return sqlSession.selectList("studyMapper.myStudy", id);
	}

	
}
