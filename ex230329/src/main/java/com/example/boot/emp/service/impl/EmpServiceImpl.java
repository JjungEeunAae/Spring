package com.example.boot.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boot.emp.mapper.EmpMapper;
import com.example.boot.emp.service.EmpService;
import com.example.boot.emp.service.EmpVO;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	EmpMapper emapper;
	
	@Override
	public List<EmpVO> getEmpList() {
		return emapper.selectAllEmp();
	}

	@Override
	public EmpVO getEmpInfo(EmpVO empVO) {
		return emapper.selectEmpInfo(empVO);
	}

	@Override
	public int insertEmpInfo(EmpVO empVO) {
		return emapper.insertEmpInfo(empVO);
	}

}
