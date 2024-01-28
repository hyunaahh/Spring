package com.example.demo.emp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.emp.mapper.EmpMapper;


@SpringBootTest
class EmpMapperTest {
	
	@Autowired 
	EmpMapper empMapper;
	
	@Test
	public void list() { 
		List<EmpVO> list = empMapper.getEmpList(null);
		assertThat(list.isEmpty()).isEqualTo(false); 
		}
}
