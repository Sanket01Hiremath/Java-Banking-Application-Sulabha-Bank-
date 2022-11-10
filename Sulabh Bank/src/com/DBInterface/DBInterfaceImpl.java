package com.DBInterface;

import com.Beans.UserBean;
import com.DBUtility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

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

    @Override
    public Boolean ConnectUserToDB(String username, String password) {

        try(Connection conn=DBUtil.ConnectToDataBase()) {
            PreparedStatement ps=conn.prepareStatement("Select * from Users where username=? and password=?");
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

    @Override
    public String CreateUserBean() {
        Scanner sc=new Scanner(System.in);
        System.out.print("UserID       : ");
        int id=sc.nextInt();
        System.out.print("FirstName    : ");
        String Fname=sc.next();
        System.out.print("LastName     : ");
        String Lname=sc.next();
        System.out.print("Address      : ");
        String Address=sc.next();
        System.out.print("AreaCode     : ");
        int AreaCode=sc.nextInt();
        System.out.print("AccountNumber: ");
        int AcNo=sc.nextInt();
        System.out.print("Username     : ");
        String Uname=sc.next();
        System.out.print("Password     : ");
        String Password=sc.next();
        System.out.println("---------------------------------------------");

        UserBean userBean=new UserBean(id,AcNo,Fname,Lname,Address,AreaCode,Uname,Password);
        return CreateUser(userBean);
    }

    @Override
    public String CreateUser(UserBean userBean) {
        String message="User Not Created";

        try(Connection conn=DBUtil.ConnectToDataBase()) {
            PreparedStatement ps=conn.prepareStatement("insert into Users values(?,?,?,?,?,?,?,?)");
            ps.setInt(1,userBean.getUserId());
            ps.setString(2,userBean.getFirstName());
            ps.setString(3,userBean.getLastName());
            ps.setString(4,userBean.getAddress());
            ps.setInt(5,userBean.getAreaCode());
            ps.setInt(6,userBean.getAccountNo());
            ps.setString(7,userBean.getUsername());
            ps.setString(8,userBean.getPassword());
            int x=ps.executeUpdate();
            if(x==1) {
                message ="New User Added";
            }else{
                message="New User Not Added";
            }
            System.out.println("---------------------------------------------");
        } catch (SQLException e) {
            message=e.getMessage();
            System.out.println("---------------------------------------------");
        }

        return message;
    }

    @Override
    public String EditUserData() {
        String message="";
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter AccountNumber : ");
        int acNo=sc.nextInt();
        System.out.print("Enter Feild Name    : ");
        String name=sc.next();
        System.out.print("Enter new Value     : ");
        String value=sc.next();

        try(Connection conn=DBUtil.ConnectToDataBase()) {
            PreparedStatement ps=conn.prepareStatement("Update users set "+name+"=? where AccountNumber=?");
            ps.setString(1,value);
            ps.setInt(2,acNo);
            int x=ps.executeUpdate();
            if(x==1){
                message="Updated "+name+" value successfully";
            }
        } catch (SQLException e) {
            message=e.getMessage();
        }

        return message;
    }

    @Override
    public String RemoveUser() {
        String message="";
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter AccountNumber : ");
        int acNo=sc.nextInt();

        try(Connection conn=DBUtil.ConnectToDataBase()) {
            PreparedStatement ps=conn.prepareStatement("delete from users where AccountNumber=?");
            ps.setInt(1,acNo);
            int x=ps.executeUpdate();
            if(x==1){
                message="Deleted User with Account Number "+acNo+" successfully";
            }
        } catch (SQLException e) {
            message=e.getMessage();
        }

        return message;
    }

    @Override
    public String ShowSpecificUserData() {
        String message="";
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter AccountNumber : ");
        int acNo=sc.nextInt();

        try(Connection conn= DBUtil.ConnectToDataBase()) {
            PreparedStatement ps=conn.prepareStatement("Select * from users where AccountNumber=?");
            ps.setInt(1,acNo);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                System.out.println("-------------------------------------------------------------------");
                System.out.println("                           User Profile                            ");
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Name          :"+rs.getString("FirstName")+" "+rs.getString("LastName"));
                System.out.println("UserID        : "+rs.getInt("id"));
                System.out.println("Account Number: "+rs.getInt("AccountNumber"));
                System.out.println("Address       :"+rs.getString("Address"));
                System.out.println("Area Code     :"+rs.getInt("AreaCode"));
                System.out.println("-------------------------------------------------------------------");
                System.out.println("                          Login Credentials                        ");
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Username      :"+rs.getString("username"));
                System.out.println("Password      :"+rs.getString("password"));
                System.out.println("-------------------------------------------------------------------");
            }else{
                message="User Does not Exists..!";
            }
        } catch (SQLException e) {
            message=e.getMessage();
        }
        return message;
    }

    @Override
    public String ShowAllUsersData() {
        return null;
    }
}
