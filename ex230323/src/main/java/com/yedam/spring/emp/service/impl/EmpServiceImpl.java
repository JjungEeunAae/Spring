package com.yedam.spring.emp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.spring.emp.mapper.EmpMapper;
import com.yedam.spring.emp.service.EmpService;
import com.yedam.spring.emp.service.EmpVO;
//@Service(value = )
//중복될 경우 이름을 부여할 수 있음
//해당 이름은 변수명으로 사용된다
@Service
public class EmpServiceImpl implements EmpService {
	
	//Mapper는 한개 이상 등록이 가능하다, 각각 Autowired 어노테이션을 등록해주어야한다
	@Autowired
	EmpMapper empMapper;
	
	@Override
	public List<EmpVO> getEmpAll() {
		return empMapper.selectEmpAllList();
	}

	@Override
	public EmpVO getEmp(EmpVO empVO) {
		return empMapper.selectEmpInfo(empVO);
	}

	@Override
	public int insertEmp(EmpVO empVO) {
		int result =  empMapper.insertEmpInfo(empVO);
		if(result == 1) {
			return empVO.getEmployeeId();
		} else {
			return -1;
		}
	}

	@Override
	public String updateEmpSal(int empId, int raise) {
		String message = null;
		
		int result = empMapper.updateEmpSal(empId, raise);
		if(result == 1) {
			message = "정상적으로 급여를 갱신하였습니다";
		} else {
			message = "작업이 실패하였습니다. 사원번호를 확인하세요";
		}
		
		return message;
	}

	@Override
	public Map<String, String> updateEmp(EmpVO empVO) {
		Map<String, String> map = new HashMap<>();
		map.put("사원번호", String.valueOf(empVO.getEmployeeId()));
		
		int result = empMapper.updateEmpInfo(empVO);
		
		if(result == 1) {
			map.put("결과", "Success");
		} else {
			map.put("결과", "Fail");
		}
		
		return map;
	}

	@Override
	public Map<String, String> deleteEmp(int empId) {
		Map<String, String> map = new HashMap<>();
		map.put("사원번호", String.valueOf(empId));
		
		int result = empMapper.deleteEmpInfo(empId);
		
		if(result == 1) {
			map.put("결과", "Success");
		} else {
			map.put("결과", "Fail");
		}
		
		return map;
	}

}
