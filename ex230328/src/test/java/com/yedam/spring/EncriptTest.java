package com.yedam.spring;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptTest {
	//BCryptPasswordEncoder : 기존 비밀번호를 암호화시키는 것
	
	@Test
	public void test() {
		BCryptPasswordEncoder scpwd = new BCryptPasswordEncoder();
		String password = scpwd.encode("1111");
		System.out.println(password);
	}
}
