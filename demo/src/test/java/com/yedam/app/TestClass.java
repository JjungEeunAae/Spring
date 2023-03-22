package com.yedam.app;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.junit.Restaurant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestClass {
	
	//해당 인터페이스를 기반으로 해서 구현클래스가 다양할 수 있고
	//그 구현클래스를 적절하게 바꿔가면서 사용해야하기 때문에 인터페이스를 선언하는게 맞다.
	//@Autowired
	//ApplicationContext ctx;
	
	//컨테이너를 변수로 제어 안해도 된다
	//이미 Restaurant 클래스에 Component를 통해 빈으로 만들어두었기 때문이다
	@Autowired
	Restaurant res;
	
	@Test
	public void beanTest() {
		//이름이 없는 Bean은 .class를 활용하여 해당 클래스에 대한 정보를 넘겨준다
		//Restaurant res = ctx.getBean(Restaurant.class);
		assertNotNull(res);
	}
}
