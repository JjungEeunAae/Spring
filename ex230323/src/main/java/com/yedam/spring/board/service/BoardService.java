package com.yedam.spring.board.service;

import java.util.List;

public interface BoardService {
	//인터페이스는 어노테이션이 붙지 않는다
	// 보통 인터페이스에 어노테이션을 잘안씀 => 어노테이션은 빈 등록 = 인스턴스(객체)를 만듦
    // 단 예외, mapper를 스캔할때 어노테이션을 씀 => 마이바티스쪽이라고 생각하기

    // 인터페이스는 오로지 구현클래스를 통해서 인스턴스를 만들수 있기때문
	
	//전체조회
	public List<BoardVO> getBoardList();
	
	//단건조회
	public BoardVO getBoardInfo(BoardVO boardVO);
	
	//등록하고자 하는 글번호
	public BoardVO getBoardNo();
	
	
	//등록이나 수정 -> 삭제가 되지 않으면 -1 반환
	
	//등록 - 등록된 글번호 반환
	public int insertBoardInfo(BoardVO boardVO);
	
	//수정 - 수정된 글번호 반환
	public int updateBoardInfo(BoardVO boardVO);
	
	//삭제 - 삭제된 글번호 반환
	public int deleteBoardInfo(int boardNo);
}
