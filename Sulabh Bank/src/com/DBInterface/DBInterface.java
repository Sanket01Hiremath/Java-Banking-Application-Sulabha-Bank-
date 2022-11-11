package com.DBInterface;

import com.Beans.UserBean;

import java.sql.ResultSet;

public interface DBInterface {
    public Boolean ConnectToDB(String username,String password);
    public void ConnectUserToDB(String username,String password);
    public String CreateUserBean();
    public String CreateUser(UserBean userBean);
    public String CreateDepositTable(int name);
    public String CreateTransferTable(int name);
    public String EditUserData();
    public String RemoveUser();
    public String ShowSpecificUserData();
    public String ShowAllUsersData();
    public String ShowTransactions(int AcNo);
    public String AddMoney(int AcNo);
    public String TransferMoney(int AcNo);

}
