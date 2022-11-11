package com.DBInterface;

import Home.FirstPage;
import com.Beans.UserBean;
import com.DBUtility.DBUtil;
import com.UserTasks.UserTasksMenu;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Date;
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
    public void ConnectUserToDB(String username, String password) {

        try(Connection conn=DBUtil.ConnectToDataBase()) {
            PreparedStatement ps=conn.prepareStatement("Select * from Users where username=? and password=?");
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                System.out.println("---------------------------------------------");
                System.out.println("               Login Successful              ");
                UserTasksMenu.ChooseATask(rs.getInt("AccountNumber"));
            }else{
                System.out.println("---------------------------------------------");
                System.out.println("            User Does Not Exists..           ");
                System.out.println("---------------------------------------------");
                FirstPage.firstPage();
            }
        } catch (SQLException e) {
            System.out.println("---------------------------------------------");
            System.out.println("            User Does Not Exists..           ");
            System.out.println("---------------------------------------------");
            FirstPage.firstPage();
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
        System.out.println("-------------------------------------------------------------------");

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
                DBInterface DBI=new DBInterfaceImpl();
                message=DBI.CreateDepositTable(userBean.getAccountNo());
            }else{
                message="                        New User Not Added                         ";
                System.out.println("-------------------------------------------------------------------");
            }

        } catch (SQLException e) {
            message=e.getMessage();
            System.out.println("-------------------------------------------------------------------");
        }

        return message;
    }

    @Override
    public String CreateDepositTable(int name) {
        String message="";

        try(Connection conn=DBUtil.ConnectToDataBase()){
            PreparedStatement ps=conn.prepareStatement("create table D?(id int Primary key,Deposit int,Date datetime)");
            ps.setInt(1,name);
            ps.executeUpdate();
            DBInterface DBI=new DBInterfaceImpl();
            message=DBI.CreateTransferTable(name);
        }catch (SQLException e) {
            message=e.getMessage();
        }

        return message;
    }
    public String CreateTransferTable(int name) {
        String message="";

        try(Connection conn=DBUtil.ConnectToDataBase()){
            PreparedStatement ps=conn.prepareStatement("create table T?(id int,Transfer int,Date datetime,foreign key(id) references D?(id))");
            ps.setInt(1,name);
            ps.setInt(2,name);
            ps.executeUpdate();
            message ="                          New User Added                           ";
            System.out.println("-------------------------------------------------------------------");
        }catch (SQLException e) {
            message=e.getMessage();
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
                message="           Updated "+name+" value successfully             ";
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
                message="      Deleted User with Account Number "+acNo+" successfully       ";
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
                message="               User Does not Exists..!                ";
            }
        } catch (SQLException e) {
            message=e.getMessage();
        }
        return message;
    }

    @Override
    public String ShowAllUsersData() {
        String message="";

        try(Connection conn= DBUtil.ConnectToDataBase()) {
            PreparedStatement ps=conn.prepareStatement("Select * from users");
            ResultSet rs=ps.executeQuery();
            int i=1;
            while(rs.next()){
                System.out.println("-------------------------------------------------------------------");
                System.out.println(i+")                        User Profile                            ");
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
                i++;
            }
        } catch (SQLException e) {
            message=e.getMessage();
        }
        return message;
    }

    @Override
    public String ShowTransactions(int AcNo) {
        String message="";

        try(Connection conn=DBUtil.ConnectToDataBase()){
            PreparedStatement ps=conn.prepareStatement("Select * from D?");
            ps.setInt(1,AcNo);
            ResultSet rs=ps.executeQuery();
            System.out.println("-------------------------------------------------------------------");
            System.out.println("|      Deposit               Withdraw            Date And Time  |");
            System.out.println("-------------------------------------------------------------------");
            while(rs.next()){
                System.out.println("|  "+rs.getInt("Deposit")+"  |  "+rs.getInt("Withdraw")+"  |  "+rs.getDate("Date")+"  |");
            }
        } catch (SQLException e) {
            message=e.getMessage();
        }

        return message;
    }

    @Override
    public String AddMoney(int AcNo) {
        String message="";
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Amount: ");
        int Amount=sc.nextInt();

        try(Connection conn=DBUtil.ConnectToDataBase()){
            PreparedStatement ps=conn.prepareStatement("insert into D? values(?,now())");
            ps.setInt(1,AcNo);
            ps.setInt(2,Amount);
            ps.executeUpdate();
            message ="                   "+Amount+" Added to "+AcNo+"                    ";
            System.out.println("-------------------------------------------------------------------");
        } catch (SQLException e) {
            message=e.getMessage();
        }

        return message;
    }

    @Override
    public String TransferMoney(int AcNo) {
        String message="";
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Beneficiary Account Number: ");
        int AcNo2=sc.nextInt();
        try(Connection conn=DBUtil.ConnectToDataBase()){
            PreparedStatement ps=conn.prepareStatement("select * from A?");
            ps.setInt(1,AcNo);
            ResultSet rs=ps.executeQuery();
            System.out.println("-------------------------------------------------------------------");
            System.out.println("|      Deposit               Withdraw            Date And Time  |");
            System.out.println("-------------------------------------------------------------------");
            while(rs.next()){
                System.out.println("|  "+rs.getInt("Deposit")+"  |  "+rs.getInt("Withdraw")+"  |  "+rs.getDate("Date")+"  |");
            }

        } catch (SQLException e) {
            message=e.getMessage();
        }

        return message;
    }
}
