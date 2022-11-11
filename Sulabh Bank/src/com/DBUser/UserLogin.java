package com.DBUser;

import Home.FirstPage;
import com.DBInterface.DBInterface;
import com.DBInterface.DBInterfaceImpl;
import com.UserTasks.UserTasksMenu;

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
        DBI.ConnectUserToDB(username,password);
    }
}
