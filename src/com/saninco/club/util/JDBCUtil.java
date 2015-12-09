package com.saninco.club.util;



import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	
	// this is for mySQL jdbc
	public static final String dbUserName = "root";
	public static final String dbPassword = "sts!@#";
	//public static final String jdbcUrl = "jdbc:mysql://localhost:3306/newjob";
	public static final String jdbcUrl = "jdbc:mysql://192.168.1.77:3306/club_db";
	public static final String jdbcDriverName = "com.mysql.jdbc.Driver";
	
	//this id for oracle jdbc
	

	
	//for microsoft SQL server
	
	/*public static final String jdbcUrl = "jdbc:sqlserver://192.168.1.180:1433;DatabaseName=TEST_DB";
	public static final String jdbcDriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	 */
	/*public static final String dbUserName = "sa";
	public static final String dbPassword = "abc123";
	public static final String jdbcUrl = "jdbc:jtds:sqlserver://192.168.1.147:1433;DatabaseName=AdventureWorks;";
	public static final String jdbcDriverName = "net.sourceforge.jtds.jdbc.Driver";*/
	
	
	public static Connection getConnection() throws Exception {
		Class.forName(jdbcDriverName).newInstance();
		return DriverManager.getConnection(jdbcUrl, dbUserName, dbPassword);
	}
}