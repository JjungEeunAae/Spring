package com.yedam.spring.emp.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.spring.emp.service.EmpService;
import com.yedam.spring.emp.service.EmpVO;

// 똑같은 경로라 하더라도 방식이 다르면 다르게 인식한다
// 방식 : POST , GET
@Controller
public class EmpController {
	@Autowired
	EmpService empService;
	
	// 통상적으로 이용하는 방식으로 규칙을 정한다
	// 조회(데이터,일반페이지) : GET방식 진행
	// 등록, 수정, 삭제 : POST방식 진행
	
	// 전체조회
	@GetMapping("/empList")
	//요청할 때 같이 딸려오는 데이터는 없다
	//커멘드 객체도 관련된 리퀘스트 어노테이션 안써도 됨, 단지 모델만 사용
	//모델에 담아서 페이지에 전달해줘야하기 때문에
	public String getEmpAllList(Model model) {
		model.addAttribute("empList", empService.getEmpAll());
		
		//views 밑에 찾아갈 경로를 적어주면 됨
		return "emp/empList";
	}
	
	//단건조회
	@GetMapping("/empInfo")
	//데이터를 받는 클래스가 필요하다
	//커멘드 객체를 활용하여 데이터를 받아옴
	public String getEmpInfo(EmpVO empVO, Model model) {
		model.addAttribute("empInfo", empService.getEmp(empVO));
		return "emp/empInfo";
	}
	
	
	//등록 - Form
	@GetMapping("/empInsert")
	public String empInsertForm() {
		return "emp/empInsert";
	}
	
	
	//등록 - Process
	@PostMapping("/empInsert")
	public String empInsertProsess(EmpVO empVO, RedirectAttributes rrtt) {
		//데이터를 받아서 그 결과를 전달할 것
		
		//정상적으로 데이터를 받아왔다면 변수에 담긴다
		int empId = empService.insertEmp(empVO);
		String result = null;
		if(empId == -1) {
			result = "정상적으로 등록되지 않았습니다.";
		} else {
			result = "정상적으로 등록되었습니다."
					 +"\n 등록된 사원의 사번은 "
					 + empId + "입니다.";
		}
		
		
		rrtt.addFlashAttribute("result", result);
		
		//등록되면 전체목록으로 간다
		//model에 empList에 뿌려줄 데이터가 없다
		//페이지 요청이 아닌 컨트롤러를 요청해야한다
		//전체목록 컨트롤러 정보를 받고 화면에 뿌린다
		//model로 받아오면 데이터가 손상될 수 있기 때문에
		//model이 아닌 리다이렉트를하는 어트리부트를 쓰면 됨
		//RedirectAttributes
		
		return "redirect:empList";
	}
	
	//수정 - Process, JSON방식(비동기식)
	//	* Client에서는 JSON을 Server로 준다
	//	* Server에서는 text로 Client로 준다
	@PostMapping("/empUpdate")
	@ResponseBody
	public Map<String, String> empUpdateProcess(@RequestBody EmpVO empVO) {
		return empService.updateEmp(empVO);
	}
	
	
	
	
	
	
}
