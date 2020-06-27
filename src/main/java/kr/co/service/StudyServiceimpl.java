package kr.co.service;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dao.StudyDAO;
import kr.co.vo.StudyMemberVO;
import kr.co.vo.StudyVO;

@Service
public class StudyServiceimpl implements StudyService{

	@Inject
	private StudyDAO dao;	
	
	protected StudyMemberVO vo;

	
	// 스터디 개설
	@Override
	public void create(StudyVO studyVO, StudyMemberVO vo) throws Exception {
		//스터디 코드 난수로
		StringBuffer temp = new StringBuffer();
        Random rnd = new Random();
        for (int i = 0; i < 6; i++) {
            int rIndex = rnd.nextInt(3);
            switch (rIndex) {
            case 0:
                // a-z
                temp.append((char) ((int) (rnd.nextInt(26)) + 97));
                break;
            case 1:
                // A-Z
                temp.append((char) ((int) (rnd.nextInt(26)) + 65));
                break;
            case 2:
                // 0-9
                temp.append((rnd.nextInt(10)));
                break;
            }
        }
        
        String result = temp.toString();
		
		studyVO.setSno(result);
		dao.create(studyVO);
		
		vo.setSno(result);
		vo.setId(studyVO.getId());
		vo.setName(studyVO.getMname());				
		dao.insert(vo);
	}

	// 스터디 목록 조회
	@Override
	public List<StudyVO> list() throws Exception {		
		return dao.list();
	}
	


}
