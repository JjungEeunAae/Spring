package com.yedam.spring.user.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.spring.user.service.UserListVO;
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
	
	@RequestMapping("/insertUsers")
	public List<UserVO> insertUserList(UserListVO userListVO){
		for(UserVO user : userListVO.getList()) {
			System.out.println(user);
		}
		
		return userListVO.getList();
	}
	
	@RequestMapping("/getUserData")
	/* @RequestParam
	   개별로 받아서 UserVO롤 만들었음
	   단건 혹은 소스의 값을 받을 때 꼭 객체를 만들지않고 컨트롤러에서 무엇무엇을 넣을 때 사용하면 된다
	   get, post이든 이름과 값을 쌍으로 보내는건 똑같음
	   서버에서 처리하는 방식이 다를뿐
	   이름과 함께 넘어온 값에 대해서 개별 변수
	 */
	
	// 실제 변수랑 넘어오는 이름이랑 다르게 설정할 수도 있음
	// @RequestParam("id") --> value속성, 해당 파라미터로 값을 받겠다는 의미
	// 부여되어 있지않다면 매개변수의 이름을 사용하는 것
	
	// 선언을 했으면 값이 모두 들어와야 처리가 가능하다
	// 커멘드객체와 다른 점
	// 커멘드객체는 내부에 선언된 필드에 대해서 모두 없어도 크게 문제가 되지 않는다
	
	// @RequestParam(required = false)
	// 필수 여부를 부여
	// 필수인지 필수가 아닌지 정해준다
	
	// int -> Integer 로 수정
	// int는 required를 처리하지 못한다
	public UserVO getUserData(@RequestParam("id") String name,
							  @RequestParam(defaultValue = "0", required = false) int age) {
		UserVO userVO = new UserVO();
		userVO.setName(name);
		//userVO.setAge(age == null ? 0 : age);
		userVO.setAge(age);
		
		return userVO;
	}
	
	@GetMapping("/getDataList")
	public String getDataList(@RequestParam(required = false) Map<String, Object> map) {
		String message = null;
		
		//Map을 순환해서 사용하는 것
		if(map.isEmpty()) {
			message = "데이터가 존재하지 않습니다";
		} else {
			message = "데이터가 생성되었습니다";
			
			Set<Map.Entry<String,Object>> entryList = map.entrySet();
			for(Map.Entry<String, Object> entry : entryList) {
				System.out.printf("Key : " + entry.getKey() );
				System.out.println(", Value : " + entry.getValue());
			}
		}
		
		return message;
	}
	
	
	@RequestMapping("/getNames")
	public Map<String, Object> getNames(@RequestParam List<String> name){
		Map<String, Object> map = new HashMap<>();
		
		map.put("result", "success");
		map.put("data", name);
		
		return map;
	}
	
	// 이렇게도 사용이 가능하다
	// * /getEmpInfo/{employeeId}/data
	// * /getEmpInfo/{employeeId}/{data}
	// * 단, 쓴 값만큼 선언을 해주어야한다
	@RequestMapping("/getEmpInfo/{employeeId}")
	public UserVO getEmpInfo(@PathVariable String employeeId) {
		UserVO vo = new UserVO();
		vo.setName(employeeId);
		
		return vo;
	}
	
	
	@RequestMapping("/getInfo")
	public UserVO getInfo(@RequestBody UserVO userVO) {
		return userVO;
	}
	
	@PostMapping("/upload")
	public String uploadFile(UserVO userVO) {
		System.out.println("name : " + userVO.getName());
		System.out.println("file : " + userVO.getPic().getOriginalFilename());
		return "업로드가 완료되었습니다";
	}
	
	
	
	
	
	
	
	
	
	
}