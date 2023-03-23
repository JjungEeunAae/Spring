package com.yedam.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpController {
	@Autowired
	EmpService empService;
	
	// '/getEmpInfo'인 경로에 맵핑된 내용의 전부
	@RequestMapping("/getEmpInfo")
	@ResponseBody //페이지를 리턴하지않고 리턴되는 대상을 body에 출력한다
				  //객체를 텍스트화 시키는 것을 직렬화라고 한다.
				  //이 작업을 해주는 라이브러리가 jackson이며, datebind를 사용한 것이다
	public EmpVO getEmpInfo(EmpVO empVO) {
		return empService.getEmpInfo(empVO);
	}
}
