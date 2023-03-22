package com.yedam.app.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//컨테이너를 만드는 클래스
		GenericXmlApplicationContext ctx
			//                                   xml에 등록되어있는 Bean을 가져온다
			= new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		//아이디값을 넘겨주면 가지고 온다
		//오브젝트로 리턴된다
		TV tv = (TV)ctx.getBean("tv");
		tv.on();
	}
}
