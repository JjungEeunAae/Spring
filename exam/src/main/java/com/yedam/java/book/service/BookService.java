package com.yedam.java.book.service;

import java.util.List;

public interface BookService {
	//전체조회
	public List<BookVO> bookAllList();
	
	//등록하고자 하는 도서번호
	public BookVO getBookNo();
	
	//도서등록
	public int bookInsert(BookVO bookVO);
	
	public List<BookVO> bookRentList();
}
