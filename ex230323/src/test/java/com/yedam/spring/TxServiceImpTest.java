package com.yedam.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.spring.tx.service.Cats;
import com.yedam.spring.tx.service.CccService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations="file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class TxServiceImpTest {
	@Autowired
	CccService service;
	
	@Autowired
	Cats cat;
	
	/*@Test
	public void txTest() {
		service.insert();
	}*/
	
	@Test
	public void aopTest() {
		cat.printInfo();
	}
}
