package com.DBAdmin;

import com.DBInterface.DBInterface;
import com.DBInterface.DBInterfaceImpl;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        /*Scanner sc=new Scanner(System.in);
        System.out.print("Enter Username:");
        String username=sc.next();
        System.out.print("Enter Password");
        String password=sc.next();*/

        DBInterface DBI=new DBInterfaceImpl();
        System.out.println(DBI.ConnectToDB("Sanket","Sanket@123"));
    }
}
