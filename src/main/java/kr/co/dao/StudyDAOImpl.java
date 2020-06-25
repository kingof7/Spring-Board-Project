package kr.co.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.vo.StudyMemberVO;
import kr.co.vo.StudyVO;

@Repository
public class StudyDAOImpl implements StudyDAO{

	@Inject
	private SqlSession sqlSession;
	
	//스터디 개설
	@Override
	public void create(StudyVO studyVO) throws Exception {
		sqlSession.insert("studyMapper.create", studyVO);
		
	}

	//스터디장 추가
	@Override
	public void insert(StudyMemberVO vo) throws Exception {
		sqlSession.insert("studyMapper.master", vo);
		
	}
}