package com.yedam.java.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.book.mapper.BookMapper;
import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookMapper bmapper;
	
	@Override
	public BookVO getBookNo() {
		return bmapper.getBookNo();
	}

	@Override
	public int bookInsert(BookVO bookVO) {
		int result = bmapper.bookInsert(bookVO);
		if(result==1) {
			return bookVO.getBookNo();
		} else {
			return -1;
		}
	}

	@Override
	public List<BookVO> bookAllList() {
		return bmapper.bookAllList();
	}

	@Override
	public List<BookVO> bookRentList() {
		return bmapper.bookRentList();
	}

}
