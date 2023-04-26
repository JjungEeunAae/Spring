package com.example.boot.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.boot.member.MemberVO;
import com.example.boot.member.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService, UserDetailsService {
	@Autowired
	MemberMapper mapper;
	
	@Override
	public MemberVO getMember(String id) {
		return mapper.getMember(id);
	}

	//로그인체크
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO vo = mapper.getMember(username);
		
		if(vo == null) {
			throw new UsernameNotFoundException("no userid");
		}
		
		return vo;
	}
	
	//패스워드암호화

}
