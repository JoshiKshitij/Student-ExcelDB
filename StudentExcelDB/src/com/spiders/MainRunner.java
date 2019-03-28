package com.spiders;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.spiders.dto.StudentDto;
import com.spiders.service.StudentService;

public class MainRunner {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("app started");
		
		File propertiesFile = new File("src/com/spiders/config/application.properties");
		
		Properties properties = new Properties();
		
		try {
			FileInputStream inputStream = new FileInputStream(propertiesFile);
			properties.load(inputStream);
			
			String path = properties.getProperty("path");
			StudentService service = new StudentService(path);
			//StudentExcelDbDaoImpl studentExcelDbDaoImpl = new StudentExcelDbDaoImpl(path);
			
			StudentDto student = new StudentDto("ahmed", "ece", 87.9, "user", "raza", "raza@gmail.com", "78458745874");
			/*StudentDto student = new StudentDto();
			
			System.out.println("enter student name");
			String name = scanner.nextLine();
			student.setName(name);
			
			System.out.println("enter student email");
			String email = scanner.nextLine();
			student.setEmail(email);
			
			System.out.println("enter student mobileNo");
			String mobileNo = scanner.nextLine();
			student.setMobileNo(mobileNo);
			

			System.out.println("enter student password");
			String password = scanner.nextLine();
			student.setPassword(password);
			
			
			System.out.println("enter student percentage");
			double percentage = scanner.nextDouble();
			student.setPercentage(percentage);
			

			System.out.println("enter student stream");
			String stream = scanner.nextLine();
			student.setStream(stream);
			

			System.out.println("enter student user name");
			String userName = scanner.nextLine();
			student.setUserName(userName);
			
			*/
			
		  int savedStudentFlag = service.saveStudent(student);
			if(savedStudentFlag > 0) {
				System.out.println("Student saved");
			}
			
			//List<StudentDto> allStudent = service.findAll();
			//System.out.println(allStudent);
			
	//		System.out.println(service.findByUserNameAndPassword("joshi"));
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
