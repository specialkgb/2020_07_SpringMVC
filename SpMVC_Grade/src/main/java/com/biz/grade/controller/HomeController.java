package com.biz.grade.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.grade.model.GradeVO;
import com.biz.grade.service.GradeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@Autowired
	@Qualifier("gradeServiceV1")
	private GradeService gradeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		List<GradeVO> gradeList = gradeService.selectAll();

		model.addAttribute("GRADE_LIST", gradeList);

		return "home";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(Model model) {

		return "grade-write";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(@ModelAttribute GradeVO gradeVO, Model model) {
		log.debug("GRADEVO {}", gradeVO.toString());
		Calc(gradeVO);
		int ret = gradeService.insert(gradeVO);

		if (ret > 0) {
			log.debug("INSERT {} 개 성공", ret);
		}
		model.addAttribute("GRADE", gradeVO);

		return "redirect:/";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String seq, Model model) {

		Long long_seq = Long.valueOf(seq);
		GradeVO gradeVO = gradeService.findBySeq(long_seq);
		model.addAttribute("GRADE", gradeVO);
		return "grade-write";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(GradeVO gradeVO) {
		Calc(gradeVO);
		log.debug("UPDATE 요청데이터 {}", gradeVO.toString());

		int ret = gradeService.update(gradeVO);
		if (ret > 0) {
			log.debug("업데이트된 데이터 개수 {}", ret);
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String seq) {

		Long long_seq = Long.valueOf(seq);
		GradeVO gradeVO = gradeService.findBySeq(long_seq);

		int ret = gradeService.delete(long_seq);
		if (ret > 0) {
			log.debug("삭제된 데이터 개수 {}", ret);
		}
		return "redirect:/";
	}

	public List<GradeVO> Calc(GradeVO gradeVO) {

		List<GradeVO> gradeList = new ArrayList<GradeVO>();

		gradeVO.setG_total(gradeVO.getG_kor() + gradeVO.getG_eng() + gradeVO.getG_math());
		gradeVO.setG_avg(gradeVO.getG_total() / 3);

		gradeList.add(gradeVO);

		return gradeList;

	}

}
