package Sulabh.DBUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection ConnectToDataBase() {
		Connection conn=null;
		String Username="root";
		String Password="Sanket@123";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver Can't Connect...!");
		}
		
		String url="jdbc:mysql://localhost:3306/SulabhBankDataBase";
		
		try {
			conn=DriverManager.getConnection(url,Username,Password);
			System.out.println("User Connection Successfull.....!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Enter Correct Username or Password...!");
		}
		
		
		return conn;
		
	}
}
