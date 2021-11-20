package com.company;

public class AddressManager {

    public static void addAddress(Account account, Address address)  {
        account.addAddress(address);
    }

    public static void deleteAddress(Account account, Address address) {
        account.deleteAddress(address);
    }
}
