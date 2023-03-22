package com.yedam.app.junit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//오토와일드를 사용한다는 것은 빈으로 등록해야한다는 것
@Component
public class Restaurant {
	
	@Autowired
	chef chef;
	
	public void open() {
		chef.cooking();
	}
}
