package com.yedam.spring.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.spring.board.service.BoardService;
import com.yedam.spring.board.service.BoardVO;

@Controller
public class BoardController {
	@Autowired
	BoardService service;
	
	//전체조회 : URI - getBoardList, return board/boardList
	//HttpRequset도 사용 가능하다.
	@GetMapping("/getBoardList")
	public String getBoardList(Model model) {
		model.addAttribute("boardList", service.getBoardList());
		return "board/boardList";
	}
	
	//단건조회 : URI - getBoardInfo, return - board/boardInfo
	@GetMapping("/getBoardInfo")
	public String getBoardInfo(BoardVO vo,Model model) {
		model.addAttribute("boardInfo", service.getBoardInfo(vo));
		return "board/boardInfo";
	}
	
	//등록 - 페이지 : URI - boardInsert, return - board/boardInsert
	@GetMapping("/boardInsert")
	public String boardInsertPage(Model model) {
		// 단순히 페이지만 만들면 안된다.
		// 타입 자체는 VO클래스로 넘어간다
		model.addAttribute("boardInfo", service.getBoardNo());
		//model.addAttribute("bno", service.getBoardInfo().getBno());
		return "board/boardInsert";
	}
	
	//등록 - 처리 : URI - boardInsert, return - 전체조회 다시 호출
	@PostMapping("/boardInsert")
	public String poardInsertProsess(BoardVO vo) {
		service.insertBoardInfo(vo);
		// 게시글 등록 후 전체 게시글로 이동, 경로를 호출하는 것
		return "redirect:getBoardList";
	}
	
	//수정 - 페이지 : URI - boardUpdate, return - board/boardUpdate
	//단건조회 해당건에 대해 이미 출력된 페이지에서 수정버튼을 누르는게 많다
	//뷰자체에서 값을 가지고 있으며, 전체 들고가서 컨트롤러에 전달할 것인지
	//                      어차피 서버족에서 디비와 연결되니까 식별할 수 있는 키를 넘겨서 수정할건지 결정해야한다
	//**식별할 수 있는 값을 넘겨 서버에서 한번 조회하는 것을 권장한다
	//Get방식은 보안이 취약하다, 경우에 따라 Post
	@GetMapping("/boardUpdate")
	public String boardUpdatePage(BoardVO vo, Model model) {
		model.addAttribute("boardInfo", service.getBoardInfo(vo));
		return "board/boardUpdate";
	}
	
	//수정 - 처리 : URI - boardUpdate, return - 단건조회 다시 호출 
	@PostMapping("/boardUpdate")
	public String boardUpdateProsess(BoardVO vo) {
		service.updateBoardInfo(vo);
		//새로운 경로를 요청하는 것
		return "redirect:getBoardInfo?bno=" + vo.getBno();
	}
	
	//삭제 : URI - boardDelete, return - 전체조회 다시 호출
	@GetMapping("/boardDelete")
	public String boardDelete(@RequestParam int bno) {
		// 게시글 번호만 받아서 삭제를 진행하면 됨
		service.deleteBoardInfo(bno);
		return "redirect:getBoardList";
	}
}
