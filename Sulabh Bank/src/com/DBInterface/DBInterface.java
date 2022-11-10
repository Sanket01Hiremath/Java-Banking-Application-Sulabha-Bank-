package com.DBInterface;

import com.Beans.UserBean;

public interface DBInterface {
    public Boolean ConnectToDB(String username,String password);
    public Boolean ConnectUserToDB(String username,String password);
    public String CreateUserBean();
    public String CreateUser(UserBean userBean);
    public String EditUserData();
    public String RemoveUser();
    public String ShowSpecificUserData();
    public String ShowAllUsersData();
}
