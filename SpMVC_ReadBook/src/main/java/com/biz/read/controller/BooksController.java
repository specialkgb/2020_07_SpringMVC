package com.biz.read.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.read.mapper.BookDao;
import com.biz.read.model.BookVO;

@Controller
@RequestMapping(value = "/books")
public class BooksController {
	
	@Autowired
	private BookDao bookDao;
	
	// localhost:8080/book/books/
	// localhost:8080/book/books 둘 다 가능하려면 밑에 value 값을 리스트로 해서 아래처럼 해놓자
	// @ResponseBody
	@RequestMapping(value = {"/", ""},method=RequestMethod.GET)
	public String list(Model model) {
		
		List<BookVO> bookList = bookDao.selectAll();
		model.addAttribute("BOOKS", bookList);
		
		return "books/list";
		
	}
	@RequestMapping(value = "/input", method=RequestMethod.GET)
	public String input() {
		
		return "books/write";
		
		// Controller의 Mapping method의 return type이 String일 때,
		// null 값을 return 하면
		// method를 호출할 때 사용했던 mapping URL.jsp 형식의 return 문이
		// 자동으로 생성된다.
		// return null;
		
	}
	
}