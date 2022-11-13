package com.UserTasks;

import Home.FirstPage;
import com.AdminTasks.AdminTaskMenu;
import com.DBInterface.DBInterface;
import com.DBInterface.DBInterfaceImpl;

import java.util.Scanner;

public class UserTasksMenu {
    public static void ChooseATask(int AcNo,String User){
        Scanner sc=new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("                    Important Note:\ntype 1: To Add Money,\ntype 2: To Transfer Money ,\ntype 3: To Check Balance,\ntype 4: To Get Transaction History,\ntype 8: To LogOut");
        System.out.print("Choose a task you want to perform: ");
        int i=sc.nextInt();
        System.out.println("-------------------------------------------------------------------");
        DBInterface DBI=new DBInterfaceImpl();

        if(i==1){
            Scanner Sc=new Scanner(System.in);
            System.out.print("Enter Amount: ");
            int Amount= Sc.nextInt();
            System.out.println(DBI.AddMoney(AcNo,Amount));
            UserTasksMenu.ChooseATask(AcNo,User);
        }else if(i==2){
            System.out.println(DBI.TransferMoney(AcNo));
            System.out.println("-------------------------------------------------------------------");
            UserTasksMenu.ChooseATask(AcNo,User);
        }else if(i==3){
            System.out.println(DBI.CheckBalance(AcNo));
            UserTasksMenu.ChooseATask(AcNo,User);
        }else if(i==4){
            System.out.println(DBI.ShowTransactions(AcNo));
            UserTasksMenu.ChooseATask(AcNo,User);
        }else if(i==8){
            System.out.println("-------------------------------------------------------------------");
            System.out.println("                          LogOut Successful                        ");
            System.out.println("-------------------------------------------------------------------");
            if(User=="Customer") {
                FirstPage.firstPage();
            }else{
                AdminTaskMenu.ChooseATask();
            }
        }else{
            UserTasksMenu.ChooseATask(AcNo,User);
        }
    }
}
