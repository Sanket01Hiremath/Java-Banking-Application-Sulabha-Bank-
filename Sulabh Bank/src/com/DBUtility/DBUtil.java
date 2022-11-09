package com.DBUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection ConnectToDataBase() {
        Connection conn = null;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("---------------------------------------------");
            System.out.println("            Driver Connection Failed..       ");
        }

        String url = "jdbc:mysql://localhost:3306/SulabhBankDataBase";

        try {
            conn = DriverManager.getConnection(url, "root", "Sanket@123");
            System.out.println("---------------------------------------------");
            System.out.println("             Connection Successfull..        ");
            System.out.println("---------------------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("---------------------------------------------");
            System.out.println("               Connection Failed..           ");
            System.out.println("---------------------------------------------");
        }
        return conn;
    }
}
