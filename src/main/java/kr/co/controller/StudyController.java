package kr.co.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.service.StudyService;
import kr.co.vo.MemberVO;
import kr.co.vo.StudyMemberVO;
import kr.co.vo.StudyVO;

@Controller
@RequestMapping("/study/*")
public class StudyController {

	private static final Logger logger = LoggerFactory.getLogger(StudyController.class);

	@Inject
	StudyService service;		
	
	@RequestMapping(value = "/createView", method = RequestMethod.GET)
	public void createView() throws Exception {
		logger.info("createView");
	}

	//스터디 개설
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(StudyVO studyVO, StudyMemberVO vo) throws Exception {
		logger.info("create");
		System.out.println(studyVO.toString());
		
		service.create(studyVO, vo);
		System.out.println(vo.toString());
		
		return "home";
	}
	
	//스터디 목록 (+페이징처리)
	@RequestMapping(value = "/list")
	public String list(Model model) throws Exception{
		List<StudyVO> list = service.list();
		model.addAttribute("list", list);
		return "study/studyView";
	}
	
	//스터디 가입페이지
	@RequestMapping(value = "/joinView", method = RequestMethod.GET)
	public String joinView(String sno, Model model) throws Exception {
		model.addAttribute("sno", sno);
		
		return "study/joinView"; 
	}	
	
	//스터디멤버 아이디 중복확인
	@ResponseBody
	@RequestMapping(value = "/idChk", method = RequestMethod.POST)
	public int idChk(StudyMemberVO vo) throws Exception {
		int result = service.idChk(vo);
		return result;		
	}
	
	//스터디 가입 	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(HttpSession session, String userSno, String sno, Model model) throws Exception {
		logger.info("join");
		System.out.println(userSno + " " +sno);		
		
		//세션으로 회원 정보를 갖고옴
		MemberVO user = (MemberVO) session.getAttribute("member");
		//모델에 sno값을 저장해줌
		model.addAttribute("sno", sno);
			
		String msg1 = "스터디에 가입되었습니다.";
		String msg2 = "스터디 가입에 실패했습니다.";
		StudyMemberVO vo = new StudyMemberVO();
		vo.setId(user.getUserId());
		vo.setName(user.getUserName());
		vo.setSno(userSno);
		int result = service.idChk(vo);
		
		if(userSno.equals(sno) && (result == 0)) {			
			service.join(vo);			
			model.addAttribute("msg1", msg1);			
			return "home";
			
		}else {			
			model.addAttribute("msg2", msg2);			
			//return으로 넘어가면 모델에 저장된 sno가 같이 넘어감
			return "home";
		}
				
	}
	
	//나의 스터디 조회
	@RequestMapping(value = "/myStudy")
	public String myStudy(HttpSession session, StudyVO svo, StudyMemberVO vo, Model model) throws Exception{		
		
		if(session.getAttribute("member") == null)
			return "home";
		else {
			MemberVO membervo = (MemberVO) session.getAttribute("member");
			String id = membervo.getUserId();
		//서비스가 dao랑 연결되어있으니, DB에 매핑이 됨		
				
			List<Map<String,Object>> myStudy = service.myStudy(id);		
			
			logger.info(myStudy.toString());
			
			model.addAttribute("myStudy", myStudy);
		}
			
			
		
		
		return "study/myStudy";
	}
	
	//스터디원 조회	(StudyMember 테이블 데이터 뿌리기 + 페이징 처리)
	
	//스터디 그룹 해체(스터디장만 가능) (
	
	//스터디원 추방(스터디장만 가능)
	
	//스터디그룹 탈퇴
	
	//포인트 부여(스터디장만 가능)
	
	//포인트 조회	
	
	
}
