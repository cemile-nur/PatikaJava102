package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Educator;
import com.patikadev.Model.Operator;
import com.patikadev.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JTextField fld_user_nickName;
    private JPasswordField fld_user_password;
    private JButton btn_login;

    public LoginGUI(){
        add(wrapper);
        setSize(600,600);
        setLocation(Helper.screenCenterPoint("x",getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        btn_login.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_user_nickName) || Helper.isFieldEmpty(fld_user_password)){
                Helper.showMessage("fill");
            }else{
                User u = User.getFetch(fld_user_nickName.getText(),fld_user_password.getText());
                if(u == null){
                    Helper.showMessage("Kullanıcı Bulunamadı!");
                }else{
                    switch (u.getType()){
                        case "Operator":
                            Operator op = new Operator();
                            OperatorGUI opGUI = new OperatorGUI(op);
                            break;
                        case "Educator":
                            EducatorGUI edGUI= new EducatorGUI();
                            break;
                        case "Student":
                            StudentGUI stGUI =new StudentGUI();
                            break;
                    }
                    dispose();
                }
            }

        });
    }
}
