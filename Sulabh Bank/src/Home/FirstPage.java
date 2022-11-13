package Home;

import com.DBAdmin.AdminLogin;
import com.DBUser.UserLogin;
import java.util.Scanner;

public class FirstPage {
    public static void firstPage(){
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------------------------------------------------------");
        System.out.println("                    Welcome TO Sulabh Bank                      ");
        System.out.println("----------------------------------------------------------------");
        System.out.println("                       Important Note:\n                  Type 1-> For Admin Login,\n                Type 2-> For Customer Login");
        System.out.print("Enter the UserType: ");
        int userType=sc.nextInt();
        System.out.println("----------------------------------------------------------------");
        if(userType==1){
            AdminLogin.Adminlogin();
        }else if(userType==2){
            UserLogin.Userlogin();
        }else{
            System.out.println("                   Enter Correct Option.!                       ");
            FirstPage.firstPage();
        }
    }
}
