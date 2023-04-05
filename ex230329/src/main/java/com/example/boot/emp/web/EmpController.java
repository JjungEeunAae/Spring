package com.example.boot.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.boot.emp.service.EmpService;
import com.example.boot.emp.service.EmpVO;

@Controller
public class EmpController {
	@Autowired
	EmpService service;
	
	@RequestMapping(value="empList", method=RequestMethod.GET)
	public String empAllList(Model model) {
		model.addAttribute("empList", service.getEmpList());
		return "empList";
	}
	
	@GetMapping("empInfo")
	public String empInfo(EmpVO empVO, Model model) {
		model.addAttribute("empInfo", service.getEmpInfo(empVO));
		return "empInfo";
	}
	
	//등록페이지
	@GetMapping("empInsert")
	public String empInsertForm(Model model) {
		model.addAttribute("empVO", new EmpVO());
		return "empInsert";
	}
	//등록처리
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO) {
		service.insertEmpInfo(empVO);
		return "redirect:empList";
	}
}
