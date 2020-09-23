package com.biz.read.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.read.model.BookVO;
import com.biz.read.service.NaverService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/api")
public class BookApiController {

	@Autowired
	@Qualifier(value = "naverServiceV2")
	private NaverService<BookVO> nService;

	@RequestMapping(value = "/isbn", method = RequestMethod.POST,
			produces = "application/json;charset=utf8")
	public BookVO naverSearch(String search_text) {

		String queryURL = nService.queryURL("BOOK", search_text);
		/*
		 * getNaverList(query) Method는 도서명, ISBN으로 조회를 하여
		 * 도서 리스트를 return해주는 method이다.
		 * 도서명으로 검색을 하면 당연히 1개 이상의 데이터가 return되어
		 * List형이 될 것이다.
		 * 만약 ISBN으로 검색을 하면 ISBN은 중복값이 없으므로
		 * 당연히 1개만 return이 될 것이다.
		 * 하지만 이 method는 태생이 List를 return하도록 만들어져 있기 때문에
		 * 1개의 데이터라도 List<BookVO>에 담겨서 return이 된다.
		 * ISBN으로 조회를 했을 때는 다른 데이터는 있더라도 무시하고
		 * 첫번째(0번) 데이터만 필요하므로 ...get(0)으로 첫번째 데이터만 추출한다.
		 */
		BookVO bookVO = nService.getNaverList(queryURL).get(0);
		log.debug("도서정보 :" + bookVO.toString());
		return bookVO;

	}
}
