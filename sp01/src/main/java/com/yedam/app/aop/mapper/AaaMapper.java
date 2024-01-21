package com.yedam.app.aop.mapper;

import org.apache.ibatis.annotations.Insert;

public interface AaaMapper {

	//xml 사용안하고 간단하게 쓸 때 
	@Insert("INSERT INTO aaa VALUES (#{num})")
	public void insertAaa(String num);
	
}
