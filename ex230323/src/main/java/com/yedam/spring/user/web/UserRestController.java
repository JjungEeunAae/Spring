package com.yedam.spring.user.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.spring.user.service.UserVO;

//간단한 에러를 처리해주는 어노테이션
@CrossOrigin
//데이터를 반환하는 컨트롤러
@RestController
public class UserRestController {
	//경로
	@RequestMapping(value = "/insertUser",
					method = RequestMethod.POST)
	public UserVO insertUser(UserVO userVO) {
		System.out.println("name : " + userVO.getName());
		System.out.println("age : " + userVO.getAge());
		
		return userVO;
	}
}