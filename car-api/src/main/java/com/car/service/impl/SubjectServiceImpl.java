package com.car.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.SubjectDao;
import com.car.service.SubjectService;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	private SubjectDao subjectDao;


}
