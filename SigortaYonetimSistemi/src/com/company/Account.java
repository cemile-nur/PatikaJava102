package com.company;

import java.lang.reflect.GenericArrayType;
import java.text.SimpleDateFormat;
import java.lang.Exception;

public abstract class Account implements  Comparable<Account>{

    private AuthenticationStatus authenticationStatus =AuthenticationStatus.Fail;
    private User user;
    public abstract  boolean addInsurance(Insurance insurance);

    public Account(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void login(String email, String password) throws InvalidAuthenticationException {
        if (user.getUserEmail().equals(email) && user.getUserPassword().equals(password))
            authenticationStatus = AuthenticationStatus.Success;
        else throw new InvalidAuthenticationException("Incorrect email or password");
    }

    public final void showUserInfo(){
        SimpleDateFormat format = new SimpleDateFormat("hh:mm dd/MM/yyy");
        System.out.println("First Name: " + user.getUserName());
        System.out.println("Last Name: " + user.getUserLastName());
        System.out.println("Email: " + user.getUserEmail());
        System.out.println("Career: " + user.getUserCareer());
        System.out.println("Age: " + user.getUserAge());
        System.out.println("Last Login: " + format.format(user.getLastLoginDate()));
        System.out.println("Addresses: ");
        user.getAddressList().stream().forEach(address -> {
            System.out.println(address);
        });
    }

    public void addAddress(Address address) {
        user.getAddressList().add(address.getAddress());

    }

    public boolean deleteAddress(Address address) {
        return user.getAddressList().remove(address);
    }

}

