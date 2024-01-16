package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller //경로니까
public class EmpController {
	
	@Autowired //기능 연결
	EmpService empService;
	
// 이렇게 기능 추가도 가능! 	
//	@Autowired 
//	DeptService deptService; 
	
	
	//page 요구함! 
	
// GET : data 조회, 빈 페이지(입력폼) 호출.
// POST : body 요청! client가 데이터 보내줘야 함. -> 데이터조작관련(등록, 수정, 삭제), 보안상 
	
	//전체조회 
	@GetMapping("empList")
	public String getEmpList(Model model) {
		List<EmpVO> list = empService.getEmpAll();
		model.addAttribute("empList", list);
		
		return "emp/empList"; //page에 대한 정보 - (servlet-context.xml 참고)
	}
	
	
	//사원조회
	@GetMapping("empInfo")
	public String getEmpInfo(EmpVO empVO, Model model) {
		EmpVO findVO = empService.getEmpInfo(empVO);
		model.addAttribute("empInfo", findVO);
		
		return "emp/empInfo";
	}
	
	
	//기능에 따라서 get, post 달라지지만 경로는 same! 
	//사원등록 : FORM(빈페이지 호출)
	@GetMapping("empInsert")
	public String insertEmpInfoForm() {
		return "emp/empInsert";
	}
	
	
	//사원등록 : PROCESS
	//data 반환할필요는 없으니까 model 필요x
	@PostMapping("empInsert")
	public String insertEmpInfoProcess(EmpVO empVO) {
		int empId = empService.insertEmpInfo(empVO);
		
		String path = null;
		if(empId > -1) {
			path = "redirect:empInfo?employeeId="+empId; //redirect :새로운 경로 호출. Get방식으로 넘기기! 
		}else {
			path = "redirect:empList";
		}
		return path;
	}
	
	//사원수정 : PROCESS -  페이지전환x -> "Ajax" 로! : @ResponseBody (fetch로!)
	//1번. QueryString - 커맨드 객체
	@PostMapping("empUpdate")
	@ResponseBody
	public Map<String, Object> empUpdateProcess(EmpVO empVO){
		return empService.updateEmpInfo(empVO);
	}
	
	//2번. Json - @RequestBody
	@PostMapping("empUpdateAjax")
	@ResponseBody
	public Map<String, Object> empUpdateAjaxProcess(@RequestBody EmpVO empVO){
		return empService.updateEmpInfo(empVO);
	}
	
	
	//사원삭제 : PROCESS
	
	
	
}
