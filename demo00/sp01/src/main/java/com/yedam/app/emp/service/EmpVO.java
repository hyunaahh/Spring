package com.yedam.app.emp.service;

import java.util.Date;
import lombok.Data;

@Data
public class EmpVO {
	
	//camelcase 설정했으니까 언더바 안쓴거임(mybatis-config 참고)
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;
	private Date birthday;
	
	

}
