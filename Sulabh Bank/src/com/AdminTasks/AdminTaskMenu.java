package com.AdminTasks;

import Home.FirstPage;
import com.DBInterface.DBInterface;
import com.DBInterface.DBInterfaceImpl;
import com.UserTasks.UserTasksMenu;

import java.util.Scanner;

public class AdminTaskMenu {
    public static void ChooseATask(){
        Scanner sc=new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("                    Important Note:\ntype 1: To add new Customer,\ntype 2: To Update Customer Data,\ntype 3: To Remove Customer,\ntype 4: To Get A Customer Details,\ntype 5: To Get All Customers Details,\ntype 6:To Manage Customer Account,\ntype 101: To LogOut");
        System.out.print("Choose a task you want to perform: ");
        int i=sc.nextInt();
        System.out.println("-------------------------------------------------------------------");
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
        }else if(i==5){
            System.out.println(DBI.ShowAllUsersData());
            AdminTaskMenu.ChooseATask();
        }else if(i==6){
            Scanner Sc=new Scanner(System.in);
            System.out.print("Enter AccountNumber: ");
            int AcNo= Sc.nextInt();
            UserTasksMenu.ChooseATask(AcNo,"Admin");
            AdminTaskMenu.ChooseATask();
        }else if(i==101){
            System.out.println("-------------------------------------------------------------------");
            System.out.println("                          LogOut Successful                        ");
            System.out.println("-------------------------------------------------------------------");
            FirstPage.firstPage();
        }else{
            AdminTaskMenu.ChooseATask();
        }
    }
}
