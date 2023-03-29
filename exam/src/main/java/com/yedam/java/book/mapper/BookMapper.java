package com.yedam.java.book.mapper;

import java.util.List;

import com.yedam.java.book.service.BookVO;

public interface BookMapper {
	//전체조회
	public List<BookVO> bookAllList();
	
	//등록하고자 하는 도서번호
	public BookVO getBookNo();
	//도서등록
	public int bookInsert(BookVO bookVO);
	
	//도서별 대여매출현황
	public List<BookVO> bookRentList();
	
}
