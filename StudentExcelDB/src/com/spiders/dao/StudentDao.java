package com.spiders.dao;

import java.util.List;

import com.spiders.dto.StudentDto;

public interface StudentDao {
		
	public int	saveStudent(StudentDto studentDto);
		
	//public boolean delete(long id);
	
	//public boolean delete(StudentDto studentDto);
	
	//public StudentDto update(StudentDto studentDto);
	
	public StudentDto findByUserNameAndPassword(String userName , String password);
	
	public StudentDto findByUserName(String userName );
	
	public List<StudentDto> findAll();
	
	
	
}
