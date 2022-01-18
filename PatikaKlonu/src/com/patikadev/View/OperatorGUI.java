package com.patikadev.View;
import com.patikadev.Helper.*;
import com.patikadev.Model.Course;
import com.patikadev.Model.Operator;
import com.patikadev.Model.Patika;
import com.patikadev.Model.User;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class OperatorGUI extends JFrame{

    private JPanel wrapper;
    private JPanel pnl_top;
    private JLabel lbl_welcome;
    private JButton btn_exit;
    private JTabbedPane tab_operator;
    private JPanel pnl_userList;
    private JScrollPane scrl_userList;
    private JTable tbl_userList;
    private JPanel pnl_userForm;
    private JTextField fld_userName;
    private JTextField fld_user_Nickname;
    private JPasswordField fld_password;
    private JComboBox cmb_userType;
    private JButton btn_userAdd;
    private JTextField fld_user_id;
    private JButton btn_user_delete;
    private JTextField fld_search_username;
    private JTextField fld_search_userNickname;
    private JComboBox cmb_search_type;
    private JButton btn_search_user;
    private JScrollPane scr_patikaList;
    private JPanel pnl_patikaList;
    private JTable tbl_patikaList;
    private JPanel pnl_patikaAdd;
    private JTextField fld_patikaName;
    private JButton btn_patikaAdd;
    private JPanel pnl_courseList;
    private JScrollPane scrl_courseList;
    private JTable tbl_courseList;
    private JPanel pnl_courseAdd;
    private JTextField fld_courseName;
    private JTextField fld_courseLanguage;
    private JComboBox cmb_coursePatika;
    private JComboBox cmb_courseUser;
    private JButton btn_courseAdd;
    private DefaultTableModel mdl_userList;
    private Object[] row_userList;
    private DefaultTableModel mdl_patikaList;
    private Object[] row_patikaList;
    private JPopupMenu patikaMenu;
    private DefaultTableModel mdl_courseList;
    private Object[] row_courseList;


    private final Operator operator;

    public OperatorGUI(Operator operator) {
        this.operator = operator;
        add(wrapper);
        setSize(1000, 500);

        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        lbl_welcome.setText("Hoş Geldin " + operator.getUser_nickname());

        //ModelUserList
        mdl_userList = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0){
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_UserList = {"ID", "Ad Soyad", "Kullanıcı Adı", "Şifre", "Üyelik Tipi"};
        mdl_userList.setColumnIdentifiers(col_UserList);

        row_userList = new Object[col_UserList.length];
        loadUserModel();


        tbl_userList.setModel(mdl_userList);
        tbl_userList.getTableHeader().setReorderingAllowed(false);

        tbl_userList.getSelectionModel().addListSelectionListener(e -> {

            try{
                String select_userId = tbl_userList.getValueAt(tbl_userList.getSelectedRow(),0).toString();
                fld_user_id.setText(select_userId);
            }catch (Exception exception){

            }
        });

        tbl_userList.getModel().addTableModelListener(e -> {
            if(e.getType() == TableModelEvent.UPDATE){
                int id= Integer.parseInt(tbl_userList.getValueAt(tbl_userList.getSelectedRow(),0).toString());
                String user_name= tbl_userList.getValueAt(tbl_userList.getSelectedRow(),1).toString();
                String user_nickname= tbl_userList.getValueAt(tbl_userList.getSelectedRow(),2).toString();
                String password= tbl_userList.getValueAt(tbl_userList.getSelectedRow(),3).toString();
                String type= tbl_userList.getValueAt(tbl_userList.getSelectedRow(),4).toString();

                if (User.updateFunction(id, user_name, user_nickname,password,type)){
                    Helper.showMessage("success");
                }
                loadUserModel();
            }

        });


        //PatikaList
        patikaMenu = new JPopupMenu();
        JMenuItem updateMenu = new JMenuItem("Güncelle");
        JMenuItem deleteMenu = new JMenuItem("Sil");
        patikaMenu.add(updateMenu);
        patikaMenu.add(deleteMenu);

        updateMenu.addActionListener(e -> {
            int select_id= Integer.parseInt(tbl_patikaList.getValueAt(tbl_patikaList.getSelectedRow(),0).toString());
            UpdatePatikaGUI updateGUI = new UpdatePatikaGUI(Patika.getFetch(select_id));
            updateGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadPatikaModel();
                    loadPatikaCombo();
                }
            });
        });

        deleteMenu.addActionListener(e -> {
            if (Helper.confirm("sure")){
                int select_id= Integer.parseInt(tbl_patikaList.getValueAt(tbl_patikaList.getSelectedRow(),0).toString());
                if (Patika.delete(select_id)){
                    Helper.showMessage("success");
                    loadPatikaModel();
                    loadPatikaCombo();
                }else{
                    Helper.showMessage("error");
                }
            }

        });

        mdl_patikaList = new DefaultTableModel();
        Object[] col_patikaList = {"ID", "Patika Adı"};
        mdl_patikaList.setColumnIdentifiers(col_patikaList);
        row_patikaList = new Object[col_patikaList.length];
        loadPatikaModel();

        tbl_patikaList.setModel(mdl_patikaList);
        tbl_patikaList.setComponentPopupMenu(patikaMenu);
        tbl_patikaList.getTableHeader().setReorderingAllowed(false);
        tbl_patikaList.getColumnModel().getColumn(0).setMaxWidth(75);

        tbl_patikaList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selected_row = tbl_patikaList.rowAtPoint(point);
                tbl_patikaList.setRowSelectionInterval(selected_row,selected_row);
            }
        });
        // ###PatikaList

        //CourseList
        mdl_courseList = new DefaultTableModel();
        Object[] col_courseList = {"ID", "Ders Adı","Programlama Dili","Patika","Eğitmen"};
        mdl_courseList.setColumnIdentifiers(col_courseList);
        row_courseList = new Object[col_courseList.length];
        loadCourseModel();

        tbl_courseList.setModel(mdl_courseList);
        tbl_courseList.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_courseList.getTableHeader().setReorderingAllowed(false);

        loadPatikaCombo();
        loadEducatorCombo();

        //##CourseList

        btn_userAdd.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_userName) || Helper.isFieldEmpty(fld_user_Nickname) || Helper.isFieldEmpty(fld_password)) {
                Helper.showMessage("fill");
            } else {
                String user_name = fld_userName.getText();
                String user_nickname = fld_user_Nickname.getText();
                String password = fld_password.getText();
                String type = cmb_userType.getSelectedItem().toString();

                if (User.add(user_name, user_nickname, password, type)) {
                    Helper.showMessage("success");
                    loadUserModel();
                    fld_userName.setText(null);
                    fld_user_Nickname.setText(null);
                    fld_password.setText(null);
                }
            }
        });


        btn_user_delete.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_user_id)){
                Helper.showMessage("fill");
            }else{
                if(Helper.confirm("sure")){
                    int userId = Integer.parseInt(fld_user_id.getText());
                    if (User.deleteFunction(userId)){
                        Helper.showMessage("success");
                        loadUserModel();
                    }else {
                        Helper.showMessage("error");
                    }
                }
            }
        });
        btn_search_user.addActionListener(e -> {
            String user_name = fld_search_username.getText();
            String user_nickname=fld_search_userNickname.getText();
            String type=cmb_search_type.getSelectedItem().toString();
            String query =User.searchQuery(user_name,user_nickname,type);
            loadUserModel(User.searchUserList(query));
        });
        btn_exit.addActionListener(e -> {
            dispose();
        });

        //Patika Ekleme Butonu
        btn_patikaAdd.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_patikaName)){
                Helper.showMessage("fill");
            }else {
                if (Patika.add(fld_patikaName.getText())){
                    Helper.showMessage("success");
                    loadPatikaModel();
                    loadPatikaCombo();
                    fld_patikaName.setText(null);
                }else {
                    Helper.showMessage("error");
                }
            }
        });

        //Kurs ekleme butonu
        btn_courseAdd.addActionListener(e -> {
            Item patikaItem = (Item) cmb_coursePatika.getSelectedItem();
            Item userItem = (Item) cmb_courseUser.getSelectedItem();
            if(Helper.isFieldEmpty(fld_courseName) || Helper.isFieldEmpty(fld_courseLanguage)){
                Helper.showMessage("fill");
            }else{
                if(Course.add(userItem.getKey(), patikaItem.getKey(), fld_courseName.getText(),fld_courseLanguage.getText())){
                    Helper.showMessage("success");
                    loadCourseModel();
                }else{
                    Helper.showMessage("error");
                }
            }

        });
    }


    private void loadPatikaCombo() {
        cmb_coursePatika.removeAllItems();
        for (Patika obj: Patika.getList()){
            cmb_coursePatika.addItem(new Item(obj.getId(),obj.getName()));
        }
    }

    public void loadEducatorCombo(){
        cmb_courseUser.removeAllItems();
        for (User obj: User.getListOnlyEducator()){

            cmb_courseUser.addItem(new Item(obj.getId(), obj.getUser_name()));

        }
    }

    private void loadCourseModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_courseList.getModel();
        clearModel.setRowCount(0);
        int i =0;
        for (Course obj: Course.getList()){
            i=0;
            row_courseList[i++] =obj.getId();
            row_courseList[i++] =obj.getName();
            row_courseList[i++] =obj.getLanguage();
            row_courseList[i++]= obj.getPatika().getName();
            row_courseList[i++] =obj.getUser().getUser_name();
            mdl_courseList.addRow(row_courseList);
        }
    }

    private void loadPatikaModel(){
        DefaultTableModel clearModel = (DefaultTableModel) tbl_patikaList.getModel();
        clearModel.setRowCount(0);
        int i=0;
        for (Patika obj : Patika.getList()){
            i=0;
            row_patikaList[i++] = obj.getId();
            row_patikaList[i++] = obj.getName();
            mdl_patikaList.addRow(row_patikaList);
        }
    }

    public void loadUserModel(){
            DefaultTableModel clearModel = (DefaultTableModel)  tbl_userList.getModel();
            clearModel.setRowCount(0);
            int i=0;
            for (User obj : User.getListOnlyEducator()) {
                 i = 0;
                row_userList[i++] = obj.getId();
                row_userList[i++] = obj.getUser_name();
                row_userList[i++] = obj.getUser_nickname();
                row_userList[i++] = obj.getPassword();
                row_userList[i++] = obj.getType();
                mdl_userList.addRow(row_userList);
            }
    }

    public void loadUserModel(ArrayList<User> list){
        DefaultTableModel clearModel = (DefaultTableModel)  tbl_userList.getModel();
        clearModel.setRowCount(0);
        int i=0;
        for (User obj : list) {
             i = 0;
            row_userList[i++] = obj.getId();
            row_userList[i++] = obj.getUser_name();
            row_userList[i++] = obj.getUser_nickname();
            row_userList[i++] = obj.getPassword();
            row_userList[i++] = obj.getType();
            mdl_userList.addRow(row_userList);
        }
    }
}




