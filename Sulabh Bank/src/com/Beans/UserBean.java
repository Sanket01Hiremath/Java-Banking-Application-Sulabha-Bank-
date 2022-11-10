package com.Beans;

public class UserBean {
    private int userId;
    private int accountNo;
    private String firstName;
    private String lastName;
    private String address;
    private int areaCode;
    private String username;
    private String password;

    public UserBean(int userId, int accountNo, String firstName, String lastName, String address, int areaCode, String username, String password) {
        this.userId = userId;
        this.accountNo = accountNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.areaCode = areaCode;
        this.username = username;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
