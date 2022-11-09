package com.DBInterface;

import com.DBUtility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBInterfaceImpl implements DBInterface{

    @Override
    public String ConnectToDB(String username,String password) {
        String message="Not Connected...!";

        try(Connection conn= DBUtil.ConnectToDataBase()) {
            PreparedStatement ps=conn.prepareStatement("Select * from Accountant where username=? and password=?");
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            message="Admin login Successfull...";
        } catch (SQLException e) {
            message=e.getMessage();
        }

        return message;
    }
}
