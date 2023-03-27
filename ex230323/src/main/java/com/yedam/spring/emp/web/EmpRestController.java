package com.yedam.spring.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.spring.emp.service.EmpService;
import com.yedam.spring.emp.service.EmpVO;

@CrossOrigin
@RestController
public class EmpRestController {
	@Autowired
	EmpService empService;
	
	
	//전체조회
	@GetMapping("/emps")
	public List<EmpVO> getEmpList(Model model){
		return empService.getEmpAll();
	}
	
	//단건조회
	//경로에 조회하고자 하는 대상을 지정
	@GetMapping("/emps/{employeeId}")
	public EmpVO getEmpInfo(@PathVariable int employeeId) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(employeeId);
		
		return empService.getEmp(empVO);
	}
	
	//등록
	//반환되는 데이터는 성공여부를 알려주ㅓ도 되지만 등록하는 데이터를 그대로 반환하는 방법도 있음
	@PostMapping("/emps")
	public EmpVO insertEmpInfo(@RequestBody EmpVO empVO) {
		empService.insertEmp(empVO);
		return empVO;
	}
	
	//수정
	//수정하고자 하는 내용은 바디에서 데려옴
	//다른 방법 : 바디에 내가 수정하고자 하는 대상과 정보 전부 다 넣는 경우도 있음
	@PutMapping("/emps/{employeeId}")
	public EmpVO updateEmpInfo(@PathVariable int employeeId, @RequestBody EmpVO empVO) {
		empVO.setEmployeeId(employeeId);
		empService.updateEmp(empVO);
		return empVO;
	}
	
	//삭제
	@DeleteMapping("/emps/{employeeId}")
	public EmpVO deleteEmpInfo(@PathVariable int employeeId) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(employeeId);
		empService.deleteEmp(employeeId);
		return empVO;
	}
}
