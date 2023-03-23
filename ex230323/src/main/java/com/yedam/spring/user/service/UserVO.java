package com.yedam.spring.user.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UserVO {
	private String name;
	private Integer age;
	// 날짜포맷 : / 
	@DateTimeFormat(pattern= "yyyy-MM-dd hh:mm:ss")
	private Date today;
}
