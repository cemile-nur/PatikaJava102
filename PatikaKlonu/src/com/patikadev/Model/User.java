package com.patikadev.Model;

import com.patikadev.Helper.DBConnector;
import com.patikadev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {

    private int id;
    private String user_name, user_nickname,password,type;

    public User() {

    }

    public User(int id, String user_name, String user_nickname, String password, String type) {
        this.id = id;
        this.user_name = user_name;
        this.user_nickname = user_nickname;
        this.password = password;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static ArrayList<User> getList(){
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * From user";
        User object;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                object = new User();
                object.setId(rs.getInt("id"));
                object.setUser_name(rs.getString("user_name"));
                object.setUser_nickname(rs.getString("user_nickname"));
                object.setPassword(rs.getString("password"));
                object.setType(rs.getString("type"));
                userList.add(object);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    public static boolean add(String user_name , String user_nickname , String password , String type){
        String query = "INSERT INTO user (user_name,user_nickname,password,type) VALUES (?,?,?,?)";
        User findUser= User.getFetch(user_nickname);
        if(findUser != null){
            Helper.showMessage("Bu kullanıcı adı kullanılamaz !");
            return false;
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,user_name);
            pr.setString(2,user_nickname);
            pr.setString(3,password);
            pr.setString(4,type);

            int response = pr.executeUpdate();
            if(response == -1){
                Helper.showMessage("error");
            }
            return response != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return  true;
    }

    public static User getFetch(String user_nickname){
        User obj = null;
        String query = "SELECT * FROM user WHERE user_nickname = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,user_nickname);
            ResultSet rs =pr.executeQuery();
             if(rs.next()){
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setUser_name(rs.getString("user_name"));
                obj.setUser_nickname(rs.getString("user_nickname"));
                obj.setPassword(rs.getString("password"));
                obj.setType(rs.getString("type"));

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }

    public static boolean deleteFuncition(int id){
        String query = "DELETE FROM user WHERE id = ?";
        try {
            PreparedStatement pr =DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

}
