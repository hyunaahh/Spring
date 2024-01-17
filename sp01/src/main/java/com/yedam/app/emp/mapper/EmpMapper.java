package com.yedam.app.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
// !interface 위에는 특별한 case 제외하곤 annotation 잘 안씀
//return타입 정해져있지만 service는 X
	
	//전체조회
	public List<EmpVO> selectEmpList();
	
	//단건조회
	public EmpVO selectEmpInfo(EmpVO empVO);
	
	//등록
	public int insertEmpInfo(EmpVO empVO);
	
	//수정
	public int updateEmpInfo(EmpVO empVO);
	
	//삭제
	public int deleteEmpInfo(int empId);
	
	//수정 : 변경된 데이터만 수정
	public int updateEmpInfoDynamic(EmpVO empVO);
	
	// 수정 : 매개변수가 2개 인 경우
	public int updateEmpSal(@Param("eid") int empId, 
							@Param("info") EmpVO empVO); // 객체 = 내부에 여러값 있으!
	
	
}
