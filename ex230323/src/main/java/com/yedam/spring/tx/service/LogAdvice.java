package com.yedam.spring.tx.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect		//스프링프레임워크가 아닌 다른 곳
@Component // 스프링프레임워크
public class LogAdvice {
	//포인트컷(Pointcut) : 비지니스 로직과 관련된 메소드 중에서 Advice(공통코드)가 적용될 메소드
	//표현식이 들어간다. 포현식은 내가 적용될 메소드에 대한 포맷을 설정 ( 복잡 )
	//리턴타입부터 패키지 클래스 실제 메소드까지 네가지 형태를 지정해주어야 한다
	
	//하위의 있는 모든 메소드에 적용하겠다라는 의미
	//          언제 어떻게 어느 어드바이스와 동작할껀지 맵핑시켜야 함
	//포인트컷은 메소드명으로 대체시킨다 ( = allPointCut )
	@Pointcut("within(com.yedam.spring.tx.service.*)")
	public void allPointCut() {} 
	
	
	//Weaving : 포인트컷 + 동작하고자하는 어드바이스 + 실제로 동작하고자하는 타이밍(위빙)
	//타이밍을 어노테이션 기반으로 설정
	//        메소드명을 적어준다
	@Around("allPointCut()")
	// JoinPoint : 포인트컷이 적용되는 메소드에 대한 전체를 들고있는 매개변수
	// ProceedingJoinPoint : 현재 실행하는 메소드에 대한 정보를 받아오는 것
	public Object logger(ProceedingJoinPoint joinpoint) throws Throwable {
		//AOP가 적용되는 메서드 이름
		String signatuerStr = joinpoint.getSignature().toString();
		System.out.println("시작 : " + signatuerStr);
		//공통기능
		System.out.println("핵심기능 전 실행 - 공통기능 : " + System.currentTimeMillis());
		
		try {
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
			//공통기능
			System.out.println("핵심기능 전 실행 - 공통기능 : " + System.currentTimeMillis());
			System.out.println("끝 : " + signatuerStr);
		} 
	}
}
