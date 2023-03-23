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

import com.yedam.spring.emp.mapper.EmpMapper;
import com.yedam.spring.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations="file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class EmpMapperClient {
	@Autowired
	EmpMapper empMapper;
	
	@Test
	public void selectAllEmp() {
		//전체조회
		List<EmpVO> emplist = empMapper.selectEmpAllList();	
		assertNotNull(emplist);
	}
	
	@Test
	public void selectEmpInfo() {
		//단건조회
		EmpVO vo = new EmpVO();
		vo.setEmployeeId(100);
		
		EmpVO findVO = empMapper.selectEmpInfo(vo);
		assertEquals(findVO.getLastName(), "King");
	}

	@Test
	public void insertEmpInfo() {
		//등록
		EmpVO vo = new EmpVO();
		vo.setLastName("Kang");
		vo.setFirstName("San-Ha");
		vo.setEmail("shKang@google.com");
		vo.setJobId("IT_PROG");
		vo.setSalary(5000);
		
		empMapper.insertEmpInfo(vo);
		assertNotEquals(vo.getEmployeeId(), 0);
	}
	
	@Test
	public void updateEmpSal() {
		//급여 갱신
		int result = empMapper.updateEmpSal(1001, 10);
		assertEquals(result, 1);
	}
	
	@Test
	public void updateEmpInfo() {
		//사원 정보 수정
		EmpVO vo = new EmpVO();
		vo.setEmployeeId(1000);
		
		EmpVO findVO = empMapper.selectEmpInfo(vo);
		System.out.println(findVO);
		
		vo.setEmail("sanH@naver.com");
		vo.setSalary(6200);
		
		int result = empMapper.updateEmpInfo(vo);
		assertEquals(result, 1);
	}
	
	@Test
	public void deleteEmpInfo() {
		//삭제
		int result = empMapper.deleteEmpInfo(1001);
		assertEquals(result, 1);
	}
	
}
