package com.DBAdmin;

import Home.FirstPage;
import com.AdminTasks.AdminTaskMenu;
import com.DBInterface.DBInterface;
import com.DBInterface.DBInterfaceImpl;

import java.util.Scanner;

public class AdminLogin {
    public static void Adminlogin() {
        Scanner sc=new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("                            Admin Login                            ");
        System.out.println("-------------------------------------------------------------------");
        System.out.print("Enter Username: ");
        String username=sc.next();
        System.out.print("Enter Password: ");
        String password=sc.next();

        DBInterface DBI=new DBInterfaceImpl();
        Boolean reply=DBI.ConnectToDB(username,password);
        if(reply==true){
            System.out.println("-------------------------------------------------------------------");
            System.out.println("                        Login Successfull..                        ");
            System.out.println("-------------------------------------------------------------------");
            AdminTaskMenu.ChooseATask();
        }else{
            System.out.println("-------------------------------------------------------------------");
            System.out.println("                  Enter correct username or password               ");
            FirstPage.firstPage();
        }
    }
}
