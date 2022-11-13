package com.DBInterface;

import com.Beans.RegistrationBean;
import com.Beans.UserBean;

import java.sql.ResultSet;

public interface DBInterface {
    public String RegisterUserBean();
    public String RegisterUser(RegistrationBean rb);
    public Boolean ConnectToDB(String username,String password);
    public void ConnectUserToDB(String username,String password);
    public String CreateUserBean();
    public String CreateUser(UserBean userBean);
    public void DeleteRegUser();
    public String CreateDepositTable(int name);
    public String CreateTransferTable(int name);
    public String EditUserData();
    public String RemoveUser();
    public void removeTable1(int AcNo);
    public void removeTable2(int AcNo);
    public String ShowSpecificUserData();
    public String ShowAllUsersData();
    public String ShowTransactions(int AcNo);
    public String ShowTransactions1(int AcNo);
    public String AddMoney(int AcNo,int Amount);
    public String TransferMoney(int AcNo);
    public int CheckBalance(int AcNo);
    public int CheckBalance1(int AcNo);

}
