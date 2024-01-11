package com.example.boot.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.boot.emp.mapper.EmpMapper;

@Controller
public class EmpController {
	@Autowired
	EmpMapper mapper;
	
	//사원 전체조회
	@GetMapping("empList")
	public String empList(Model model) {
		model.addAttribute("empList", mapper.selectEmpAllList());
		return "empList";
	}
}
