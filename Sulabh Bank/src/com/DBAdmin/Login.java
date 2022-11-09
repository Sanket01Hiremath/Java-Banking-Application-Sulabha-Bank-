package com.DBAdmin;

import Exeptions.adminExeption;
import com.DBInterface.DBInterface;
import com.DBInterface.DBInterfaceImpl;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) throws adminExeption {
        Scanner sc=new Scanner(System.in);
        System.out.println("---------------------------------------------");
        System.out.println("                 Admin Login                 ");
        System.out.println("---------------------------------------------");
        System.out.print("Enter Username: ");
        String username=sc.next();
        System.out.print("Enter Password: ");
        String password=sc.next();
        System.out.println("---------------------------------------------");

        DBInterface DBI=new DBInterfaceImpl();
        Boolean reply=DBI.ConnectToDB(username,password);
        if(reply==true){

            System.out.println("              Login Successfull..            ");
            System.out.println("---------------------------------------------");

        }else{
            System.out.println("---------------------------------------------");
            throw new adminExeption("Enter correct username or password");
        }
    }
}
