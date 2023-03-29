package com.yedam.java.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Controller
public class BookController {
	@Autowired
	BookService service;
	
	@GetMapping("bookAllList")
	public String bookAllList(Model model) {
		model.addAttribute("bookAllList", service.bookAllList());
		return "book/bookAllList";
	}
	
	@GetMapping("bookInsert")
	public String bookInsertForm(Model model) {
		model.addAttribute("bookInfo", service.getBookNo());
		return "book/bookInsert";
	}
	
	@PostMapping("bookInsert")
	public String bookInsertProcess(BookVO vo) {
		service.bookInsert(vo);
		return "redirect:bookAllList";
	}
	
	@GetMapping("rentSelect")
	public String bookRentList(Model model) {
		model.addAttribute("bookRentList", service.bookRentList());
		return "book/rentSelect";
	}
	
	@GetMapping("index")
	public String indexPage() {
		return "book/index";
	}
}
