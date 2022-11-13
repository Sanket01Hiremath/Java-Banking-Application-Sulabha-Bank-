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
        System.out.println("                    Important Note:\ntype 1: To add new Customer,\ntype 2: To Update Customer Data,\ntype 3: To Remove Customer,\ntype 4: To Get A Customer Details,\ntype 5: To Get All Customers Details,\ntype 6: To Manage Customer Account,\ntype 101: To LogOut");
        System.out.print("Choose a task you want to perform: ");
        int i=sc.nextInt();
        System.out.println("-------------------------------------------------------------------");
        DBInterface DBI=new DBInterfaceImpl();

        if(i==1){
            try{
                System.out.println(DBI.CreateUserBean());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                AdminTaskMenu.ChooseATask();
            }
            AdminTaskMenu.ChooseATask();
        }else if(i==2){
            try{
                System.out.println(DBI.EditUserData());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                AdminTaskMenu.ChooseATask();
            }
            AdminTaskMenu.ChooseATask();
        }else if(i==3){
            try{
                System.out.println(DBI.EditUserData());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                AdminTaskMenu.ChooseATask();
            }
            System.out.println(DBI.RemoveUser());
            AdminTaskMenu.ChooseATask();
        }else if(i==4){
            try{
                System.out.println(DBI.ShowSpecificUserData());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                AdminTaskMenu.ChooseATask();
            }
            AdminTaskMenu.ChooseATask();
        }else if(i==5){
            try{
                System.out.println(DBI.ShowAllUsersData());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                AdminTaskMenu.ChooseATask();
            }
            AdminTaskMenu.ChooseATask();
        }else if(i==6){
            Scanner Sc=new Scanner(System.in);
            System.out.print("Enter AccountNumber: ");
            int AcNo= Sc.nextInt();
            UserTasksMenu.ChooseATask(AcNo,"Admin");
            AdminTaskMenu.ChooseATask();
        }else if(i==101){
            System.out.println("-------------------------------------------------------------------");
            System.out.println("                          Logout Successful                        ");
            System.out.println("-------------------------------------------------------------------");
            FirstPage.firstPage();
        }else{
            AdminTaskMenu.ChooseATask();
        }
    }
}
