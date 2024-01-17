package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MapperTest {
	
	@Autowired
	EmpMapper empMapper;
	
	//전체조회
	//@Testㅁ
	public void selectAll() {
		List<EmpVO> list = empMapper.selectEmpList();
		assertTrue(!list.isEmpty());
	}
	
	//단건조회
	//@Test
	public void selectInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		assertEquals(findVO.getLastName(), "King");
	}
	
	//등록 - selectkey보기! 
	//@Test
	public void insertInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Hong");
		empVO.setEmail("kdong@google.com");
		empVO.setHireDate(new Date("24/01/15"));
		empVO.setJobId("IT_PROG");
		empVO.setSalary(10000);
		
		int result = empMapper.insertEmpInfo(empVO);
		assertNotEquals(empVO.getEmployeeId(), 0);
		//OR   assertNotEquals(result, 0);
	}
	
	//수정-일반적인case. select문 있음
	//@Test
	public void updateInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(1001);
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		findVO.setLastName("Kang");
		int result = empMapper.updateEmpInfo(findVO);
		assertNotEquals(result, 0);
	}
	
	//수정 - select문 없음! 특정조건 만족시킬때만 모아서 하나의 쿼리문 완성시킴! (이메일 조건 만족x 생략되었음)
	//@Test
	public void updateInfoDynamic() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(1001);
		empVO.setSalary(5200);
		int result = empMapper.updateEmpInfoDynamic(empVO);
		assertNotEquals(result, 0);
	}
	
	//삭제
	@Test
	public void deleteInfo() {
		int result = empMapper.deleteEmpInfo(1001);
		assertNotEquals(result, 0);
	}
	
}
