package com.Beans;

public class RegistrationBean {
    private String FirstName;
    private String LastName;
    private String Address;
    private int AreaCode;

    public RegistrationBean(String firstName, String lastName, String address, int areaCode) {
        FirstName = firstName;
        LastName = lastName;
        Address = address;
        AreaCode = areaCode;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getAreaCode() {
        return AreaCode;
    }

    public void setAreaCode(int areaCode) {
        AreaCode = areaCode;
    }
}
