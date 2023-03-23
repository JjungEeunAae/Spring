package com.yedam.spring.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.spring.emp.service.EmpVO;

public interface EmpMapper {
	//전체조회
	public List<EmpVO> selectEmpAllList();
	
	//단건조회
	public EmpVO selectEmpInfo(EmpVO empVO);
	
	//등록
	public int insertEmpInfo(EmpVO EmpVO);
	
	//수정 - 급여를 정해진 비율로 인상
	public int updateEmpSal(@Param("employeeId")int employeedId,
							@Param("raise")int raise);
							// @Param : 마이바티스 어노테이션
						    //          쿼리문에 지정해둔 이름을 적어준다
	
	//수정 - 사원 정보 수정
	public int updateEmpInfo(EmpVO EmpVO);
	
	//삭제
	public int deleteEmpInfo(int employeeId);
}
