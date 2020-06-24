package kr.co.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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
}
