package com.saninco.club.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.saninco.club.testClass.ClubUser;




public class FileForUser {
	public String filelocation;

		public static ArrayList<ClubUser> readFile() throws IOException {
		String fileName = "D:\\ClubProject\\ClubTestData\\ClubTestData.xlsx";
		//String fileName ="D:\\New_coop_2015\\MycoopDocument\\testdata_approval.xlsx";
		FileInputStream file = new FileInputStream(new File(fileName));

		// Get the workbook instance for XLS file
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// Get first sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);
		ArrayList<ClubUser> userList = new ArrayList<ClubUser>();
		String cellvalue = null;
		for (int i = 1; i <=sheet.getLastRowNum(); i++) {

			XSSFRow row = sheet.getRow(i);

			ClubUser user = new ClubUser();
			user.setTestCaseNumber(row.getCell(0).getStringCellValue());
			user.setBrowser(row.getCell(1).getStringCellValue());
//			user.setEmail(row.getCell(2).getStringCellValue());
			user.setUserName(row.getCell(3).getStringCellValue());
			user.setPassword(row.getCell(4).getStringCellValue());
			user.setCompitition(row.getCell(5).getStringCellValue());
			user.setOperation(row.getCell(6).getStringCellValue());
	//		user.setPostalCode(row.getCell(7).getStringCellValue());
			
	//		System.out.println(""+user.getEmail());
			System.out.println(""+user.getPassword());
			
			userList.add(user);

		
		}
		for (ClubUser user : userList)
		{
		System.out.println("user:"+user.getUserName());
		}
		
		return userList;
	}

		
	
	public static ClubUser userSearch(String string) throws SQLException {

		/*
		 * Search username and password by user id
		 */

		Connection connection = null;
		ClubUser user = new ClubUser();
		try {
			connection = JDBCUtil.getConnection();
			System.out.println("userEmail:" + string);

			String sql = " select u.first_name, u.last_name from user u "
					+ "where u.email=?";

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, string);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
	
				user.setFirstName(rs.getString("u.first_name"));
				user.setLastName(rs.getString("u.last_name"));
				
			}

			return user;
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			connection.close();
		}
		return user;
	}

	}


