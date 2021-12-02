package com.patikadev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Example extends JFrame {
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JTextField textName;
    private JPasswordField passwordField1;
    private JButton girişYapButton;

    public Example(){
        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            if("Nimbus".equals(info.getName())){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
            }
        }
        setContentPane(wrapper);
        setSize(400,300);
        setTitle("Uygulama Adı");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false); //uygulama boyutu sabitleme

        int x= (Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2;
        int y= (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2;
        setLocation(x,y);
        setVisible(true);

        girişYapButton.addActionListener(e -> {
            if(textName.getText().length() == 0 || passwordField1.getText().length() ==0){
                JOptionPane.showMessageDialog(null,"Tüm Alanları Doldurun!","Hata",JOptionPane.INFORMATION_MESSAGE);
            }
            
            //   System.out.println(textName.getText());  bu satır giriş yap butonu aktif ediyor.
        });
    }

}
