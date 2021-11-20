package com.company;

public class Individual extends Account{

    public Individual(User user) {
        super(user);
    }

    @Override
    public boolean addInsurance(Insurance insurance) {
        return false;
    }

    @Override
    public int compareTo( Account o) {
        return o.getUser().getUserName().charAt(0);
    }
}
