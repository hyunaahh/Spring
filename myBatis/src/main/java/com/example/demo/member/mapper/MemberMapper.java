package com.example.demo.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.member.MemberVO;

@Mapper
public interface MemberMapper {

	public MemberVO getMember(String id); 
	

}
