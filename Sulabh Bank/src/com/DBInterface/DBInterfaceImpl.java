package com.DBInterface;

import com.DBUtility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBInterfaceImpl implements DBInterface{

    @Override
    public Boolean ConnectToDB(String username,String password) {

        try(Connection conn= DBUtil.ConnectToDataBase()) {
            PreparedStatement ps=conn.prepareStatement("Select * from Accountant where username=? and password=?");
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }
}
