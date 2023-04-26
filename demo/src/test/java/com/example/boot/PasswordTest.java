package com.example.boot;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {
	@Test
	public void passEncrypt() {
		//패스워드를 입력할 때 마다 토큰이 다르다.
		BCryptPasswordEncoder bcr = new BCryptPasswordEncoder();
		String password = bcr.encode("1111");
		System.out.println(password);
		
		//이퀄즈로 비교할 수 없기 때문에 매치스로 진행한다.
		//bcr.matches(password, password);
	}
}
