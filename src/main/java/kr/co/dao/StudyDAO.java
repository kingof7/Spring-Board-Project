package kr.co.dao;

import kr.co.vo.StudyVO;

public interface StudyDAO {

	//스터디 개설
	public void create(StudyVO studyVO) throws Exception;
}
