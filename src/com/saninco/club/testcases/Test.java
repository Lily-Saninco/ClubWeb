package com.saninco.club.testcases;

import java.sql.SQLException;

import com.saninco.club.testClass.ClubUser;
import com.saninco.club.util.FileForUser;

public class Test {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {

	    ClubUser databaseUser=FileForUser.userSearch("user1");
	}

}
