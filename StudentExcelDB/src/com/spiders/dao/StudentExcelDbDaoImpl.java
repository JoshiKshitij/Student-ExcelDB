package com.spiders.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.spiders.dto.StudentDto;

public class StudentExcelDbDaoImpl implements StudentDao {
	
	String path = "";

	public void saveBikeInSheet(StudentDto student, int rowNo) {
		// workbook implation class will used for creating sheets
		Workbook workBook = new HSSFWorkbook();
		// will create a blank sheet
		Sheet sheet = workBook.createSheet("Bike Details");
		// row where the data will be saved
		Row row = sheet.createRow(rowNo);
		Cell cell1 = row.createCell(0);
		
		
		try (FileOutputStream outputStream = new FileOutputStream(path)) {
			workBook.write(outputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public int saveStudent(StudentDto studentDto) {
		Workbook workbook = null;
		Sheet sheet = null;
		try {
			
			// it will create the file and will true, false if file already exits
			File file = new File(path);
			if (!file.exists()) {
				workbook = new HSSFWorkbook();
				sheet = workbook.createSheet("Students Details");
			} else {
				
				// if file exits
				FileInputStream inputStream = new FileInputStream(file);
				workbook = (HSSFWorkbook) WorkbookFactory.create(inputStream);
				// will create a blank sheet
				sheet = workbook.getSheetAt(0);
			}
			
			int lastRowNum = sheet.getLastRowNum();
			Row row = sheet.createRow(lastRowNum+1);
			
			// we have a row to will create cells to now
			Cell id = row.createCell(0);
			id.setCellValue(lastRowNum+1);
			
			Cell name = row.createCell(1);
			name.setCellValue(studentDto.getName());
			
			Cell email = row.createCell(2);
			email.setCellValue(studentDto.getEmail());
			
			Cell userName = row.createCell(3);
			userName.setCellValue(studentDto.getUserName());
			
			Cell password = row.createCell(4);
			password.setCellValue(studentDto.getPassword());
			
			Cell mobileNo = row.createCell(5);
			mobileNo.setCellValue(studentDto.getMobileNo());
			
			Cell per = row.createCell(6);
			per.setCellValue(studentDto.getPercentage());
			
			Cell stream = row.createCell(7);
			stream.setCellValue(studentDto.getStream());
			
			
			// one all cells are filed i have to create a outputstream
			
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
			
			return lastRowNum+1;
		} catch ( 
				EncryptedDocumentException | 
				InvalidFormatException | 
				IOException e) {
			e.printStackTrace();
		}
		
		return 0;
	}


    //constructor
	public StudentExcelDbDaoImpl(String path) {
		super();
		
		this.path = path;
		System.out.println(this.path);
	}

	@Override
	public List<StudentDto> findAll()  {
		List<StudentDto > listOfStudents = new ArrayList<>();
		File file = new File(path);
		if(!file.exists()) {
			return listOfStudents;
		}
		try {
			FileInputStream inp = new FileInputStream(file);
			Workbook workbook = WorkbookFactory.create(inp);
			
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.rowIterator();
			//new StudentDto(id, name, stream, percentage, email, password, userName, mobileNo)
			while(rowIterator.hasNext()) {
				Row row = rowIterator.next();
				listOfStudents.add(new StudentDto(
						(long)row.getCell(0).getNumericCellValue(),
						row.getCell(1).getStringCellValue(),
						row.getCell(7).getStringCellValue(),	
						(double)row.getCell(6).getNumericCellValue(),
						row.getCell(2).getStringCellValue(),	
						row.getCell(4).getStringCellValue(),	
						row.getCell(3).getStringCellValue(),
						row.getCell(5).getStringCellValue()
						));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listOfStudents;
	}

	@Override
	public StudentDto findByUserNameAndPassword(String userName, String password) {
		
		File file = new File(path);
		if(!file.exists()) {
			return null;
		}
		try {
			FileInputStream inp = new FileInputStream(file);
			Workbook workbook = WorkbookFactory.create(inp);
			Sheet sheet = workbook.getSheetAt(0);
			
			Iterator<Row> rowIterator = sheet.rowIterator();
			
			while(rowIterator.hasNext()) {
				Row row = rowIterator.next();
				
				String userNameDb = row.getCell(3).getStringCellValue();
			//	System.out.println("userNameDb ---> " +userNameDb);
				String passwordDb = row.getCell(4).getStringCellValue();
			//	System.out.println("passwordDb ---> " +passwordDb);
				
				if(userName.equals(userNameDb) && password.equals(passwordDb)) {
				return	new StudentDto(
							(long)row.getCell(0).getNumericCellValue(),
							row.getCell(1).getStringCellValue(),
							row.getCell(7).getStringCellValue(),	
							(double)row.getCell(6).getNumericCellValue(),
							row.getCell(2).getStringCellValue(),	
							row.getCell(4).getStringCellValue(),	
							row.getCell(3).getStringCellValue(),
							row.getCell(5).getStringCellValue()
							);
				}
			}
			
			
			
			
		
		}catch (Exception e) {
				// TODO: handle exception
			}
		return null;
	}

	@Override
	public StudentDto findByUserName(String userName) {
		
		File file = new File(path);
		if(!file.exists()) {
			return null;
		}
		try {
			FileInputStream inp = new FileInputStream(file);
			Workbook workbook = WorkbookFactory.create(inp);
			Sheet sheet = workbook.getSheetAt(0);
			
			Iterator<Row> rowIterator = sheet.rowIterator();
			while(rowIterator.hasNext()) {
				Row row = rowIterator.next();
				
				String userNameDb = row.getCell(3).getStringCellValue();
			//	System.out.println("userNameDb ---> " +userNameDb);
				
				if(userName.equals(userNameDb)) {
					return new StudentDto(
							(long)row.getCell(0).getNumericCellValue(),
							row.getCell(1).getStringCellValue(),
							row.getCell(7).getStringCellValue(),	
							(double)row.getCell(6).getNumericCellValue(),
							row.getCell(2).getStringCellValue(),	
							row.getCell(4).getStringCellValue(),	
							row.getCell(3).getStringCellValue(),
							row.getCell(5).getStringCellValue()
							);
				}
			}
		
		}catch (Exception e) {
				// TODO: handle exception
			}
		return null;
	}

}
