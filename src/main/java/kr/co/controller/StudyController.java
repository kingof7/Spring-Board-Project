package kr.co.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.service.StudyService;
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
	public String create(StudyVO studyVO) throws Exception {
		logger.info("create");
		System.out.println(studyVO.toString());
		service.create(studyVO);
		
		return "home";
	}

}
