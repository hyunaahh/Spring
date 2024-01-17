package com.yedam.app.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmpVO {
	
	//camelcase 설정했으니까 언더바 안쓴거임(mybatis-config 참고)
	
	private Integer employeeId; //null 처리할 수 있도록 int->Integer로 변경
	private String firstName;
	private String lastName;
	private String email;
	//들어오는 값에 대한 format. return값이랑 상관 x
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;
	private Date birthday;
	
	

}
