package com.yedam.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.spring.board.mapper.BoardMapper;
import com.yedam.spring.board.service.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations="file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class BoardMapperClient {
	@Autowired
	BoardMapper bMapper;
	
	@Test
	public void selectAllBoard() {
		//전체조회
		List<BoardVO> list = bMapper.selectBoardList();
		assertNotNull(list);
		
	}
	
	@Test
	public void selectOneBoard() {
		//단건조회
		BoardVO vo = new BoardVO();
		
		vo.setWriter("작성자1");
		vo.setBno(1);
		
		BoardVO findVO = bMapper.selectBoardInfo(vo);
		assertNotNull(findVO.getTitle(), "제목1");
	}
	
	@Test
	public void getBoardNo() {
		//입력될 게시글 번호 조회
		BoardVO findVO = bMapper.getBoardNo();
		assertNotNull(findVO);
	}
	
	@Test
	public void insertBoard() {
		//등록
		BoardVO vo = new BoardVO();
		
		vo.setBno(4);
		vo.setTitle("제목등록");
		vo.setContents("내용등록");
		vo.setWriter("작성자등록");
		
		bMapper.insertBoard(vo);
		assertNotEquals(vo.getBno(), 0);
	}
	
	@Test
	public void updateBoard() {
		//수정
		BoardVO vo = new BoardVO();
		vo.setBno(4);
		
		BoardVO findVO = bMapper.selectBoardInfo(vo);
		System.out.println(findVO);
		
		vo.setTitle("제목수정");
		vo.setContents("내용수정");
		
		int result = bMapper.updateBoard(vo);
		assertEquals(result, 1);
	}
	
	@Test
	public void deleteBoard() {
		int result = bMapper.deleteBoard(4);
		assertEquals(result, 1);
	}
}
