package com.company;

import java.util.ArrayList;
import java.util.Date;

public class User {

    private String userName, userLastName, userEmail, userCareer;
    private int userPassword, userAge;
    private Date lastLoginDate ;
    ArrayList<String> addressList = new ArrayList<>();

    public User(String userName, String userLastName, String userEmail, String userCareer, int userPassword, int userAge, Date lastLoginDate) {
        this.userName = userName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userCareer = userCareer;
        this.userPassword = userPassword;
        this.userAge = userAge;
        this.lastLoginDate = lastLoginDate;
        this.addressList= addressList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserCareer() {
        return userCareer;
    }

    public void setUserCareer(String userCareer) {
        this.userCareer = userCareer;
    }

    public int getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(int userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

}
