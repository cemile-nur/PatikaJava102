package com.patikadev.Model;

public class Educator extends User {
    public Educator() {
    }

    public Educator(int id, String user_name, String user_nickname, String password, String type) {
        super(id, user_name, user_nickname, password, type);
    }
}
