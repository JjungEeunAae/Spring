package com.example.boot.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class MemberVO implements UserDetails{
	String memberId;
	String memberPw;
	String memberName;
	String memberPhone;
	String memberAddr;
	String responsibility;
	String image;
	String memberRole;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<>();	
		list.add(new SimpleGrantedAuthority(memberRole));
		//권한체크
		return list;
	}
	
	//로그인체크-----------------
	@Override
	public String getPassword() {
		return memberPw;
	}
	@Override
	public String getUsername() {
		return memberId;
	}
	//-------------------------
	
	//false면 role(권한)이 작동되지 않으며, 로그인이 되지 않는다.
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
