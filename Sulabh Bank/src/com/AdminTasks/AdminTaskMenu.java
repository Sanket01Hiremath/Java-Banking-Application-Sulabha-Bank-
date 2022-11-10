package com.AdminTasks;

import Home.FirstPage;
import com.DBInterface.DBInterface;
import com.DBInterface.DBInterfaceImpl;
import java.util.Scanner;

public class AdminTaskMenu {
    public static void ChooseATask(){
        Scanner sc=new Scanner(System.in);
        System.out.println("---------------------------------------------");
        System.out.println("Important Note:\ntype 1: To add new Customer,\ntype 2: To Update Customer Data,\ntype 3: To Remove Customer,\ntype 4: To Get Customer Details,\ntype 8: To LogOut");
        System.out.print("Choose a task you want to perform: ");
        int i=sc.nextInt();
        System.out.println("---------------------------------------------");
        DBInterface DBI=new DBInterfaceImpl();

        if(i==1){
            System.out.println(DBI.CreateUserBean());
            AdminTaskMenu.ChooseATask();
        }else if(i==2){
            System.out.println(DBI.EditUserData());
            AdminTaskMenu.ChooseATask();
        }else if(i==3){
            System.out.println(DBI.RemoveUser());
            AdminTaskMenu.ChooseATask();
        }else if(i==4){
            System.out.println(DBI.ShowSpecificUserData());
            AdminTaskMenu.ChooseATask();
        }else if(i==8){
            FirstPage.firstPage();
        }else{
            AdminTaskMenu.ChooseATask();
        }
    }
}
