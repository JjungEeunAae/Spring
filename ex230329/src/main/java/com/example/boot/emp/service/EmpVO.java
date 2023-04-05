package com.example.boot.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class EmpVO {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date hireDate;
	private String jobId;
	private int departmentId;
}
