package kr.co.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.service.StudyService;
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
	
	//스터디 목록
	@RequestMapping(value = "/list")
	public String list(Model model) throws Exception{
		List<StudyVO> list = service.list();
		model.addAttribute("list", list);
		return "study/studyView";
	}
	

}
