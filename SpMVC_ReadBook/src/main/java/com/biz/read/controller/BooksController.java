package com.biz.read.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.read.mapper.BookDao;
import com.biz.read.model.BookVO;
import com.biz.read.model.ReadBookVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/books")
public class BooksController {

	@Autowired
	private BookDao bookDao;
	
	@Transactional
	// localhost:8080/book/books/
	// localhost:8080/book/books 둘 다 가능하려면 밑에 value 값을 리스트로 해서 아래처럼 해놓자
	// @ResponseBody
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String list(Model model) {

		List<BookVO> bookList = bookDao.selectAll();
		model.addAttribute("BOOKS", bookList);
		model.addAttribute("BODY", "BOOK-LIST");
		return "home";

	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input(Model model) {

		LocalDate localDate = LocalDate.now();
		String todayString = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDate);

		BookVO bookVO = BookVO.builder().buydate(todayString).build();

		model.addAttribute("BODY", "BOOK-WRITE");
		model.addAttribute("bookVO", bookVO);
		return "home";

		// Controller의 Mapping method의 return type이 String일 때,
		// null 값을 return 하면
		// method를 호출할 때 사용했던 mapping URL.jsp 형식의 return 문이
		// 자동으로 생성된다.
		// return null;

	}

	/*
	 * spring form taglib를 사용하여 write form을 만들었을 경우에는 VO 클래스, 객체를 매개변수로 사용할 때
	 * 
	 * @ModelAttribute("VO")를 필수로 사용하자
	 */
	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String input(@ModelAttribute("bookVO") BookVO bookVO) {
		log.debug(bookVO.toString());

		int ret = bookDao.insert(bookVO);
		if (ret < 1) {
			// insert가 실패했으므로 그에 대한 메시지를 보여주는 페이지로 점프하도록 만들어야한다.
		}

		return "redirect:/books";

	}

	@RequestMapping(value = "/detail/{book_seq}",method=RequestMethod.GET,
	         produces = "application/json;charset=utf8")
	   public String detail(@PathVariable("book_seq")
	   String id, Model model) {
	      
	      log.debug("PATH : {}",id);
	      long seq = Long.valueOf(id);
	      BookVO bookVO = bookDao.findById(seq);
//	      log.debug(bookVO.toString());
	      
	      model.addAttribute("BOOKVO", bookVO);
	      
	      
	      // 09-28 추가
	      LocalDateTime lDateTime = LocalDateTime.now();
	      String lDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(lDateTime);
	      String lTime = DateTimeFormatter.ofPattern("HH:MM:ss").format(lDateTime);
	      
	      // 09-28 추가
	      ReadBookVO readBookVO = ReadBookVO.builder()
	            .r_date(lDate)
	            .r_stime(lTime)
	            .build();
	      
	      // 09-28 추가
	      model.addAttribute("readBookVO",readBookVO);
	      
	      
	      model.addAttribute("BODY", "BOOK-DETAIL");
	      return "home";
	   }

}
