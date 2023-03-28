package com.yedam.spring.tx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.spring.tx.mapper.CccMapper;
import com.yedam.spring.tx.service.CccService;

@Service
public class CccServiceImpl implements CccService {
	@Autowired
	CccMapper ccc;
	
	@Transactional
	@Override
	public void insert() {
		ccc.insert("101");
		ccc.insert("164");
	}
}
