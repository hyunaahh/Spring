package com.example.demo.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UserDetailVO implements UserDetails{
	
	private MemberVO memberVO;
	
//	public void setMemberVO(MemberVO memberVO) {
//		this.memberVO = memberVO;
//	}
	
	//생성자 만들고
	public UserDetailVO() {}
	
	public UserDetailVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	//**위에 final MemberVO memberVO; 하면 생성자 만들어줌. 롬복에서! 
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> list = new ArrayList<>(); //한 유저가 여러개 가질 수 있으니까 배열로쓴거
		list.add(new SimpleGrantedAuthority(memberVO.getResponsibility()));
		return list;
	}

	@Override
	public String getPassword() {		
		return memberVO.getPass();
	}

	@Override
	public String getUsername() {		
		return memberVO.getMid();
	}

	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
	
}
