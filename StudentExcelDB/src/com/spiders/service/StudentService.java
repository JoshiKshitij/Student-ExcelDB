package com.spiders.service;

import java.util.List;

import com.spiders.dao.StudentDao;
import com.spiders.dao.StudentExcelDbDaoImpl;
import com.spiders.dto.StudentDto;

public class StudentService {
	String path;

	StudentDao dao ;

	public int saveStudent(StudentDto studentDto) {
		return dao.saveStudent(studentDto);
	};

	public StudentDto findByUserNameAndPassword(String userName , String password) {
		return dao.findByUserNameAndPassword(userName,password);
	};
	
	public StudentDto findByUserNameAndPassword(String userName ) {
		return dao.findByUserName(userName);
	};
	
	public List<StudentDto> findAll() {
		return dao.findAll();
	}

	public StudentService(String path) {
		super();
		this.path = path;
		this.dao = new StudentExcelDbDaoImpl(path);
	}
	
	
}
