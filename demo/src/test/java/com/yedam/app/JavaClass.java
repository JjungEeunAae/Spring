package com.yedam.app;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.yedam.app.java.TV;
import com.yedam.app.java.SamsungTV;

public class JavaClass {
	
	@Test
	public void method() {
		System.out.println("테스트 테스트 테스트");
	}
	@Test
	public void javaTest() {
		TV tv = new SamsungTV();
		assertNotNull(tv);
	}
}
