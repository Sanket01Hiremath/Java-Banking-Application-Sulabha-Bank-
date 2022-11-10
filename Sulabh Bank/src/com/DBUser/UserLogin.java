package com.DBUser;

import Home.FirstPage;
import com.DBInterface.DBInterface;
import com.DBInterface.DBInterfaceImpl;

import java.util.Scanner;

public class UserLogin {
    public static void Userlogin() {
        Scanner sc=new Scanner(System.in);
        System.out.println("---------------------------------------------");
        System.out.println("               Customer Login                ");
        System.out.println("---------------------------------------------");
        System.out.print("Enter Username: ");
        String username=sc.next();
        System.out.print("Enter Password: ");
        String password=sc.next();
        System.out.println("---------------------------------------------");

        DBInterface DBI=new DBInterfaceImpl();
        Boolean reply=DBI.ConnectUserToDB(username,password);
        if(reply==true){
            System.out.println("              Login Successfull..            ");
            System.out.println("---------------------------------------------");
        }else{
            System.out.println("---------------------------------------------");
            System.out.println("      Enter correct username or password     ");
            FirstPage.firstPage();
        }
    }
}
