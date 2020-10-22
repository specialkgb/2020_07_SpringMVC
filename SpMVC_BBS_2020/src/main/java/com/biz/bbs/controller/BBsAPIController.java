package com.biz.bbs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.bbs.model.BBsVO;
import com.biz.bbs.service.BBsService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@CrossOrigin({"http://127.0.0.1:5500","https://naver.com","*"})
@RestController
@RequestMapping(value = "/api")
public class BBsAPIController {
	
	@Autowired
	@Qualifier("bbsServiceV1")
	private BBsService bbsService;
	
	
//	@CrossOrigin("http://127.0.0.1:5500")
	
	
	@RequestMapping(value = "/bbs", method=RequestMethod.GET)
	public List<BBsVO> bbs_list() {
		
		List<BBsVO> bbsList = bbsService.selectAll();
		
		return bbsList;
	}
	
	@RequestMapping(value = "/bbs/{seq}", method=RequestMethod.GET)
	public BBsVO bbs_item(@PathVariable("seq") String seq) {
		
		long long_seq = Long.valueOf(seq);
		BBsVO bbsVO = bbsService.findBySeq(long_seq);
		
		return bbsVO;
	}
	
	@RequestMapping(value = "/bbs", method=RequestMethod.POST)
	public String bbs_insert(@ModelAttribute BBsVO bbsVO) {
		
		log.debug("POST RequestMethod Type으로 요청된 메소드");
		log.debug("BBSVO {}", bbsVO.toString());
		
		return "bbs_insert";
	}
	
	@RequestMapping(value = "/bbs", method=RequestMethod.PUT)
	public String bbs_update(@ModelAttribute BBsVO bbsVO) {
		log.debug("PUT RequestMethod Type으로 요청된 메소드");
		log.debug("수신한 데이터 {}", bbsVO.toString());
		
		return "bbs_update";
	}
	
	@RequestMapping(value = "/bbs", method=RequestMethod.DELETE)
	public String bbs_delete(@RequestBody Map<String, String> data) {
		
		log.debug("DELETE RequestMethod Type으로 요청된 메소드");
		log.debug("시퀀스 값 {}", data.get("seq"));
		return "bbs_delete";
	}	
}